package com.techelevator;

import java.math.BigDecimal;

public class Wallet {
	private BigDecimal balance = BigDecimal.valueOf(0);

	// Sale: a method that checks to see if the item is in stock and if the balance
	// is sufficient for
	// purchase. if so the transaction is made.
	
	public Wallet () {
		
	}
	public Wallet (BigDecimal balance) {
		this.balance= balance;
	}
	public BigDecimal getBalance () {
		return balance;
	}
	
	public String sale(Items vendItem) {
		String returnMessage = "";
		if (balance.compareTo(vendItem.getPrice()) >= 0 && !vendItem.getQuantity().equals("SOLD OUT")) {
			IO.enterToLog(vendItem.getName(), balance, balance.subtract(vendItem.getPrice()));
			balance = balance.subtract(vendItem.getPrice());

			returnMessage = vendItem.sale();
		} else {
			if (vendItem.getQuantity().equals("SOLD OUT")) {
				returnMessage = "SOLD OUT. Please make another selection.";
			} else {
				returnMessage = "Please insert additional funds to purchase this item!";
			}
		}

		return returnMessage;
	}

	// add funds to the balance in whole dollar amounts.
	public BigDecimal addFunds(BigDecimal userInput) {
		IO.enterToLog("DEPOSIT", balance, balance.add(userInput));
		balance = balance.add(userInput);
		return balance;
	}

	// completes the transaction and returns change.
	public String endTransaction() {
		IO.enterToLog("GIVE CHANGE", balance, BigDecimal.valueOf(0));
		balance = balance.multiply(BigDecimal.valueOf(100));
		int inCents = balance.intValue();
		System.out.println(inCents);
		String quarters = inCents / 25 > 0 ? inCents / 25 + " quarters" : "";
		inCents = inCents % 25;
		String dimes = inCents / 10 == 0 ? ""
				: quarters.equals("") ? inCents / 10 + " dimes" : ", " + inCents / 10 + " dimes";
		inCents = inCents % 10;
		String nickels = inCents / 5 == 0 ? ""
				: dimes.equals("") && quarters.equals("") ? inCents / 5 + " nickels" : ", " + inCents / 5 + " nickels";
		inCents = inCents % 5;
		balance = balance.subtract(balance);

		return "Your change is " + quarters + dimes + nickels + "\nYour current balance is $"
				+ String.format("%.2f", balance);
	}

}
