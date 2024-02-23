package backend.course.spring.neobookhachathon.controller;

import backend.course.spring.neobookhachathon.entity.Product;
import backend.course.spring.neobookhachathon.service.ProductService;
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
    public String create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam MultipartFile multipartFile, @RequestParam @PathVariable Long id) {
        return productService.uploadImage(multipartFile, id);
    }
}
