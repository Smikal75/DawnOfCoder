package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Items {

	public Drink(BigDecimal price, String name, String position) {
		super(price, name, position);
		setSaleMessage("Glug Glug, Yum!");
	}
}
