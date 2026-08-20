package com.quickkart.quickkart.service;

import com.quickkart.quickkart.dto.ProductRequest;
import com.quickkart.quickkart.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);
}
