package backend.course.spring.neobookhachathon.service;

import backend.course.spring.neobookhachathon.entity.Category;
import backend.course.spring.neobookhachathon.entity.Product;
import backend.course.spring.neobookhachathon.exception.NotFoundException;
import backend.course.spring.neobookhachathon.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ImageUploadService imageUploadService;

    public String create(Product product) {
        productRepository.save(product);

        return "Продукт успешно создан!";
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product checkProductOnExistAndReturn(Long id) {
        return productRepository.findAllById(id).orElseThrow(
                () -> new NotFoundException("Product not found!"));
    }

    public String uploadImage(MultipartFile multipartFile, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found!"));
        product.setImageUrl(imageUploadService.saveImage(multipartFile));
        productRepository.save(product);

        return "Фотография успешно создана!";
    }
}
