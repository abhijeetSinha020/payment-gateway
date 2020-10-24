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
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * @author abhijeet
 * Oct 21, 2020
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/payment")
public class PaymentResource {
	
	private RazorpayClient client;
	
	
	 public PaymentResource() throws RazorpayException  {
		this.client = new RazorpayClient("rzp_test_M7a0vhPO32bvd4", "2yGsS01k8BmdnUnE2Nh12S62");
	}






	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@RequestBody ItemEntity item) {
		
		JSONObject orderRequest = new JSONObject();
		  orderRequest.put("amount", item.getPrice()); // amount in the smallest currency unit
		  orderRequest.put("currency", "INR");
		  // Not sending receiptId here.
		  Order order=null;
		try {
			order = client.Orders.create(orderRequest);
			 return new ResponseEntity<Object>(generateResponseOrderId(order),
						HttpStatus.CREATED);
		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		  return new ResponseEntity<Object>(new PostOrderResponseDTO(),
					HttpStatus.EXPECTATION_FAILED);
		

	}

	
	private PostOrderResponseDTO generateResponseOrderId(Order order) {
		System.out.println("Amount**"+order.get("amount").getClass());
		return PostOrderResponseDTO.builder().amount(order.get("amount").toString())
				.key("rzp_test_M7a0vhPO32bvd4").currency(order.get("currency"))
				.organizationName("BuzzingaTech").description("Description")
				.razorOrderId(order.get("id")).customerName("Abhijeet Sinha")
				.customerEmail("test@gmail.com").customerContact("9999999999")
				.build();
		
	}






}
