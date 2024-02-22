package backend.course.spring.neobookhachathon.repository;

import backend.course.spring.neobookhachathon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
