package springbootrestapi.databinding_session07.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestapi.databinding_session07.dto.request.ProductRequest;
import springbootrestapi.databinding_session07.dto.response.ApiResponse;
import springbootrestapi.databinding_session07.entity.Product;
import springbootrestapi.databinding_session07.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách sản phẩm thành công",
                productService.getAllProducts(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> addProduct(@Valid ProductRequest productRequest) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Thêm sản phẩm thành công",
                productService.insertProduct(productRequest),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{proId}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long proId, @Valid ProductRequest productRequest) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Cập nhật sản phẩm thành công",
                productService.updateProduct(proId, productRequest),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PatchMapping("/{proId}")
    public ResponseEntity<ApiResponse<Product>> partialUpdateProduct(@PathVariable Long proId, ProductRequest productRequest) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Cập nhật sản phẩm thành công",
                productService.partialUpdateProduct(proId, productRequest),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<ApiResponse<Product>> getProduct(@PathVariable Long proId) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin sản phẩm " + proId + " thành công",
                productService.getProductById(proId),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long proId) {
        productService.deleteProduct(proId);
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Xóa sản phẩm " + proId + " thành công",
                null,
                null,
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }
}