package springbootrestapi.databinding_session07.service;

import org.springframework.http.ResponseEntity;
import springbootrestapi.databinding_session07.dto.request.ProductRequest;
import springbootrestapi.databinding_session07.dto.response.ApiResponse;
import springbootrestapi.databinding_session07.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product insertProduct(ProductRequest productRequest);
    Product updateProduct(Long proId, ProductRequest productRequest);
    Product getProductById(Long proId);
    void deleteProduct(Long proId);
    Product partialUpdateProduct(Long proId, ProductRequest productRequest);
}
