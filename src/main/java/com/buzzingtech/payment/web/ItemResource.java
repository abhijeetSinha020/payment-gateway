/**
 * 
 */
package com.buzzingtech.payment.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.service.ItemServiceI;

/**
 * @author abhijeet Oct 21, 2020
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class ItemResource {

	private final ItemServiceI itemService;

	/**
	 * @param itemService
	 */
	public ItemResource(ItemServiceI itemService) {
		super();
		this.itemService = itemService;
	}

	@GetMapping("items")
	public ResponseEntity<List<ItemEntity>> getAllItems() {
		return new ResponseEntity<List<ItemEntity>>(itemService.getAll(), HttpStatus.OK);
	}
}
