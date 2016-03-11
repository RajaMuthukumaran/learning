package com.tutorial.spring.boot.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Inventory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int availableQuantity;
	private String channel;
	private int maxOrderOuantity;
	private int preOrderQuantity;

	@Id
	private long partnumber;
	
	public long getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(long partnumber) {
		this.partnumber = partnumber;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getMaxOrderOuantity() {
		return maxOrderOuantity;
	}
	public void setMaxOrderOuantity(int maxOrderOuantity) {
		this.maxOrderOuantity = maxOrderOuantity;
	}
	public int getPreOrderQuantity() {
		return preOrderQuantity;
	}
	public void setPreOrderQuantity(int preOrderQuantity) {
		this.preOrderQuantity = preOrderQuantity;
	}
	
}
