//***********************************************************************
// Copyright (c) 2015. ASA(ALT) SoSE Directorate
// All Rights Reserved.
// Permission to use, copy, modify, and distribute this software and
// its documentation for any purpose, without fee and without a signed
// licensing agreement, is hereby prohibited. Any unauthorized
// reproduction or distribution of this software, or any portion of it,
// may result in severe civil and criminal penalties, and will be
// prosecuted to the maximum extent possible under the law.
//***********************************************************************

package sample.persistence.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="atm.datasource")
public class UserSpecificDataSourceProperties
{
	public static final String DB_PREFIX = "atm_db_";

	private String urlPrefix;
	private String host;
	private Integer port;
	private String username;
	private String password;
	private String driver;

	/**
	 * \TODO Document {@link UserDataSourceProperties#getUrlPrefix) method.
	 * @return the urlPrefix
	 */
	public String getUrlPrefix()
	{
		return urlPrefix;
	}

	/**
	 * \TODO Document {@link UserSpecificDataSourceProperties#setUrlPrefix} method.
	 * @param urlPrefix the urlPrefix to set
	 */
	public void setUrlPrefix(String urlPrefix)
	{
		this.urlPrefix = urlPrefix;
	}

	/**
	 * \TODO Document {@link UserDataSourceProperties#getHost) method.
	 * @return the host
	 */
	public String getHost()
	{
		return host;
	}

	/**
	 * \TODO Document {@link UserSpecificDataSourceProperties#setHost} method.
	 * @param host the host to set
	 */
	public void setHost(String host)
	{
		this.host = host;
	}

	/**
	 * \TODO Document {@link UserDataSourceProperties#getPort) method.
	 * @return the port
	 */
	public Integer getPort()
	{
		return port;
	}

	/**
	 * \TODO Document {@link UserSpecificDataSourceProperties#setPort} method.
	 * @param port the port to set
	 */
	public void setPort(Integer port)
	{
		this.port = port;
	}

	/**
	 * \TODO Document {@link UserDataSourceProperties#getUsername) method.
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * \TODO Document {@link UserSpecificDataSourceProperties#setUsername} method.
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * \TODO Document {@link UserDataSourceProperties#getPassword) method.
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * \TODO Document {@link UserSpecificDataSourceProperties#setPassword} method.
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * \TODO Document {@link UserDataSourceProperties#getDriver) method.
	 * @return the driver
	 */
	public String getDriver()
	{
		return driver;
	}

	/**
	 * \TODO Document {@link UserSpecificDataSourceProperties#setDriver} method.
	 * @param driver the driver to set
	 */
	public void setDriver(String driver)
	{
		this.driver = driver;
	}
}