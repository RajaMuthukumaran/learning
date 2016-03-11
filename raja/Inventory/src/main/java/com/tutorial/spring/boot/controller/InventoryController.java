package com.tutorial.spring.boot.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tutorial.spring.boot.model.Inventory;
import com.tutorial.spring.boot.services.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	private Logger logger = Logger.getLogger(InventoryController.class);
	
	
	public InventoryService getInventoryService() {
		return inventoryService;
	}


	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}


	@RequestMapping(value="/inventory/{partnumber}", method=RequestMethod.GET)
	public Inventory getInventoryByPartnumber(@PathVariable("partnumber")  String partnumber) throws JsonProcessingException{
		return inventoryService.findByPartnumber(Long.parseLong(partnumber));
	}

	
	@RequestMapping(value="/inventory/", method=RequestMethod.POST)
	public ResponseEntity<Void> createInventory(@RequestBody Inventory inventory, UriComponentsBuilder ucBuilder){
		logger.info("Creating Inventory " );
		logger.info("Creating Inventory " + inventory.getPartnumber());
		Inventory newInventory = inventoryService.create(inventory);
		
        HttpHeaders headers = null;
        ResponseEntity<Void> responseEntity = null;
        
		if(newInventory == null) {
			responseEntity = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST); 
		}
		else {
			headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/inventory/{partnumber}").buildAndExpand(newInventory.getPartnumber()).toUri());
			headers.setIfModifiedSince(new Date().getTime());
			responseEntity = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		return responseEntity; 

	}
	
    @RequestMapping(value = "/inventory/{partnumber}", method = RequestMethod.PUT)
    public ResponseEntity<Inventory> updateInventory(@PathVariable("partnumber") long partnumber, @RequestBody Inventory inventory) {
        logger.info("Updating Inventory " + partnumber);
        
        try {
			inventoryService.update(inventory);
			return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new ResponseEntity<Inventory>(HttpStatus.BAD_REQUEST); 
    }
	
    @RequestMapping(value = "/inventory/{partnumber}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteInventory(@PathVariable("partnumber") long partnumber) {
        logger.info("Updating Inventory " + partnumber);
        boolean returnStatus = false;
        try {
			returnStatus =  inventoryService.deleteByPartnumber(partnumber);
			if(returnStatus) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST); 
    }
    
}
