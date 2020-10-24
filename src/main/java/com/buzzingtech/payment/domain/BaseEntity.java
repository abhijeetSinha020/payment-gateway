/**
 * 
 */
package com.buzzingtech.payment.domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author abhijeet
 *Oct 20, 2020
 */

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected LocalDateTime createdAt;
	protected LocalDateTime updatedAt;
	protected String createdBy;
	protected String updatedBy;
	
	
	

}
