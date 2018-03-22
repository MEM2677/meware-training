/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.services.asiabpm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.agiletec.aps.system.common.AbstractSearcherDAO;
import com.agiletec.aps.system.common.FieldSearchFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsiabpmDAO extends AbstractSearcherDAO implements IAsiabpmDAO {

	private static final Logger _logger =  LoggerFactory.getLogger(AsiabpmDAO.class);

	@Override
	protected String getTableFieldName(String metadataFieldKey) {
		return metadataFieldKey;
	}
	
	@Override
	protected String getMasterTableName() {
		return "jpasiabpm_asiabpm";
	}
	
	@Override
	protected String getMasterTableIdFieldName() {
		return "id";
	}
	
	@Override
	protected boolean isForceCaseInsensitiveLikeSearch() {
		return true;
	}

	@Override
	public List<Integer> searchAsiabpms(FieldSearchFilter[] filters) {
		List asiabpmsId = null;
		try {
			asiabpmsId  = super.searchId(filters);
		} catch (Throwable t) {
			_logger.error("error in searchAsiabpms",  t);
			throw new RuntimeException("error in searchAsiabpms", t);
		}
		return asiabpmsId;
	}

	@Override
	public List<Integer> loadAsiabpms() {
		List<Integer> asiabpmsId = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			stat = conn.prepareStatement(LOAD_ASIABPMS_ID);
			res = stat.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				asiabpmsId.add(id);
			}
		} catch (Throwable t) {
			_logger.error("Error loading Asiabpm list",  t);
			throw new RuntimeException("Error loading Asiabpm list", t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return asiabpmsId;
	}
	
	@Override
	public void insertAsiabpm(Asiabpm asiabpm) {
		PreparedStatement stat = null;
		Connection conn  = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.insertAsiabpm(asiabpm, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error on insert asiabpm",  t);
			throw new RuntimeException("Error on insert asiabpm", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void insertAsiabpm(Asiabpm asiabpm, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(ADD_ASIABPM);
			int index = 1;
			stat.setInt(index++, asiabpm.getId());
 			stat.setString(index++, asiabpm.getAfield());
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error on insert asiabpm",  t);
			throw new RuntimeException("Error on insert asiabpm", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void updateAsiabpm(Asiabpm asiabpm) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.updateAsiabpm(asiabpm, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error updating asiabpm {}", asiabpm.getId(),  t);
			throw new RuntimeException("Error updating asiabpm", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void updateAsiabpm(Asiabpm asiabpm, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE_ASIABPM);
			int index = 1;

 			stat.setString(index++, asiabpm.getAfield());
			stat.setInt(index++, asiabpm.getId());
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error updating asiabpm {}", asiabpm.getId(),  t);
			throw new RuntimeException("Error updating asiabpm", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void removeAsiabpm(int id) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.removeAsiabpm(id, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error deleting asiabpm {}", id, t);
			throw new RuntimeException("Error deleting asiabpm", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}
	
	public void removeAsiabpm(int id, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE_ASIABPM);
			int index = 1;
			stat.setInt(index++, id);
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error deleting asiabpm {}", id, t);
			throw new RuntimeException("Error deleting asiabpm", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	public Asiabpm loadAsiabpm(int id) {
		Asiabpm asiabpm = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			asiabpm = this.loadAsiabpm(id, conn);
		} catch (Throwable t) {
			_logger.error("Error loading asiabpm with id {}", id, t);
			throw new RuntimeException("Error loading asiabpm with id " + id, t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return asiabpm;
	}

	public Asiabpm loadAsiabpm(int id, Connection conn) {
		Asiabpm asiabpm = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			stat = conn.prepareStatement(LOAD_ASIABPM);
			int index = 1;
			stat.setInt(index++, id);
			res = stat.executeQuery();
			if (res.next()) {
				asiabpm = this.buildAsiabpmFromRes(res);
			}
		} catch (Throwable t) {
			_logger.error("Error loading asiabpm with id {}", id, t);
			throw new RuntimeException("Error loading asiabpm with id " + id, t);
		} finally {
			closeDaoResources(res, stat, null);
		}
		return asiabpm;
	}

	protected Asiabpm buildAsiabpmFromRes(ResultSet res) {
		Asiabpm asiabpm = null;
		try {
			asiabpm = new Asiabpm();				
			asiabpm.setId(res.getInt("id"));
			asiabpm.setAfield(res.getString("afield"));
		} catch (Throwable t) {
			_logger.error("Error in buildAsiabpmFromRes", t);
		}
		return asiabpm;
	}

	private static final String ADD_ASIABPM = "INSERT INTO jpasiabpm_asiabpm (id, afield ) VALUES (?, ? )";

	private static final String UPDATE_ASIABPM = "UPDATE jpasiabpm_asiabpm SET afield=? WHERE id = ?";

	private static final String DELETE_ASIABPM = "DELETE FROM jpasiabpm_asiabpm WHERE id = ?";
	
	private static final String LOAD_ASIABPM = "SELECT id, afield  FROM jpasiabpm_asiabpm WHERE id = ?";
	
	private static final String LOAD_ASIABPMS_ID  = "SELECT id FROM jpasiabpm_asiabpm";
	
}