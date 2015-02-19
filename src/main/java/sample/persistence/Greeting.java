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

package sample.persistence;

public class Greeting
{
	private final long id;
	private final String content;
	
	public Greeting(long id, String content)
	{
		this.id = id;
		this.content = content;
	}
	
	public long getId()
	{
		return id;
	}
	
	public String getContent()
	{
		return content;
	}
}