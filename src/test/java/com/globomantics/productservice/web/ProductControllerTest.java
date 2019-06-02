package com.globomantics.productservice.web;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.service.ProductService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mockMvc;

    
    @Test
    @Disabled
    @DisplayName("DELETE /product/1 - Success")
    void testProductDeleteSuccess() throws Exception {
    	System.out.println("<<<<<< ProductControllerTest testProductDeleteSuccess 001 >>>>>>");
        // Setup mocked product
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        
        System.out.println("<<<<<< ProductControllerTest testProductDeleteSuccess 002 >>>>>>");
        // Setup the mocked service
        doReturn(Optional.of(mockProduct)).when(service).findById(1);
        System.out.println("<<<<<< ProductControllerTest testProductDeleteSuccess 003 >>>>>>");
        doReturn(true).when(service).delete(1);
        System.out.println("<<<<<< ProductControllerTest testProductDeleteSuccess 004 >>>>>>");

        // Execute our DELETE request
        mockMvc.perform(delete("/product/{id}", 1))
                .andExpect(status().isOk());
    }

   

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
