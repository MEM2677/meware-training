/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.apsadmin.asiabpm;

import java.util.List;
import org.apache.commons.lang.StringUtils;

import com.agiletec.aps.system.common.FieldSearchFilter;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.Asiabpm;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.IAsiabpmManager;
import com.agiletec.apsadmin.system.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsiabpmFinderAction extends BaseAction {

	private static final Logger _logger =  LoggerFactory.getLogger(AsiabpmFinderAction.class);

	public List<Integer> getAsiabpmsId() {
		try {
			FieldSearchFilter[] filters = new FieldSearchFilter[0];
			if (null != this.getId()) {
				//TODO add a constant into your IAsiabpmManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("id"), this.getId(), false);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (StringUtils.isNotBlank(this.getAfield())) {
				//TODO add a constant into your IAsiabpmManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("afield"), this.getAfield(), true);
				filters = this.addFilter(filters, filterToAdd);
			}
			List<Integer> asiabpms = this.getAsiabpmManager().searchAsiabpms(filters);
			return asiabpms;
		} catch (Throwable t) {
			_logger.error("Error getting asiabpms list", t);
			throw new RuntimeException("Error getting asiabpms list", t);
		}
	}

	protected FieldSearchFilter[] addFilter(FieldSearchFilter[] filters, FieldSearchFilter filterToAdd) {
		int len = filters.length;
		FieldSearchFilter[] newFilters = new FieldSearchFilter[len + 1];
		for(int i=0; i < len; i++){
			newFilters[i] = filters[i];
		}
		newFilters[len] = filterToAdd;
		return newFilters;
	}

	public Asiabpm getAsiabpm(int id) {
		Asiabpm asiabpm = null;
		try {
			asiabpm = this.getAsiabpmManager().getAsiabpm(id);
		} catch (Throwable t) {
			_logger.error("Error getting asiabpm with id {}", id, t);
			throw new RuntimeException("Error getting asiabpm with id " + id, t);
		}
		return asiabpm;
	}


	public Integer getId() {
		return _id;
	}
	public void setId(Integer id) {
		this._id = id;
	}


	public String getAfield() {
		return _afield;
	}
	public void setAfield(String afield) {
		this._afield = afield;
	}


	protected IAsiabpmManager getAsiabpmManager() {
		return _asiabpmManager;
	}
	public void setAsiabpmManager(IAsiabpmManager asiabpmManager) {
		this._asiabpmManager = asiabpmManager;
	}
	
	private Integer _id;
	private String _afield;
	private IAsiabpmManager _asiabpmManager;
}