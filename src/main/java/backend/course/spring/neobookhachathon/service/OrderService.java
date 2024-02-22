package backend.course.spring.neobookhachathon.service;

import backend.course.spring.neobookhachathon.dto.OrderDetailsDTO;
import backend.course.spring.neobookhachathon.dto.request.OrderRequest;
import backend.course.spring.neobookhachathon.dto.response.OrderFullResponse;
import backend.course.spring.neobookhachathon.dto.response.OrderResponse;
import backend.course.spring.neobookhachathon.entity.Order;
import backend.course.spring.neobookhachathon.entity.OrderDetails;
import backend.course.spring.neobookhachathon.entity.Product;
import backend.course.spring.neobookhachathon.exception.NotFoundException;
import backend.course.spring.neobookhachathon.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    public String createOrder(OrderRequest orderRequest) {
        Random random = new Random();
        Long token = random.nextLong(1000000, 9999999);
        String randomName = "Заказ №" + token.toString() + " оформлен!";
        String name = "Заказ №" + token.toString();

        List<OrderDetails> orderDetails = mapOrderDetailsDTOtoOrderDto(orderRequest.getOrderDetails());
        double totalSum = 0.0;

        for (OrderDetails details : orderDetails) {
            totalSum += details.getTotalPrice();
        }

        Order order = Order.builder()
                .name(name)
                .address(orderRequest.getAddress())
                .comment(orderRequest.getComment())
                .createdDate(LocalDateTime.now())
                .phoneNumber(orderRequest.getPhoneNumber())
                .guide(orderRequest.getGuide())
                .orderDetails(orderDetails)
                .totalPrice(totalSum)
                .build();

        orderRepository.save(order);
        return randomName;
    }

    public OrderFullResponse getById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found!"));
        return OrderFullResponse.builder()
                .name(order.getName())
                .createdDate(order.getCreatedDate())
                .orderDetails(order.getOrderDetails())
                .build();
    }

    public List<OrderResponse> getAll() {
        List<OrderResponse> result = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            result.add(OrderResponse.builder()
                    .createdDate(order.getCreatedDate())
                    .name(order.getName())
                    .totalPrice(order.getTotalPrice())
                    .build());
        }

        return result;
    }

    public List<OrderDetails> mapOrderDetailsDTOtoOrderDto(List<OrderDetailsDTO> orderDTOS) {
        List<OrderDetails> orderDetails = new ArrayList<>();

        for (OrderDetailsDTO details : orderDTOS) {
            Product product = productService.checkProductOnExistAndReturn(details.getProductId());
            orderDetails.add(OrderDetails.builder()
                    .product(product)
                    .totalPrice(product.getPrice() * details.getQuantity())
                    .quantity(details.getQuantity())
                    .build());
        }

        return orderDetails;
    }
}
