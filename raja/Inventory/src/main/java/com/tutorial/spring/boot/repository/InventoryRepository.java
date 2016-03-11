package com.tutorial.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.spring.boot.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {


}