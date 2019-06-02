package com.globomantics.productservice.service;

import com.globomantics.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    /**
     * Returns the product with the specified id.
     *
     * @param id        ID of the product to retrieve.
     * @return          The requested Product if found.
     */
    Optional<Product> findById(Integer id);

    

    /**
     * Deletes the product with the specified id.
     * @param id        The id of the product to delete.
     * @return          True if the operation was successful.
     */
    boolean delete(Integer id);
}
