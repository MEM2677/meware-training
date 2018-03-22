/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.apsadmin.asiabpm;

import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.Asiabpm;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.IAsiabpmManager;



import com.agiletec.apsadmin.system.ApsAdminSystemConstants;
import com.agiletec.apsadmin.system.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsiabpmAction extends BaseAction {

	private static final Logger _logger =  LoggerFactory.getLogger(AsiabpmAction.class);

	public String newAsiabpm() {
		try {
			this.setStrutsAction(ApsAdminSystemConstants.ADD);
		} catch (Throwable t) {
			_logger.error("error in newAsiabpm", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String edit() {
		try {
			Asiabpm asiabpm = this.getAsiabpmManager().getAsiabpm(this.getId());
			if (null == asiabpm) {
				this.addActionError(this.getText("error.asiabpm.null"));
				return INPUT;
			}
			this.populateForm(asiabpm);
			this.setStrutsAction(ApsAdminSystemConstants.EDIT);
		} catch (Throwable t) {
			_logger.error("error in edit", t);
			return FAILURE;
		}
		return SUCCESS;
	}

	public String save() {
		try {
			Asiabpm asiabpm = this.createAsiabpm();
			int strutsAction = this.getStrutsAction();
			if (ApsAdminSystemConstants.ADD == strutsAction) {
				this.getAsiabpmManager().addAsiabpm(asiabpm);
			} else if (ApsAdminSystemConstants.EDIT == strutsAction) {
				this.getAsiabpmManager().updateAsiabpm(asiabpm);
			}
		} catch (Throwable t) {
			_logger.error("error in save", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String trash() {
		try {
			Asiabpm asiabpm = this.getAsiabpmManager().getAsiabpm(this.getId());
			if (null == asiabpm) {
				this.addActionError(this.getText("error.asiabpm.null"));
				return INPUT;
			}
			this.populateForm(asiabpm);
			this.setStrutsAction(ApsAdminSystemConstants.DELETE);
		} catch (Throwable t) {
			_logger.error("error in trash", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String delete() {
		try {
			if (this.getStrutsAction() == ApsAdminSystemConstants.DELETE) {
				this.getAsiabpmManager().deleteAsiabpm(this.getId());
			}
		} catch (Throwable t) {
			_logger.error("error in delete", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String view() {
		try {
			Asiabpm asiabpm = this.getAsiabpmManager().getAsiabpm(this.getId());
			if (null == asiabpm) {
				this.addActionError(this.getText("error.asiabpm.null"));
				return INPUT;
			}
			this.populateForm(asiabpm);
		} catch (Throwable t) {
			_logger.error("error in view", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	private void populateForm(Asiabpm asiabpm) throws Throwable {
		this.setId(asiabpm.getId());
		this.setAfield(asiabpm.getAfield());
	}
	
	private Asiabpm createAsiabpm() {
		Asiabpm asiabpm = new Asiabpm();
		asiabpm.setId(this.getId());
		asiabpm.setAfield(this.getAfield());
		return asiabpm;
	}
	

	public int getStrutsAction() {
		return _strutsAction;
	}
	public void setStrutsAction(int strutsAction) {
		this._strutsAction = strutsAction;
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
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
	
	private int _strutsAction;
	private int _id;
	private String _afield;
	
	private IAsiabpmManager _asiabpmManager;
	
}