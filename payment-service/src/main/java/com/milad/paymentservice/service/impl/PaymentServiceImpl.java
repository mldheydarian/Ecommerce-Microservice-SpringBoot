package com.milad.paymentservice.service.impl;

import com.milad.paymentservice.dto.PaymentDto;
import com.milad.paymentservice.repository.PaymentRepository;
import com.milad.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {


	@Override
	public List<PaymentDto> findAll() {
		return null;
	}

	@Override
	public PaymentDto findById(Integer paymentId) {
		return null;
	}

	@Override
	public PaymentDto save(PaymentDto paymentDto) {
		return null;
	}

	@Override
	public PaymentDto update(PaymentDto paymentDto) {
		return null;
	}

	@Override
	public void deleteById(Integer paymentId) {

	}
}









