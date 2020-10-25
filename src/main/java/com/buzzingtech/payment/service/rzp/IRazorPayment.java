package com.buzzingtech.payment.service.rzp;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.web.PostOrderResponseDTO;

public interface IRazorPayment {
	
	public PostOrderResponseDTO genrateRazorPayOrder(ItemEntity item);

}
