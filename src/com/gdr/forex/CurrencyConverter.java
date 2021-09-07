package com.gdr.forex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

// TODO: Mark this class as a web service
@WebService
public class CurrencyConverter {

        /** Initializes the CurrencyConverter */
        public CurrencyConverter() {
            initConversionRates();
        }

        /**
         * Convert value from one currency to another.
         */
        // TODO: Note that the public getConvertAmount() method will be exposed
        //       as a Web service operation
        //       (no changes required)
        public Amount getConvertedAmount(Amount from, Currency toCurrency) 
                        throws CurrencyLookupException {
            BigDecimal value = from.getValue();
            double fromValue = value.doubleValue();
            // TODO: if the "from" value is less than zero or greater than one billion,
            //       throw an IllegalArgumentException 
            if(fromValue  < 0 || fromValue > 1000000000) {
            	throw new IllegalArgumentException();
            }
            BigDecimal rate = getConversionRate(from.getCurrency(), toCurrency);
            BigDecimal convertedValue = rate.multiply(from.getValue());
            convertedValue = convertedValue.setScale(2, RoundingMode.HALF_UP);
			Amount amt = new Amount(convertedValue, toCurrency);
            return amt;
        }

        /** 
         *  Returns the conversion rate for one unit of fromCurrency to toCurrency.
         *  For example, if fromCurrency is EUR and toCurrency is SEK,
         *  will get the number of Swedish Kroners for one Euro.
         *  @throws CurrencyLookupException 
         */
        public BigDecimal getConversionRate(Currency fromCurrency, Currency toCurrency) 
                throws CurrencyLookupException {
            verifyNonNullArg(fromCurrency, "fromCurrency");
            verifyNonNullArg(toCurrency, "toCurrency");
            BigDecimal numDollarsFrom = getUSDPerUnitOf(fromCurrency);
            BigDecimal numDollarsTo   = getUSDPerUnitOf(toCurrency);
            return numDollarsFrom.divide(numDollarsTo, new MathContext(3, RoundingMode.HALF_UP));
        }

        private BigDecimal getUSDPerUnitOf(Currency fromCurrency) throws CurrencyLookupException {
            verifyNonNullArg(fromCurrency, "fromCurrency");
            BigDecimal usdPerUnitOf = usdConversionRateMap.get(fromCurrency);
            if (usdPerUnitOf == null) {
                throw new CurrencyLookupException("No conversion rate found for currency", fromCurrency);
            }
            return usdPerUnitOf;
        }
        
        /**
         * Allows unit tests to set predictable conversion rates.
         * @param currency the currency that US dollars are being converted to
         * @param rate how many US dollars for each unit of currency 
         */
        @WebMethod(exclude=true) // don't expose this method as a web service operation (details in chapter 3) 
        public synchronized void setUsdConversionRate(Currency currency, BigDecimal rate) {
            usdConversionRateMap.put(currency, rate);
        }
        
        private void verifyNonNullArg(Object arg, String argName) {
            if (arg == null) {
                throw new IllegalArgumentException(argName);
            }
        }

        private void initConversionRates() {
            usdConversionRateMap = new HashMap<>();
            usdConversionRateMap.put(Currency.EUR, new BigDecimal("1.11"));
            usdConversionRateMap.put(Currency.INR, new BigDecimal("0.015"));
            usdConversionRateMap.put(Currency.SEK, new BigDecimal("0.12"));
            usdConversionRateMap.put(Currency.USD, new BigDecimal("1.0"));
        }
        
        private Map<Currency, BigDecimal> usdConversionRateMap;
    }
