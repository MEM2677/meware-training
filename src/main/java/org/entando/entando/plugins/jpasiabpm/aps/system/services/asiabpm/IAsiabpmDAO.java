/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm;

import java.util.List;

import com.agiletec.aps.system.common.FieldSearchFilter;

public interface IAsiabpmDAO {

	public List<Integer> searchAsiabpms(FieldSearchFilter[] filters);
	
	public Asiabpm loadAsiabpm(int id);

	public List<Integer> loadAsiabpms();

	public void removeAsiabpm(int id);
	
	public void updateAsiabpm(Asiabpm asiabpm);

	public void insertAsiabpm(Asiabpm asiabpm);
	

}