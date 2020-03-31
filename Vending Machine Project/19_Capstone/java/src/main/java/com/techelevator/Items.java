package com.techelevator;

import java.math.BigDecimal;

public class Items {

	// Items class must generate item objects that hold String name, BigDecimal
	// price, int quantity,
	// String saleMessage
	// must output "SOLD OUT" when getQuantity == 0
	private String name;
	private BigDecimal price;
	private String quantity;
	private String saleMessage;
	private String position;


	public Items(BigDecimal price, String name, String position, String quantity) {
		this.price = price;
		this.name = name;
		this.position = position;
		this.quantity = quantity;
		
	}
	public Items(BigDecimal price, String name, String position) {
		super();
		this.price = price;
		this.name = name;
		this.position = position;
		this.quantity = "5";
		this.saleMessage = "";
	}

	public String getQuantity() {
		if (quantity.equals("0")) {
			return "SOLD OUT";
		} else {
			return quantity;
		}
	}

	public String sale() { // increments the quantity down 1 with each sale
		quantity = (Integer.parseInt(quantity) - 1) + "";
		return saleMessage;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getSaleMessage() {
		return saleMessage;
	}

	public String setSaleMessage(String saleMessage) {
		this.saleMessage = saleMessage;
		return saleMessage;
	}

	public String getPosition() {
		return position;
	}

}
