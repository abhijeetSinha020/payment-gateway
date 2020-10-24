package com.buzzingtech.payment.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderResponseDTO {
	
	private String key;
	private String amount;
	private String currency;
	private String organizationName;
	private String description;
	private String imageUrl;
	private String razorOrderId;
	private String customerName;
	private String customerEmail;
	private String customerContact;
		
}
