package com.tutorial.spring.boot.services;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.spring.boot.model.Inventory;
import com.tutorial.spring.boot.repository.InventoryRepository;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {

	private Logger logger = Logger.getLogger(InventoryServiceImpl.class);
	
	private final InventoryRepository inventoryRespository;
	
	@Autowired
	public InventoryServiceImpl(InventoryRepository inventoryRespository) {
		this.inventoryRespository = inventoryRespository;
	}
	
	@Override
	public Inventory findByPartnumber(long partNumber) {
		logger.info("Inventory find By :" + partNumber);
		return inventoryRespository.findOne(new Long(partNumber));
	}

	@Override
	public Inventory create(Inventory inventory) {
		return inventoryRespository.save(inventory);
	}

	@Override
	public boolean update(Inventory inventory) throws Exception {
		
		if(inventoryRespository.exists(new Long(inventory.getPartnumber()))) {
			inventoryRespository.save(inventory);
			return true;
		}
		throw new Exception("Given partnumber is not found:"+ inventory.getPartnumber());
	}

	@Override
	public boolean deleteByPartnumber(long partnumber) throws Exception {
		if(inventoryRespository.exists(new Long(partnumber))) {
			inventoryRespository.delete(partnumber);;
			return true;
		}
		throw new Exception("Given partnumber is not found:"+ partnumber);

	}

}
