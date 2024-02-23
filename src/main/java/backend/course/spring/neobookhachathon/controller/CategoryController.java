package backend.course.spring.neobookhachathon.controller;

import backend.course.spring.neobookhachathon.entity.Category;
import backend.course.spring.neobookhachathon.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public String create(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam MultipartFile multipartFile, @RequestParam @PathVariable Long id) {
        return categoryService.uploadImage(multipartFile, id);
    }
}
