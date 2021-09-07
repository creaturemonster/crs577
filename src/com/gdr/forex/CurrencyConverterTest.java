package com.gdr.forex;

import java.math.BigDecimal;

import org.junit.*;
import static org.junit.Assert.*;

public class CurrencyConverterTest {

    private CurrencyConverter converter;
    
    @Before
    public void setUp(){
        converter = new CurrencyConverter();
    }
    
    @Test
    public void testUSDtoUSD() throws Exception {
        // TODO: examine the following code to see how we test a Web service method 
        //       (no changes required)

        // 1. Set up values for request message
        BigDecimal fromValue = new BigDecimal("10.5");
        Amount fromAmount = new Amount(fromValue,Currency.USD);
        
        // 2. Call the method being tested and save the result
        Amount result = converter.getConvertedAmount(fromAmount, Currency.USD);
        
        // 3. Verify that the actual result equals the expected result
        Currency expectedCurrency = Currency.USD;
        BigDecimal expectedAmount = new BigDecimal("10.50");
        assertEquals(expectedCurrency, result.getCurrency());
        assertEquals(expectedAmount, result.getValue());
    }

    @Test
    public void testUSDtoEuro() throws Exception {
        converter.setUsdConversionRate(Currency.EUR, new BigDecimal("2.0"));
        Amount fromAmount = new Amount(new BigDecimal("200"), Currency.USD);
        
        Amount result = converter.getConvertedAmount(fromAmount, Currency.EUR);
        
        assertEquals(Currency.EUR, result.getCurrency());
        assertEquals(new BigDecimal("100.00"), result.getValue());
    }
    
    @Test
    public void testEURtoUSD() throws Exception {
        converter.setUsdConversionRate(Currency.EUR, new BigDecimal("1.10"));
        // set up
    	Amount fromAmount = new Amount(new BigDecimal("100.00"), Currency.EUR);
    	Amount expectedResult = new Amount(new BigDecimal("110.00"), Currency.USD);

    	// call method being tested
        Amount result = converter.getConvertedAmount(fromAmount, Currency.USD);
        
        // verify expected results
    	assertEquals(expectedResult, result);
    }
    
    // TODO: examine the following code to see how we verify that a Web service method 
    //       throws the correct exception when input values are invalid 
    //       (no code changes required)
    // 1. The Web service method should throw an IllegalArgumentException
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeAmount() throws Exception {
        
        // 2. Create an input with an invalid value (-1.00)
        Amount badAmount = new Amount(new BigDecimal("-1.00"), Currency.USD);
        
        // 3. Call the method with an invalid value and verify the resulting exception
        converter.getConvertedAmount(badAmount, Currency.EUR);
    }

    
    @Test(expected=CurrencyLookupException.class)
    public void testUnsupportedCurrency() throws Exception {
        Amount fromAmount = new Amount(new BigDecimal("100"), Currency.USD);
        
        converter.getConvertedAmount(fromAmount, Currency.JPY);
    }
}
