package com.tutorial.spring.boot.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.mockito.Mockito.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tutorial.spring.boot.InventoryApplication;
import com.tutorial.spring.boot.model.Inventory;
import com.tutorial.spring.boot.services.InventoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InventoryApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryControllerTest {

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InventoryControllerTest.class);

	private InventoryController inventoryController;

	private InventoryService mockInventoryService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		inventoryController = new InventoryController();
		mockInventoryService = mock(InventoryService.class);
		inventoryController.setInventoryService(mockInventoryService);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetInventoryByPartnumberSucessful() throws JsonProcessingException {

		Inventory testDataInventory = new Inventory();
		testDataInventory.setPartnumber(3434334);
		testDataInventory.setChannel("Online");
		testDataInventory.setMaxOrderOuantity(23223);
		testDataInventory.setPreOrderQuantity(34);

		when(mockInventoryService.findByPartnumber(Long.parseLong("3434334"))).thenReturn(testDataInventory);
		Inventory responseInventoryData = inventoryController.getInventoryByPartnumber("3434334");
		Assert.assertNotNull(responseInventoryData);
		Assert.assertEquals(responseInventoryData.getPartnumber(), testDataInventory.getPartnumber());

	}

	@Test
	public final void testGetInventoryByPartnumberNotSucessful() throws JsonProcessingException {
		when(mockInventoryService.findByPartnumber(anyLong())).thenReturn(null);
		Inventory responseInventoryData = inventoryController.getInventoryByPartnumber("3434334");
		Assert.assertNull(responseInventoryData);
	}

	@Test
	public final void testWhenCreateInventorySuccessful() {
		Inventory testDataInventory = new Inventory();
		testDataInventory.setPartnumber(3434334);
		testDataInventory.setChannel("Online");
		testDataInventory.setMaxOrderOuantity(23223);
		testDataInventory.setPreOrderQuantity(34);

		when(mockInventoryService.create(testDataInventory)).thenReturn(testDataInventory);
		ResponseEntity<Void> response = inventoryController.createInventory(testDataInventory,
				UriComponentsBuilder.newInstance());
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);

	}

	@Test
	public final void testWhenCreateInventoryNotSuccessful() {
		Inventory testDataInventory = new Inventory();
		testDataInventory.setPartnumber(3434334);
		testDataInventory.setChannel("Online");
		testDataInventory.setMaxOrderOuantity(23223);
		testDataInventory.setPreOrderQuantity(34);

		when(mockInventoryService.create(testDataInventory)).thenReturn(null);
		ResponseEntity<Void> response = inventoryController.createInventory(testDataInventory,
				UriComponentsBuilder.newInstance());
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);

	}

	@Test
	public final void testUpdateInventorySuccessful() throws Exception {
		Inventory testDataInventory = new Inventory();
		testDataInventory.setPartnumber(3434334);
		testDataInventory.setChannel("Online");
		testDataInventory.setMaxOrderOuantity(23223);
		testDataInventory.setPreOrderQuantity(34);

		when(mockInventoryService.update(any(Inventory.class))).thenReturn(true);
		ResponseEntity<Inventory> response = inventoryController.updateInventory(Long.parseLong("3434334"),
				testDataInventory);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public final void testUpdateInventoryNotSuccessful() throws Exception {
		Inventory testDataInventory = new Inventory();
		testDataInventory.setPartnumber(3434334);
		testDataInventory.setChannel("Online");
		testDataInventory.setMaxOrderOuantity(23223);
		testDataInventory.setPreOrderQuantity(34);

		when(mockInventoryService.update(any(Inventory.class))).thenReturn(false);
		ResponseEntity<Inventory> response = inventoryController.updateInventory(Long.parseLong("3434334"),
				testDataInventory);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testWhenDeleteInventoryNotSuccessful() throws Exception {

		when(mockInventoryService.deleteByPartnumber(anyLong())).thenReturn(false);
		ResponseEntity<Void> response = inventoryController.deleteInventory(Long.parseLong("34334334"));
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);

		when(mockInventoryService.deleteByPartnumber(anyLong())).thenThrow(Exception.class);
		response = inventoryController.deleteInventory(Long.parseLong("34334334"));
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);

	}

	@Test
	public final void testWhenDeleteInventorySuccessful() throws Exception {

		when(mockInventoryService.deleteByPartnumber(anyLong())).thenReturn(true);
		ResponseEntity<Void> response = inventoryController.deleteInventory(Long.parseLong("34334334"));
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

}
