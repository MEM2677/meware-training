/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jpasiabpm.aps.system.init.servdb;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Asiabpm.TABLE_NAME)
public class Asiabpm {
	
	public Asiabpm() {}
	
	@DatabaseField(columnName = "id", 
		dataType = DataType.INTEGER, 
		 canBeNull=false, id = true)
	private int _id;
	
	@DatabaseField(columnName = "afield", 
		dataType = DataType.STRING, 
		width=30,  canBeNull=false)
	private String _afield;
	

public static final String TABLE_NAME = "jpasiabpm_asiabpm";
}
