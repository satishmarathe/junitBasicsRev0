package com.globomantics.productservice.web;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.globomantics.productservice.model.MyOrder;
import com.globomantics.productservice.model.MyOrderItem;
import com.globomantics.productservice.model.MyOrderSummary;

import junit.framework.Assert;

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
		
		String orderNumberFixture = UUID.randomUUID().toString();
		
		MyOrder myOrderFixture = new MyOrder();
		myOrderFixture.setOrderNumber(orderNumberFixture);
		
		myOrderFixture.setMyOrderItemList(new LinkedList<MyOrderItem>());
		
		MyOrderItem myOrderItemFixture1 = new MyOrderItem();
		MyOrderItem myOrderItemFixture2 = new MyOrderItem();
		
		myOrderItemFixture1.setQuantity(1);
		myOrderItemFixture2.setQuantity(2);
		
		myOrderItemFixture1.setSellingPrice(new BigDecimal("10.00"));
		myOrderItemFixture2.setSellingPrice(new BigDecimal("1.50"));
		
		myOrderFixture.getMyOrderItemList().add(myOrderItemFixture1);
		myOrderFixture.getMyOrderItemList().add(myOrderItemFixture2);
		
		
		/** variable is named as result **/
		MyOrderSummary result = target.transform(myOrderFixture);
		
		/** note the deprecated way of asserting which is commented **/
		assertNotNull(result);
		//Assert.assertNotNull(result);
		
		assertEquals(orderNumberFixture, result.getOrderNumber());
		
		assertEquals(3,result.getItemCount());
		
		assertEquals(13,result.getTotalAmount());
		
	}
	
	/**
	@Test(expected=IllegalArgumentException)
	public void test_input_null() {
		target.transform(null);
	}
	**/
	
	@Test
	public void test_input_null() {
		assertThrows(IllegalArgumentException.class, () -> {
			target.transform(null);
		});
		
	}
	
	/**
	@Test
	@Ignore
	public void test_something_future() {
		// note the usage of @Ignore annotation to avoid running a test 
		target.transform(null);
	}
	**/
}
