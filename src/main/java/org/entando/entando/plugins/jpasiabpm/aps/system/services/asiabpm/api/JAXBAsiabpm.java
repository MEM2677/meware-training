/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.api;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.Asiabpm;

@XmlRootElement(name = "asiabpm")
@XmlType(propOrder = {"id", "afield"})
public class JAXBAsiabpm {

    public JAXBAsiabpm() {
        super();
    }

    public JAXBAsiabpm(Asiabpm asiabpm) {
		this.setId(asiabpm.getId());
		this.setAfield(asiabpm.getAfield());
    }
    
    public Asiabpm getAsiabpm() {
    	Asiabpm asiabpm = new Asiabpm();
		asiabpm.setId(this.getId());
		asiabpm.setAfield(this.getAfield());
    	return asiabpm;
    }

	@XmlElement(name = "id", required = true)
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	@XmlElement(name = "afield", required = true)
	public String getAfield() {
		return _afield;
	}
	public void setAfield(String afield) {
		this._afield = afield;
	}


	private int _id;
	private String _afield;

}
