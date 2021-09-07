
package com.gdr.forex.jaxws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getConversionRateResponse", namespace = "http://forex.gdr.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConversionRateResponse", namespace = "http://forex.gdr.com/")
public class GetConversionRateResponse {

    @XmlElement(name = "return", namespace = "")
    private BigDecimal _return;

    /**
     * 
     * @return
     *     returns BigDecimal
     */
    public BigDecimal getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(BigDecimal _return) {
        this._return = _return;
    }

}
