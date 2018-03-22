/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.event;

import com.agiletec.aps.system.common.IManager;
import com.agiletec.aps.system.common.notify.ApsEvent;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.Asiabpm;


public class AsiabpmChangedEvent extends ApsEvent {
	
	@Override
	public void notify(IManager srv) {
		((AsiabpmChangedObserver) srv).updateFromAsiabpmChanged(this);
	}
	
	@Override
	public Class getObserverInterface() {
		return AsiabpmChangedObserver.class;
	}
	
	public int getOperationCode() {
		return _operationCode;
	}
	public void setOperationCode(int operationCode) {
		this._operationCode = operationCode;
	}
	
	public Asiabpm getAsiabpm() {
		return _asiabpm;
	}
	public void setAsiabpm(Asiabpm asiabpm) {
		this._asiabpm = asiabpm;
	}

	private Asiabpm _asiabpm;
	private int _operationCode;
	
	public static final int INSERT_OPERATION_CODE = 1;
	public static final int REMOVE_OPERATION_CODE = 2;
	public static final int UPDATE_OPERATION_CODE = 3;

}
