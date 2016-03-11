package com.tutorial.spring.boot.services;

import com.tutorial.spring.boot.model.Inventory;

public interface InventoryService {

	public Inventory findByPartnumber(long partNumber);
	
	public Inventory create(Inventory inventory);
	
	public boolean update(Inventory inventory) throws Exception;
	
	public boolean deleteByPartnumber(long partnumber) throws Exception;
	
}
