package com.coderli.tools.junit.restlet.test.rules;

import org.restlet.resource.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author li.hzh
 * @date 2015-04-24 14:59
 */
public class RuleTestResource {

	private static final Logger LOG = LoggerFactory.getLogger(RuleTestResource.class);

	@Get
	public void doGet() {
		LOG.info("Called do get method.");
	}

}
