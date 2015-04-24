package com.coderli.tools.junit.restlet.test.rules;

import com.coderli.tools.junit.restlet.annotation.RestConfig;
import com.coderli.tools.junit.restlet.rules.RestServerRules;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author li.hzh
 * @date 2015-04-24 14:35
 */
@RestConfig(url = "/restserver/rule/test/resource", action = RuleTestResource.class)
public class RestServerRulesTest {

	private static final Logger LOG = LoggerFactory.getLogger(RestServerRulesTest.class);
	@ClassRule
	public static RestServerRules serverRules = new RestServerRules();

	@Test
	public void ruleTest() {
		LOG.debug("Run server rule test.");
	}

}
