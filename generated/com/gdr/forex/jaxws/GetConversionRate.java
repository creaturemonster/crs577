
package com.gdr.forex.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getConversionRate", namespace = "http://forex.gdr.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConversionRate", namespace = "http://forex.gdr.com/", propOrder = {
    "arg0",
    "arg1"
})
public class GetConversionRate {

    @XmlElement(name = "arg0", namespace = "")
    private com.gdr.forex.Currency arg0;
    @XmlElement(name = "arg1", namespace = "")
    private com.gdr.forex.Currency arg1;

    /**
     * 
     * @return
     *     returns Currency
     */
    public com.gdr.forex.Currency getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.gdr.forex.Currency arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns Currency
     */
    public com.gdr.forex.Currency getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(com.gdr.forex.Currency arg1) {
        this.arg1 = arg1;
    }

}
