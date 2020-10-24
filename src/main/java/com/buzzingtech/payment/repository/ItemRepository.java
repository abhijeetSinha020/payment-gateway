/**
 * 
 */
package com.buzzingtech.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buzzingtech.payment.domain.ItemEntity;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
