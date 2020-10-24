/**
 * 
 */
package com.buzzingtech.payment.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author abhijeet
 *Oct 20, 2020
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity extends BaseEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8632969998553000616L;
	
	private String trasactionId;
	private Double amount;
	private LocalDateTime paymentDate;
	
	}
