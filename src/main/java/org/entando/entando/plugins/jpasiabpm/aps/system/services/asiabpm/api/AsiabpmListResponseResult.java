/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;
import org.entando.entando.aps.system.services.api.model.ListResponse;

@XmlSeeAlso({JAXBAsiabpm.class})
public class AsiabpmListResponseResult extends AbstractApiResponseResult {
    
    @XmlElement(name = "items", required = false)
    public ListResponse<JAXBAsiabpm> getResult() {
        if (this.getMainResult() instanceof Collection) {
            List<JAXBAsiabpm> asiabpms = new ArrayList<JAXBAsiabpm>();
            asiabpms.addAll((Collection<JAXBAsiabpm>) this.getMainResult());
            ListResponse<JAXBAsiabpm> entity = new ListResponse<JAXBAsiabpm>(asiabpms) {};
            return entity;
        }
        return null;
    }

}