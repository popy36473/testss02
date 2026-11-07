package springbootrestapi.databinding_session07.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    @NotBlank(message = "Không được để trống tên sản phẩm")
    private String proName;
    @NotBlank(message = "Không được để trống nhà sản xuất")
    private String producer;
    @NotNull(message = "Không được để trống năm sản xuất")
    @Min(value = 1900, message = "Năm sản xuất phải lớn hơn hoặc bằng 1900")
    private Integer yearMaking;
    @NotNull(message = "Không được để trống ngày hết hạn")
    private LocalDate expireDate;
    @NotNull(message = "Không được để trống số lượng sản phẩm")
    @Min(value = 0, message = "Số lượng sản phẩm phải là số dương")
    private Integer quantity;
    @NotNull(message = "Không được để trống giá sản phẩm")
    @Min(value = 0, message = "Giá sản phẩm phải là số dương")
    private Double price;
    @NotNull(message = "Không được để trống hình ảnh sản phẩm")
    private MultipartFile imageFile;
}
