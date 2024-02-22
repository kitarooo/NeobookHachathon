package backend.course.spring.neobookhachathon.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsDTO {
    int quantity;
    Long productId;
    double totalPrice;
}
