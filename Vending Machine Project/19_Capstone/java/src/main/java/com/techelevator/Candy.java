package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Items {

	public Candy(BigDecimal price, String name, String position) {
		super(price, name, position);
		setSaleMessage("Munch Munch, Yum!");
	}

}
