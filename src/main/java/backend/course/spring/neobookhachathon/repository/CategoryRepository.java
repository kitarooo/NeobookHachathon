package backend.course.spring.neobookhachathon.repository;

import backend.course.spring.neobookhachathon.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
