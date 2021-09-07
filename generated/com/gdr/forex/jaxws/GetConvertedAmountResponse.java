
package com.gdr.forex.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getConvertedAmountResponse", namespace = "http://forex.gdr.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConvertedAmountResponse", namespace = "http://forex.gdr.com/")
public class GetConvertedAmountResponse {

    @XmlElement(name = "return", namespace = "")
    private com.gdr.forex.Amount _return;

    /**
     * 
     * @return
     *     returns Amount
     */
    public com.gdr.forex.Amount getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.gdr.forex.Amount _return) {
        this._return = _return;
    }

}
