package com.buzzingtech.payment.service;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.web.PostOrderResponseDTO;

public interface IPaymentService {
public PostOrderResponseDTO generateRzpOrderResponse(ItemEntity item);
}
