package com.globomantics.productservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.globomantics.productservice.model.MyOrder;
import com.globomantics.productservice.model.MyOrderSummary;
import com.globomantics.productservice.repository.MyOrderDao;
import com.globomantics.productservice.transformer.MyOrderToOrderSummaryTransformer;

public class MyOrderServiceImplTest {
	
	private static final Long CUSTOMER_ID = 1L;
	
	@Test
	public void test_getOrderSummary_success() throws Exception {
		/** setup **/
		MyOrderServiceImpl target = new MyOrderServiceImpl() ;
		
		/** we need to be mocking the DAO here - MyOrderDao is the class we want to mock **/
		MyOrderDao mockOrderDao = Mockito.mock(MyOrderDao.class);
		
		/** now inject the mocked DAO into the service class **/
		target.setOrderDao(mockOrderDao);
		
		//MyOrderEntityToOrderSummaryTransformer myTransformer = Mockito.mock(MyOrderEntityToOrderSummaryTransformer.class);
		MyOrderToOrderSummaryTransformer myTransformer = new MyOrderToOrderSummaryTransformer();
		
		target.setTransformer(myTransformer);
		
		List<MyOrder> mockDaoResponse =  new ArrayList<MyOrder>();
		
		
		Mockito.when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID))
		.thenReturn(mockDaoResponse);
		
		
		/**Execution **/
		List <MyOrderSummary> result = target.getOrderSummary(CUSTOMER_ID);
		
		/**verification **/
		assertNotNull(result);
		//assertEquals(1, result.size());
	}
}
