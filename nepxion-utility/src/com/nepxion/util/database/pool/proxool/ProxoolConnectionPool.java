package com.nepxion.util.database.pool.proxool;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProxoolConnectionPool
	implements ProxoolConstants
{
	private static Log log = LogFactory.getLog(ProxoolConnectionPool.class);
	
	/**
	 * Gets the default Connection.
	 * If you want to get the default connection, the alias must be defined with DEFAULT_ALIAS.
	 * @return the instance of Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see #getConnection
	 */
	public static Connection getDefaultConnection()
		throws SQLException, ClassNotFoundException
	{
		return getConnection(DEFAULT_ALIAS);
	}
	
	/**
	 * Gets the connection by an alias.
	 * A connection is corresponded to an alias, all of them can be defined in the config file of "proxool.properties".
	 * The detail usage of configuration is referred to the proxool site
	 * @param alias the alias string
	 * @return the instance of Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection(String alias)
		throws SQLException, ClassNotFoundException
	{
		Connection connection = null;
		try
		{
			Class.forName(PROXOOL_DRIVER);
			connection = DriverManager.getConnection(PREFIX + alias);
		}
		catch (SQLException e)
		{
			log.fatal(e);
			
			throw e;
		}
		catch (ClassNotFoundException e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		return connection;
	}
}