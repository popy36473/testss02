package springbootrestapi.databinding_session07.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long proId;

    @Column(name = "product_name",length = 100, nullable = false)
    private String proName;

    private String producer;

    @Column(name = "year_making")
    private Integer yearMaking;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;
}
