/**
 * 
 */
package com.buzzingtech.payment.service;

import org.springframework.stereotype.Service;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.service.rzp.IRazorPayment;
import com.buzzingtech.payment.web.PostOrderResponseDTO;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
@Service
public class PaymentService implements IPaymentService {
	private  final IRazorPayment rzpService;
	
	
	public PaymentService(IRazorPayment rzpService) {
		super();
		this.rzpService = rzpService;
	}

	@Override
	public PostOrderResponseDTO generateRzpOrderResponse(ItemEntity item) {
		return rzpService.genrateRazorPayOrder(item);
	}

}
