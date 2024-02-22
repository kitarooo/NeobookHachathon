package backend.course.spring.neobookhachathon.service;

import backend.course.spring.neobookhachathon.entity.Category;
import backend.course.spring.neobookhachathon.entity.Product;
import backend.course.spring.neobookhachathon.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public String createCategory(Category category) {
        categoryRepository.save(category);

        return "Категорий успешно создан!";
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}
