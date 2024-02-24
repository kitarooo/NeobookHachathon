package backend.course.spring.neobookhachathon.service;

import backend.course.spring.neobookhachathon.dto.response.ProductResponse;
import backend.course.spring.neobookhachathon.dto.response.ProductSearchResponse;
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

    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found!"));

        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
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

    public List<ProductSearchResponse> filterAndSearch(String name, String category) {
        if (category == null) {
            category = "";
        }

        return productRepository.findByNameAndCategory(name, category).stream().map(this::mapToProductSearchResponse).toList();
    }

    private ProductSearchResponse mapToProductSearchResponse(Product product) {
        return ProductSearchResponse.builder()
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
