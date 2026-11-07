package springbootrestapi.databinding_session07.init_data;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springbootrestapi.databinding_session07.entity.Product;
import springbootrestapi.databinding_session07.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class InitProducts implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.findAll().isEmpty()) {
            List<Product> products = List.of(
                    new Product(null,"Máy tính Dell 01","Dell", 10,LocalDate.of(2021,12,21),10,15000000D,null),
                    new Product(null,"Máy tính Dell 02","Dell", 11,LocalDate.of(2022,10,1),11,12000000D,null),
                    new Product(null,"Máy tính Dell 03","Dell", 21,LocalDate.of(2023,11,2),12,13000000D,null),
                    new Product(null,"Máy tính Dell 04","Dell", 22,LocalDate.of(2021,9,7),13,16000000D,null)
            );

            productRepository.saveAll(products);
        }
    }
}
