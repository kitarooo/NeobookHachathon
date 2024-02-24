package backend.course.spring.neobookhachathon.repository;

import backend.course.spring.neobookhachathon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findAllById(Long id);

    @Query(value = "SELECT * FROM product a WHERE a.name LIKE CONCAT('%', ?1,'%') " +
            "AND a.category LIKE UPPER(CONCAT('%', ?2,'%'))",
            nativeQuery = true)
    List<Product> findByNameAndCategory(String name, String category);
}
