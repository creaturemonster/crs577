/**
 * 
 */
package com.gdr.brokerage;

import java.math.BigDecimal;

import javax.xml.ws.BindingProvider;

import com.gdr.brokerage.generated.Amount;
import com.gdr.brokerage.generated.ConversionException_Exception;
import com.gdr.brokerage.generated.Currency;
import com.gdr.brokerage.generated.CurrencyConverter;
import com.gdr.brokerage.generated.CurrencyConverterService;

/**
 * Client application for Foreign Exchange service
 */
public class ForexClient {

    public static void main(String[] args) throws ConversionException_Exception   {
        // Use the generated code to create a CurrencyConverter
        CurrencyConverterService currencyConverterService = new CurrencyConverterService();
        CurrencyConverter converterProxy = currencyConverterService.getCurrencyConverterPort();
        
        //TODO: for Bonus steps, uncomment the following lines of code to 
        //      redirect requests to soapUI
       ((BindingProvider) converterProxy).getRequestContext().put(
               BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
              "http://localhost:7777");
        
        // Use the generated code to create an amount of 100 US Dollars
        Amount from = new Amount();
        from.setValue(new BigDecimal(100));
        from.setCurrency(Currency.USD);
        
        // Convert the amount into Euros and print out the result
        Amount result = converterProxy.getConvertedAmount(from, Currency.EUR);
        System.out.println(from.getValue() + " " + from.getCurrency() + " equals " +
				    	   result.getValue() + " " + result.getCurrency());
    }

}
