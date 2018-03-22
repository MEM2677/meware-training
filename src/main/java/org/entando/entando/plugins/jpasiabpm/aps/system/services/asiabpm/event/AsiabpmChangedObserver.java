/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.event;

import com.agiletec.aps.system.common.notify.ObserverService;

public interface AsiabpmChangedObserver extends ObserverService {
	
	public void updateFromAsiabpmChanged(AsiabpmChangedEvent event);
	
}
