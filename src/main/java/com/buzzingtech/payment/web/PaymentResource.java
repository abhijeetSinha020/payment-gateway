/**
 * 
 */
package com.buzzingtech.payment.web;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.service.IPaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * @author abhijeet Oct 21, 2020
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/payment")
public class PaymentResource {
	private final IPaymentService paymentService;
	

	public PaymentResource(IPaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}


	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@RequestBody ItemEntity item) {

		try {
			PostOrderResponseDTO order = paymentService.generateRzpOrderResponse(item);
			return new ResponseEntity<Object>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new PostOrderResponseDTO(), HttpStatus.EXPECTATION_FAILED);

	}

}
