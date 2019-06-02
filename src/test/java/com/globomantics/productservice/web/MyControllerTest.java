package com.globomantics.productservice.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyControllerTest {
	
	/** calling this as 'target' so that we know the 'class under test' **/
	private MyController target = null;

	/** this is a Junit 5 annotation - in Junit 4 - we were using @Before **/
	@BeforeEach
	public void setup() {
		/** initialise the class under test **/
		/**TODO - using spring the new operator should not be required **/
		target = new MyController();
	}
	
	@Test
	public void test_transform_success() {
		/** note the method naming convention used which makes it easier to understand what we are testing **/
		target.transform();
		
	}

}
