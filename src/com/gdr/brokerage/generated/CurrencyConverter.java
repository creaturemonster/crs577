
package com.gdr.brokerage.generated;

import java.math.BigDecimal;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CurrencyConverter", targetNamespace = "http://forex.gdr.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CurrencyConverter {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.gdr.brokerage.generated.Amount
     * @throws ConversionException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getConvertedAmount", targetNamespace = "http://forex.gdr.com/", className = "com.gdr.brokerage.generated.GetConvertedAmount")
    @ResponseWrapper(localName = "getConvertedAmountResponse", targetNamespace = "http://forex.gdr.com/", className = "com.gdr.brokerage.generated.GetConvertedAmountResponse")
    @Action(input = "http://forex.gdr.com/CurrencyConverter/getConvertedAmountRequest", output = "http://forex.gdr.com/CurrencyConverter/getConvertedAmountResponse", fault = {
        @FaultAction(className = ConversionException_Exception.class, value = "http://forex.gdr.com/CurrencyConverter/getConvertedAmount/Fault/ConversionException")
    })
    public Amount getConvertedAmount(
        @WebParam(name = "arg0", targetNamespace = "")
        Amount arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Currency arg1)
        throws ConversionException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.math.BigDecimal
     * @throws ConversionException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getConversionRate", targetNamespace = "http://forex.gdr.com/", className = "com.gdr.brokerage.generated.GetConversionRate")
    @ResponseWrapper(localName = "getConversionRateResponse", targetNamespace = "http://forex.gdr.com/", className = "com.gdr.brokerage.generated.GetConversionRateResponse")
    @Action(input = "http://forex.gdr.com/CurrencyConverter/getConversionRateRequest", output = "http://forex.gdr.com/CurrencyConverter/getConversionRateResponse", fault = {
        @FaultAction(className = ConversionException_Exception.class, value = "http://forex.gdr.com/CurrencyConverter/getConversionRate/Fault/ConversionException")
    })
    public BigDecimal getConversionRate(
        @WebParam(name = "arg0", targetNamespace = "")
        Currency arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Currency arg1)
        throws ConversionException_Exception
    ;

}
