/**
 * 
 */
package com.buzzingtech.payment.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.buzzingtech.payment.domain.ItemEntity;
import com.buzzingtech.payment.repository.ItemRepository;

/**
 * @author abhijeet
 *Oct 21, 2020
 */
@Configuration
public class AppInit implements CommandLineRunner {
	@Autowired
	private ItemRepository itemRepo;

	@Override
	public void run(String... args) throws Exception {
		generateItems();		
	}
	private void generateItems() {
		
		ItemEntity i1= ItemEntity.builder().name("Jeera Rice").desc("Jeera Rice Desc").price(1000.00).build();
		itemRepo.save(i1);
		}
}
