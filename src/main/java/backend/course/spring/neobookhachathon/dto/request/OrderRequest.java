package backend.course.spring.neobookhachathon.dto.request;

import backend.course.spring.neobookhachathon.dto.OrderDetailsDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String name;
    String phoneNumber;
    String address;
    String guide;
    String comment;
    double totalPrice;
    LocalDateTime createdDate;
    List<OrderDetailsDTO> orderDetails;
}
