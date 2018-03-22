/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm;

import java.util.List;
import com.agiletec.aps.system.exception.ApsSystemException;

import com.agiletec.aps.system.common.FieldSearchFilter;

public interface IAsiabpmManager {

	public Asiabpm getAsiabpm(int id) throws ApsSystemException;

	public List<Integer> getAsiabpms() throws ApsSystemException;

	public List<Integer> searchAsiabpms(FieldSearchFilter filters[]) throws ApsSystemException;

	public void addAsiabpm(Asiabpm asiabpm) throws ApsSystemException;

	public void updateAsiabpm(Asiabpm asiabpm) throws ApsSystemException;

	public void deleteAsiabpm(int id) throws ApsSystemException;

}