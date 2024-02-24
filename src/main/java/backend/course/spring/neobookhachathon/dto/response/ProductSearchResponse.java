package backend.course.spring.neobookhachathon.dto.response;

import backend.course.spring.neobookhachathon.entity.enums.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSearchResponse {
    String name;
    Category category;
    double price;
    String imageUrl;
}
