
package sample.persistence.config;

import java.util.Collections;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.security.core.Authentication;

/**
 * A routing data source which uses the currently authenticated user to
 * determine a data source (i.e. "atm_db_[user]") for JDBC connectivity. Each
 * JDC DataSource uses Spring Boot for default connection pooling capabilities.
 */
// @Component(Global.USER_SPECIFIC_DATA_QUALIFIER + "DataSource")
// @Primary
//@Lazy
//@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSpecificDataSource extends AbstractRoutingDataSource
{
	@Autowired
	private UserSpecificDataSourceProperties userDataSourceProperties;
	
	@Autowired(required=false)
	@Qualifier("dummy")
	private DataSource dummyDataSource;
	
	@Autowired
	private Authentication sessionAuthentication;
	
	public UserSpecificDataSource()
	{
		setLenientFallback(dummyDataSource != null);
		setTargetDataSources(Collections.emptyMap());
	}
	
	/**
	 * \TODO Document {@link UserDataSourceProperties#getUrl) method.
	 * @return the url
	 */
	private String getUrl(String username)
	{
		// jdbc:mysql://localhost/atm_db
		StringBuilder strBuilder = new StringBuilder(userDataSourceProperties.getUrlPrefix());
		strBuilder.append(userDataSourceProperties.getHost());
		strBuilder.append('/');
		strBuilder.append(UserSpecificDataSourceProperties.DB_PREFIX);
		strBuilder.append(username);
		
		return strBuilder.toString();
	}
	
	/**
	 * Determines the current lookup key by using the Spring Security
	 * SecurityContextHolder to get the user name.
	 *
	 * @see org.springframework.security.core.context.SecurityContextHolder
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey()
	{
		String user = null;
		
		if(sessionAuthentication != null)
			user = sessionAuthentication.getName();

		System.out.println("Resolved user database for: " + user);
		
		return user;
	}
	
	@Override
	protected DataSource determineTargetDataSource()
	{
		DataSource dataSource = null;
		String user = (String)determineCurrentLookupKey();
		if(user != null)
		{
			dataSource = DataSourceBuilder.create().url(getUrl(user)).username(userDataSourceProperties.getUsername()).password(userDataSourceProperties.getPassword()).build();
		}
		
		return dataSource;
	}
	
	/**
	 * Returns the root logger to meet Java 1.7 DataSource interface
	 * specifications.
	 */
	public Logger getParentLogger()
	{
		return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	}
}
