package com.globomantics.productservice.web;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.service.ProductService;

@RestController
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }  

   

    /**
     * Deletes the product with the specified ID.
     * @param id    The ID of the product to delete.
     * @return      A ResponseEntity with one of the following status codes:
     *              200 OK if the delete was successful
     *              404 Not Found if a product with the specified ID is not found
     *              500 Internal Service Error if an error occurs during deletion
     */
    
    /**
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {

        logger.info("Deleting product with ID {}", id);

        // Get the existing product
        Optional<Product> existingProduct = productService.findById(id);

        return existingProduct.map(p -> {
            if (productService.delete(p.getId())) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }).orElse(ResponseEntity.notFound().build());
    }
    **/
    
}
