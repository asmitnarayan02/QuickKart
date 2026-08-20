package com.quickkart.quickkart.service;

import com.quickkart.quickkart.dto.ProductRequest;
import com.quickkart.quickkart.dto.ProductResponse;
import com.quickkart.quickkart.entity.Product;
import com.quickkart.quickkart.exception.ProductNotFoundException;
import com.quickkart.quickkart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = mapToEntity(request);
        return mapToResponse(productRepository.save(product));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return mapToResponse(findProductById(id));
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = findProductById(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setCategory(request.getCategory());
        return mapToResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private Product mapToEntity(ProductRequest request) {
        return new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getStockQuantity(),
                request.getCategory()
        );
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getCategory()
        );
    }
}
