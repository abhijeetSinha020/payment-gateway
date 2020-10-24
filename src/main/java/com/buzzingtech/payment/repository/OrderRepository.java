/**
 * 
 */
package com.buzzingtech.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buzzingtech.payment.domain.OrderEntity;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
public interface OrderRepository  extends JpaRepository<OrderEntity, Long>{

}
