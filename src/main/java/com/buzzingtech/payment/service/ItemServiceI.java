/**
 * 
 */
package com.buzzingtech.payment.service;

import java.util.List;

import com.buzzingtech.payment.domain.ItemEntity;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
public interface ItemServiceI {
	
	public ItemEntity save(ItemEntity item);
	public List<ItemEntity> getAll();

}
