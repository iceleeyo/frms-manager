package cn.com.bsfit.frms.manager.log;

import ch.qos.logback.classic.db.names.ColumnName;
import ch.qos.logback.classic.db.names.DBNameResolver;
import ch.qos.logback.classic.db.names.TableName;

/**
 * 拼接日志插入数据的SQL
 * 
 * @author yzq
 * 
 * @since 1.0.0
 *
 */
public class LogSQLBuilder {

	private LogSQLBuilder() {
		super();
	}
	
	public static String buildInsertPropertiesSQL(DBNameResolver dbNameResolver) {
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
		sqlBuilder.append(dbNameResolver.getTableName(TableName.LOGGING_EVENT_PROPERTY)).append(" (");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.MAPPED_KEY)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.MAPPED_VALUE)).append(") ");
		sqlBuilder.append("VALUES (?, ?, ?)");
		return sqlBuilder.toString();
	}

	public static String buildInsertExceptionSQL(DBNameResolver dbNameResolver) {
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
		sqlBuilder.append(dbNameResolver.getTableName(TableName.LOGGING_EVENT_EXCEPTION)).append(" (");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.I)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.TRACE_LINE)).append(") ");
		sqlBuilder.append("VALUES (?, ?, ?)");
		return sqlBuilder.toString();
	}

	public static String buildInsertSQL(DBNameResolver dbNameResolver, String DBType) {
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
		sqlBuilder.append(dbNameResolver.getTableName(TableName.LOGGING_EVENT)).append(" (");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.TIMESTMP)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.FORMATTED_MESSAGE)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.LOGGER_NAME)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.LEVEL_STRING)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.THREAD_NAME)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.REFERENCE_FLAG)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.ARG0)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.ARG1)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.ARG2)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.ARG3)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.CALLER_FILENAME)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.CALLER_CLASS)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.CALLER_METHOD)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.CALLER_LINE)).append(" ");
		if(DBType.equals("oracle")) {
			sqlBuilder.append(",");
			sqlBuilder.append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(") ");
			sqlBuilder.append("VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, logging_event_id_seq.nextval)");
		} else if(DBType.equals("mysql")) {
			sqlBuilder.append(") ");
			sqlBuilder.append("VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		return sqlBuilder.toString();
	}
}
