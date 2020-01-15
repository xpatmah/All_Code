package com.org.test.unit.JUnitTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImpleTest {

	private GreetingImpl imp;

	
	@Before
	public void setup() {
		imp = new GreetingImpl();
	}

	
	@Test
	public void greetings() {
		String name = imp.getName("Ramesh");
		assertNotNull(name);
		assertEquals("hello Ramesh", name);
	}
	
// Mocking is test in isolation
	
	@After
	public void cleanUp() {
		imp=null;
	}

}
