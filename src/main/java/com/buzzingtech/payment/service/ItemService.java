/**
 * 
 */
package com.buzzingtech.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.repository.ItemRepository;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
@Service
public class ItemService implements ItemServiceI {
	private  final ItemRepository itemRepo;
	/**
	 * @param itemRepo
	 */
	public ItemService(ItemRepository itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}




	@Override
	public ItemEntity save(ItemEntity item) {
		return itemRepo.save(item);
	}




	@Override
	public List<ItemEntity> getAll() {
		return itemRepo.findAll();
	}

}
