package backend.course.spring.neobookhachathon.controller;

import backend.course.spring.neobookhachathon.dto.request.OrderRequest;
import backend.course.spring.neobookhachathon.dto.response.OrderFullResponse;
import backend.course.spring.neobookhachathon.dto.response.OrderResponse;
import backend.course.spring.neobookhachathon.entity.Order;
import backend.course.spring.neobookhachathon.repository.OrderRepository;
import backend.course.spring.neobookhachathon.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public String create(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("{id}")
    public OrderFullResponse getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return orderService.getAll();
    }
}
