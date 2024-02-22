package backend.course.spring.neobookhachathon.dto.response;

import backend.course.spring.neobookhachathon.entity.OrderDetails;
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
public class OrderFullResponse {
    String name;
    List<OrderDetails> orderDetails;
    LocalDateTime createdDate;
}
