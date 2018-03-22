/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.api;

import javax.xml.bind.annotation.XmlElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;


public class AsiabpmResponseResult extends AbstractApiResponseResult {
    
    @Override
    @XmlElement(name = "asiabpm", required = false)
    public JAXBAsiabpm getResult() {
        return (JAXBAsiabpm) this.getMainResult();
    }
    
}