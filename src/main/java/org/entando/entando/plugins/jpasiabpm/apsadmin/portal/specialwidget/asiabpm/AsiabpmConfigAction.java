/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.apsadmin.portal.specialwidget.asiabpm;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.apsadmin.portal.specialwidget.SimpleWidgetConfigAction;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.IAsiabpmManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsiabpmConfigAction extends SimpleWidgetConfigAction {

	private static final Logger _logger =  LoggerFactory.getLogger(AsiabpmConfigAction.class);
	
	protected String extractInitConfig() {
		String result = super.extractInitConfig();
		String id = this.getWidget().getConfig().getProperty("id");
		if (StringUtils.isNotBlank(id)) {
			this.setId(new Integer(id));
		}
		return result;
	}

	public List<Integer> getAsiabpmsId() {
		try {
			List<Integer> asiabpms = this.getAsiabpmManager().searchAsiabpms(null);
			return asiabpms;
		} catch (Throwable t) {
			_logger.error("error in getAsiabpmsId", t);
			throw new RuntimeException("Error getting asiabpms list", t);
		}
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	protected IAsiabpmManager getAsiabpmManager() {
		return _asiabpmManager;
	}
	public void setAsiabpmManager(IAsiabpmManager asiabpmManager) {
		this._asiabpmManager = asiabpmManager;
	}

	private int _id;
	private IAsiabpmManager _asiabpmManager;
}

