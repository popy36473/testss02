package springbootrestapi.databinding_session07.service.impl;

import org.springframework.stereotype.Service;
import springbootrestapi.databinding_session07.dto.request.ProductRequest;
import springbootrestapi.databinding_session07.entity.Product;
import springbootrestapi.databinding_session07.repository.ProductRepository;
import springbootrestapi.databinding_session07.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(ProductRequest productRequest) {
        //xử lý upload ảnh

        Product product = Product.builder()
                .proName(productRequest.getProName())
                .producer(productRequest.getProducer())
                .yearMaking(productRequest.getYearMaking())
                .expireDate(productRequest.getExpireDate())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        product.setImageUrl("Đường dẫn ảnh được lấy sau khi xử lý ảnh");
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long proId, ProductRequest productRequest) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm có mã: " + proId));
        //xử lý upload ảnh


        product.setProName(productRequest.getProName());
        product.setProducer(productRequest.getProducer());
        product.setYearMaking(productRequest.getYearMaking());
        product.setExpireDate(productRequest.getExpireDate());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        product.setImageUrl("Đường dẫn ảnh được lấy sau khi xử lý ảnh");
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long proId) {
        return productRepository.findById(proId).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm có mã: " + proId));
    }

    @Override
    public void deleteProduct(Long proId) {
        productRepository.findById(proId).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm có mã: " + proId));
        productRepository.deleteById(proId);
    }

    @Override
    public Product partialUpdateProduct(Long proId, ProductRequest productRequest) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm có mã: " + proId));

        //xử lý upload ảnh


        if(productRequest.getProName() != null && !productRequest.getProName().isEmpty()){
            product.setProName(productRequest.getProName());
        }
        if(productRequest.getProducer() != null && !productRequest.getProducer().isEmpty()){
            product.setProducer(productRequest.getProducer());
        }
        if(productRequest.getYearMaking() != null){
            product.setYearMaking(productRequest.getYearMaking());
        }
        if(productRequest.getExpireDate() != null){
            product.setExpireDate(productRequest.getExpireDate());
        }
        if(productRequest.getQuantity() != null){
            product.setQuantity(productRequest.getQuantity());
        }
        if(productRequest.getPrice() != null){
            product.setPrice(productRequest.getPrice());
        }

        if(productRequest.getImageFile()!=null){
            product.setImageUrl("Đường dẫn ảnh được lấy sau khi xử lý ảnh");
        }

        return productRepository.save(product);
    }
}
