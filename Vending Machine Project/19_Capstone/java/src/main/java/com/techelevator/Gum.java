package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Items {

	public Gum(BigDecimal price, String name, String position) {
		super(price, name, position);
		setSaleMessage("Chew Chew, Yum!");

	}

}
