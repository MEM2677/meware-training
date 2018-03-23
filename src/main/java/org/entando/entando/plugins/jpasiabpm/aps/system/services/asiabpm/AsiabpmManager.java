/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm;

import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.event.AsiabpmChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Response;
import org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm.api.JAXBAsiabpm;
import org.entando.entando.aps.system.services.api.IApiErrorCodes;
import org.entando.entando.aps.system.services.api.model.ApiException;

import com.agiletec.aps.system.common.FieldSearchFilter;
import com.agiletec.aps.system.common.AbstractService;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.services.keygenerator.IKeyGeneratorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsiabpmManager extends AbstractService implements IAsiabpmManager {

	private static final Logger _logger =  LoggerFactory.getLogger(AsiabpmManager.class);

	@Override
	public void init() throws Exception {
		_logger.debug("{} ready.", this.getClass().getName());
	}
 
	@Override
	public Asiabpm getAsiabpm(int id) throws ApsSystemException {
		Asiabpm asiabpm = null;
		try {
			
		} catch (Throwable t) {
			_logger.error("Error loading asiabpm with id '{}'", id,  t);
			throw new ApsSystemException("Error loading asiabpm with id: " + id, t);
		}
		return asiabpm;
	}

	@Override
	public List<Integer> getAsiabpms() throws ApsSystemException {
		List<Integer> asiabpms = new ArrayList<Integer>();
		try {
			
		} catch (Throwable t) {
			_logger.error("Error loading Asiabpm list",  t);
			throw new ApsSystemException("Error loading Asiabpm ", t);
		}
		return asiabpms;
	}

	@Override
	public List<Integer> searchAsiabpms(FieldSearchFilter filters[]) throws ApsSystemException {
		List<Integer> asiabpms = new ArrayList<Integer>();
		try {
			
		} catch (Throwable t) {
			_logger.error("Error searching Asiabpms", t);
			throw new ApsSystemException("Error searching Asiabpms", t);
		}
		return asiabpms;
	}

	@Override
	public void addAsiabpm(Asiabpm asiabpm) throws ApsSystemException {
		try {
			
			this.notifyAsiabpmChangedEvent(asiabpm, AsiabpmChangedEvent.INSERT_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error adding Asiabpm", t);
			throw new ApsSystemException("Error adding Asiabpm", t);
		}
	}
 
	@Override
	public void updateAsiabpm(Asiabpm asiabpm) throws ApsSystemException {
		try {
			
			this.notifyAsiabpmChangedEvent(asiabpm, AsiabpmChangedEvent.UPDATE_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error updating Asiabpm", t);
			throw new ApsSystemException("Error updating Asiabpm " + asiabpm, t);
		}
	}

	@Override
	public void deleteAsiabpm(int id) throws ApsSystemException {
		try {
			Asiabpm asiabpm = this.getAsiabpm(id);
			
			this.notifyAsiabpmChangedEvent(asiabpm, AsiabpmChangedEvent.REMOVE_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error deleting Asiabpm with id {}", id, t);
			throw new ApsSystemException("Error deleting Asiabpm with id:" + id, t);
		}
	}


	/**
	 * GET http://localhost:8080/<portal>/api/rs/en/asiabpms?
	 * @param properties
	 * @return
	 * @throws Throwable
	 */
	public List<JAXBAsiabpm> getAsiabpmsForApi(Properties properties) throws Throwable {
		List<JAXBAsiabpm> list = new ArrayList<JAXBAsiabpm>();
		List<Integer> idList = this.getAsiabpms();
		if (null != idList && !idList.isEmpty()) {
			Iterator<Integer> asiabpmIterator = idList.iterator();
			while (asiabpmIterator.hasNext()) {
				int currentid = asiabpmIterator.next();
				Asiabpm asiabpm = this.getAsiabpm(currentid);
				if (null != asiabpm) {
					list.add(new JAXBAsiabpm(asiabpm));
				}
			}
		}
		return list;
	}

	/**
	 * GET http://localhost:8080/<portal>/api/rs/en/asiabpm?id=1
	 * @param properties
	 * @return
	 * @throws Throwable
	 */
    public JAXBAsiabpm getAsiabpmForApi(Properties properties) throws Throwable {
        String idString = properties.getProperty("id");
        int id = 0;
		JAXBAsiabpm jaxbAsiabpm = null;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new ApiException(IApiErrorCodes.API_PARAMETER_VALIDATION_ERROR, "Invalid Integer format for 'id' parameter - '" + idString + "'", Response.Status.CONFLICT);
        }
        Asiabpm asiabpm = this.getAsiabpm(id);
        if (null == asiabpm) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Asiabpm with id '" + idString + "' does not exist", Response.Status.CONFLICT);
        }
        jaxbAsiabpm = new JAXBAsiabpm(asiabpm);
        return jaxbAsiabpm;
    }

    /**
     * POST Content-Type: application/xml http://localhost:8080/<portal>/api/rs/en/asiabpm 
     * @param jaxbAsiabpm
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void addAsiabpmForApi(JAXBAsiabpm jaxbAsiabpm) throws ApiException, ApsSystemException {
        if (null != this.getAsiabpm(jaxbAsiabpm.getId())) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Asiabpm with id " + jaxbAsiabpm.getId() + " already exists", Response.Status.CONFLICT);
        }
        Asiabpm asiabpm = jaxbAsiabpm.getAsiabpm();
        this.addAsiabpm(asiabpm);
    }

    /**
     * PUT Content-Type: application/xml http://localhost:8080/<portal>/api/rs/en/asiabpm 
     * @param jaxbAsiabpm
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void updateAsiabpmForApi(JAXBAsiabpm jaxbAsiabpm) throws ApiException, ApsSystemException {
        if (null == this.getAsiabpm(jaxbAsiabpm.getId())) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Asiabpm with id " + jaxbAsiabpm.getId() + " does not exist", Response.Status.CONFLICT);
        }
        Asiabpm asiabpm = jaxbAsiabpm.getAsiabpm();
        this.updateAsiabpm(asiabpm);
    }

    /**
     * DELETE http://localhost:8080/<portal>/api/rs/en/asiabpm?id=1
	 * @param properties
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void deleteAsiabpmForApi(Properties properties) throws Throwable {
        String idString = properties.getProperty("id");
        int id = 0;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new ApiException(IApiErrorCodes.API_PARAMETER_VALIDATION_ERROR, "Invalid Integer format for 'id' parameter - '" + idString + "'", Response.Status.CONFLICT);
        }
        this.deleteAsiabpm(id);
    }

	private void notifyAsiabpmChangedEvent(Asiabpm asiabpm, int operationCode) {
		AsiabpmChangedEvent event = new AsiabpmChangedEvent();
		event.setAsiabpm(asiabpm);
		event.setOperationCode(operationCode);
		this.notifyEvent(event);
	}
        
}
