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

package sample.controllers;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sample.persistence.Greeting;

@RestController
public class GreetingController
{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(method=RequestMethod.GET, value="/greeting")
	public Greeting greeting(Principal principal)
	{
		return new Greeting(counter.incrementAndGet(), String.format(template, principal.getName()));
	}
}