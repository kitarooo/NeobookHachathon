package backend.course.spring.neobookhachathon.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String phoneNumber;
    String comment;
    String address;
    String guide;
    double totalPrice;
    LocalDate createdDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<OrderDetails> orderDetails;
}
