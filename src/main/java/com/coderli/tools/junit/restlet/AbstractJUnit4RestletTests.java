package com.coderli.tools.junit.restlet;

import com.coderli.tools.junit.restlet.rules.RestServerRules;
import org.junit.Before;
import org.junit.ClassRule;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author li.hzh
 * @date 2015-04-24 16:43
 */
public abstract class AbstractJUnit4RestletTests {

	protected static Logger LOG = LoggerFactory.getLogger(AbstractJUnit4RestletTests.class);
	@ClassRule
	public static RestServerRules serverRules = new RestServerRules();
	protected ClientResource client;


	@Before
	protected void before() {
		doBefore();
	}

	/**
	 * For user test case to override.
	 */
	protected abstract void doBefore();

	protected Representation doGet() {
		return null;
	}


}