package com.buzzingtech.payment.service.rzp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.web.PostOrderResponseDTO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorPaymentImpl implements IRazorPayment {
	
	private RazorpayClient rzpClient;
	
	@Value("${razorpay.api.key}")
	private String key;
	
	@Value("${razorpay.api.secret}")
	private String secret;
	
	

	public RazorPaymentImpl() throws RazorpayException {
		
		this.rzpClient = new RazorpayClient("rzp_test_M7a0vhPO32bvd4", "2yGsS01k8BmdnUnE2Nh12S62");
	}



	@Override
	public PostOrderResponseDTO genrateRazorPayOrder(ItemEntity item) {
		JSONObject orderRequest = new JSONObject();
		  orderRequest.put("amount", item.getPrice()); // amount in the smallest currency unit
		  orderRequest.put("currency", "INR");
		// Not sending receiptId here.
		  System.out.println("cclientRzp"+rzpClient.toString());
		  Order order=null;
		  try {
				order = rzpClient.Orders.create(orderRequest);
				 
			} catch (RazorpayException e) {
				e.printStackTrace();
			}
		return generateResponseOrderId(order);
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
