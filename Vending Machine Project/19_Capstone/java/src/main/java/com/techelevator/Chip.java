package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Items {

	public Chip(BigDecimal price, String name, String position) {
		super(price, name, position);
		setSaleMessage("Crunch Crunch, Yum!");
	}

}
