package springbootrestapi.databinding_session07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootrestapi.databinding_session07.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
