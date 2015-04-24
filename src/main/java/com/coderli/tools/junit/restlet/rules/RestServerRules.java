package com.coderli.tools.junit.restlet.rules;

import com.coderli.tools.junit.restlet.annotation.RestConfig;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used with {@link org.junit.ClassRule} annotation. So needs JUint4.9+<br>
 * Start a simple restserver according to the {@link RestConfig} annotation on your test class.<br>
 * <pre>
 * Demo
 *
 * @author li.hzh
 * @date 2015-04-22 10:03
 */
public class RestServerRules implements TestRule {

	private static final Logger logger = LoggerFactory.getLogger(RestServerRules.class);
	private Component component;
	private String url;

	@Override
	public Statement apply(Statement base, Description description) {
		return statement(base, description);
	}

	private Statement statement(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				before(description);
				try {
					base.evaluate();
				} finally {
					after(description);
				}
			}
		};
	}

	private void after(Description description) throws Exception {
		if (component != null && component.isStarted()) {
			logger.debug("Stop rest server.");
			component.stop();
		}
	}

	private void before(Description description) throws Exception {
		Class testClass = description.getTestClass();
		RestConfig restConfig = (RestConfig) testClass.getAnnotation(RestConfig.class);
		if (restConfig == null) {
			logger.error("RestConfig annotation is not configured。Can not start rest server.");
			throw new IllegalArgumentException("RestConfig annotation is not configured。Can not start rest server.");
		}
		url = restConfig.url();
		startServer(url, restConfig.port(), restConfig.action());
	}

	private void startServer(String url, int port, Class action) throws Exception {
		logger.debug("Starting rest server.url: [{}], port: [{}], class: [{}]", new Object[]{url, port, action.getName()});
		component = new Component();
		component.getServers().add(Protocol.HTTP, port);
		component.getDefaultHost().attach(url, action);
		component.start();
	}

	public String getUrl() {
		return url;
	}

}
