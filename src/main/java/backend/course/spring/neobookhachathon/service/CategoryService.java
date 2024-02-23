package backend.course.spring.neobookhachathon.service;

import backend.course.spring.neobookhachathon.entity.Category;
import backend.course.spring.neobookhachathon.entity.Product;
import backend.course.spring.neobookhachathon.exception.NotFoundException;
import backend.course.spring.neobookhachathon.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ImageUploadService imageUploadService;

    public String createCategory(Category category) {
        categoryRepository.save(category);

        return "Категорий успешно создан!";
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public String uploadImage(MultipartFile multipartFile, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found!"));
        category.setImageUrl(imageUploadService.saveImage(multipartFile));
        categoryRepository.save(category);

        return "Фотография успешно создана!";
    }
}
