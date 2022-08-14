package com.milad.orderservice.resource;

import com.milad.orderservice.dto.OrderDto;
import com.milad.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderResource {
	
	private final OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll() {

		return ResponseEntity.ok(orderService.getOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> findById(@PathVariable("id") @Valid  Long id) {

		return ResponseEntity.ok(orderService.getOrderById(id));
	}


	@PostMapping
	public ResponseEntity<OrderDto> save(@RequestBody @Valid  OrderDto orderDto) {

		return ResponseEntity.ok(orderService.save(orderDto));
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable("id") long id)
	{
		return ResponseEntity.ok(orderService.getOrdersByUserId(id));
	}


}










