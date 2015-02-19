// ***********************************************************************
// Copyright (c) 2015. ASA(ALT) SoSE Directorate
// All Rights Reserved.
// Permission to use, copy, modify, and distribute this software and
// its documentation for any purpose, without fee and without a signed
// licensing agreement, is hereby prohibited. Any unauthorized
// reproduction or distribution of this software, or any portion of it,
// may result in severe civil and criminal penalties, and will be
// prosecuted to the maximum extent possible under the law.
// ***********************************************************************

package sample;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Global
{
	public final static String AUTHENTICATION_DATA_QUALIFIER = "auth";
	public final static String USER_SPECIFIC_DATA_QUALIFIER = "userSpecific";
	
	public final static String LINE_SEPARATOR = SystemUtils.LINE_SEPARATOR;
	
	// / This value is populated by SVN keyword. DO NOT MANUALLY MODIFY!
	private final String APP_REVISION = "$Revision: 181 $";
	
	private String APP_VERSION = parseAppVersion();
	
	protected Global()
	{
		// Do nothing
	}
	
	@Bean
	@Lazy
	public boolean inDebugMode()
	{
		boolean isDebugging = false;
		try
		{
			isDebugging = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
		}
		catch (Throwable t)
		{
		}
		
		return isDebugging;
	}

	@Bean(name = "sessionAuthentication")
	@Lazy
	public Authentication getSessionAuthentication()
	{
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	/**
	 * Parse the embedded SVN version tag.
	 */
	private synchronized String parseAppVersion()
	{
		// Clean up SVN revision numbering
		String appVersion = APP_REVISION.replaceAll("\\$Revision: ", "").replaceAll("\\$Rev: ", "").replaceAll(" \\$", "");
		
		// Zero pad the version number
		StringBuilder temp = new StringBuilder(appVersion);
		for (int c = temp.length(); c < 4; c++)
		{
			temp.insert(0, "0");
		}
		
		// Insert period notation
		temp.insert(temp.length() - 3, ".");
		temp.insert(temp.length() - 2, ".");
		
		return temp.toString();
	}
	
	/**
	 * Override the built-in version numbering and use the embedded version tag
	 * instead.
	 *
	 * @param version
	 *            The version designation to use or NULL to parse internally.
	 */
	public synchronized void setAppVersion(String version)
	{
		if (StringUtils.isEmpty(version))
		{
			APP_VERSION = parseAppVersion();
		}
		else
		{
			APP_VERSION = version;
		}
	}
	
	/**
	 * Retrieve the stored version designation for this instance.
	 *
	 * @return The stored version designation.
	 */
	@Bean
	@Lazy
	public String getAppVersion()
	{
		return APP_VERSION;
	}
	
	/**
	 * Retrieve the stored revision designation for this instance.
	 *
	 * @return The stored version designation.
	 */
	@Bean
	@Lazy
	public String getAppRevision()
	{
		return APP_REVISION;
	}
}
