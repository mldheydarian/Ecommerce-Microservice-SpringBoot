package com.milad.orderservice.resource;

import com.milad.orderservice.dto.OrderDto;
import com.milad.orderservice.restclient.user.service.UserClientService;
import com.milad.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderResource {
	
	private final OrderService orderService;

	private final UserClientService userClientService;
	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll() {

		return ResponseEntity.ok(orderService.getOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> findById(@PathVariable("id") @Valid  Long id) {

		return ResponseEntity.ok(orderService.getOrderById(id));
	}


	@PostMapping
	public ResponseEntity<OrderDto> save(@RequestBody @Valid  OrderDto orderDto,@RequestHeader Map<String, String> headers) {

		orderDto.setUserId(userClientService.getUserByUserNameInHttpHeader(headers).getBody().getUserId());
		//or
		//orderDto.setUserId(userClientService.getUserByUserNameInQueryParam(headers.get("username")).getBody().getUserId());
		return ResponseEntity.ok(orderService.save(orderDto));
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable("id") long id)
	{
		return ResponseEntity.ok(orderService.getOrdersByUserId(id));
	}


}










