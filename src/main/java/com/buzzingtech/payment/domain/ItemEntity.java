
/**
 * 
 */
package com.buzzingtech.payment.domain;

import java.io.Serializable;

import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ItemEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2809412645870242365L;
	private String name;
	private String desc;
	private Double price;

}
