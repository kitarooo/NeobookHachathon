package backend.course.spring.neobookhachathon.controller;

import backend.course.spring.neobookhachathon.dto.response.ProductResponse;
import backend.course.spring.neobookhachathon.dto.response.ProductSearchResponse;
import backend.course.spring.neobookhachathon.entity.Product;
import backend.course.spring.neobookhachathon.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    @Operation(summary = "Ендпоинт для админки, добавления продукта")
    public String create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    @Operation(summary = "Для получения всех продуктов")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Для получения полной информации продукта по id")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping("/upload")
    @Operation(summary = "Ендппоинт для админки, добавление изображения")
    public String uploadImage(@RequestParam MultipartFile multipartFile, @RequestParam @PathVariable Long id) {
        return productService.uploadImage(multipartFile, id);
    }

    @GetMapping("/get")
    @Operation(summary = "Для поиска и филтрации по категориям")
    public List<ProductSearchResponse> searchAndFilter(@RequestParam String name,
                                                       @RequestParam String category) {
        return productService.filterAndSearch(name,category);
    }
}
