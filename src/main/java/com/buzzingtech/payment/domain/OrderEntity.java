/**
 * 
 */
package com.buzzingtech.payment.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.buzzingtech.payment.domain.PaymentEntity.PaymentEntityBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author abhijeet
 *Oct 21, 2020
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity extends BaseEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 762399668750576833L;
	
	private String uniqueOrderId;
	private Double amount;
	private String currency;
	private String status;
	
//	@ManyToMany
//	private List<ItemEntity> items;
	

}
