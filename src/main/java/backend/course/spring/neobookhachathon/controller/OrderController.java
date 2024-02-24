package backend.course.spring.neobookhachathon.controller;

import backend.course.spring.neobookhachathon.dto.request.OrderRequest;
import backend.course.spring.neobookhachathon.dto.response.OrderFullResponse;
import backend.course.spring.neobookhachathon.dto.response.OrderResponse;
import backend.course.spring.neobookhachathon.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "Для создания заказа")
    public String create(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("{id}")
    @Operation(summary = "Для получения полной информации о заказе")
    public OrderFullResponse getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping
    @Operation(summary = "Для получения истории заказов")
    public List<OrderResponse> getAll() {
        return orderService.getAll();
    }
}
