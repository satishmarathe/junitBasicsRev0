package com.globomantics.productservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataAccessException;

import com.globomantics.productservice.common.MyServiceException;
import com.globomantics.productservice.model.MyOrder;
import com.globomantics.productservice.model.MyOrderSummary;
import com.globomantics.productservice.repository.MyOrderDao;
import com.globomantics.productservice.transformer.MyOrderToOrderSummaryTransformer;
import com.globomantics.productservice.web.MyController;

public class MyOrderServiceImplTest {

	private static final Long CUSTOMER_ID = 1L;

	/** calling this as 'target' so that we know the 'class under test' **/
	private MyOrderServiceImpl target = null;
	
	/** we need to be mocking the DAO here - MyOrderDao is the class we want to mock **/
	MyOrderDao mockOrderDao = Mockito.mock(MyOrderDao.class);

	@BeforeEach
	public void setup() {
		/** initialise the class under test **/
		/**TODO - using spring the new operator should not be required **/
		target = new MyOrderServiceImpl();
		
		/** now inject the mocked DAO into the service class **/
		target.setOrderDao(mockOrderDao);
		
		/** we will not mock the transformer - ideally it should be mocked but for this test we will not **/
		MyOrderToOrderSummaryTransformer myTransformer = new MyOrderToOrderSummaryTransformer();
		target.setTransformer(myTransformer);		
	}
	
	@Test
	public void test_getOrderSummary_throws_MyServiceException() throws Exception {			
		/** we expect an ex ception to be thrown - an abnormal condition  **/
		//assertThrows(MyServiceException.class, "System error occurred");
		assertThrows(MyServiceException.class,()-> {
			/** what should the mocked Dao method return ? - lets create that object and provide to Mocking framework **/
			//List<MyOrder> mockDaoResponse1 =  new ArrayList<MyOrder>();
			List<MyOrder> mockDaoResponse1 =  null;
			
			/** set up the Rule of when to Mock under what circumstance **/
			Mockito.when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID))
			.thenReturn(mockDaoResponse1);
			
			/** now execute **/
			/**Execution **/
			List <MyOrderSummary> result = target.getOrderSummary(CUSTOMER_ID);
		});
	}

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
