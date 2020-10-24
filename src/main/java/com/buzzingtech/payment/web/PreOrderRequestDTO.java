/**
 * 
 */
package com.buzzingtech.payment.web;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author abhijeet
 *Oct 22, 2020
 */
@Getter
@Setter
@Builder
public class PreOrderRequestDTO {
	private Double amount;
	private String currency;
	
	

}
