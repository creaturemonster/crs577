
package com.gdr.forex.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2.9
 * 
 */
@XmlRootElement(name = "CurrencyLookupException", namespace = "http://forex.gdr.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyLookupException", namespace = "http://forex.gdr.com/", propOrder = {
    "currency",
    "message"
})
public class CurrencyLookupExceptionBean {

    private com.gdr.forex.Currency currency;
    private String message;

    /**
     * 
     * @return
     *     returns Currency
     */
    public com.gdr.forex.Currency getCurrency() {
        return this.currency;
    }

    /**
     * 
     * @param currency
     *     the value for the currency property
     */
    public void setCurrency(com.gdr.forex.Currency currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
