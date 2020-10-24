/**
 * 
 */
package com.buzzingtech.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buzzingtech.payment.domain.PaymentEntity;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
