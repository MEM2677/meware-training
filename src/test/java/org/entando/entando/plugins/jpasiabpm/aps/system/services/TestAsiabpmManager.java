/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services;

import org.entando.entando.plugins.jpasiabpm.aps.JpasiabpmBaseTestCase;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.IAsiabpmManager;

public class TestAsiabpmManager extends JpasiabpmBaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.init();
	}
	
	public void testGetAsiabpm() {
		//TODO complete test
		assertNotNull(this._asiabpmManager);
	}

	public void testGetAsiabpms() {
		//TODO complete test
		assertNotNull(this._asiabpmManager);
	}
	
	public void testSearchAsiabpms() {
		//TODO complete test
		assertNotNull(this._asiabpmManager);
	}

	public void testAddAsiabpm() {
		//TODO complete test
		assertNotNull(this._asiabpmManager);
	}

	public void testUpdateAsiabpm() {
		//TODO complete test
		assertNotNull(this._asiabpmManager);
	}

	public void testDeleteAsiabpm() {
		//TODO complete test
		assertNotNull(this._asiabpmManager);
	}
	
	private void init() {
		//TODO add the spring bean id as constant
		this._asiabpmManager = (IAsiabpmManager) this.getService("jpasiabpmAsiabpmManager");
	}
	
	private IAsiabpmManager _asiabpmManager;
}

