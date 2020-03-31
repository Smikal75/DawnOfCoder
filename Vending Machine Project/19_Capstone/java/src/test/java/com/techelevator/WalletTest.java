package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class WalletTest extends Wallet {
	
	@Test
	public void addfunds_method_returns_bigdecimal_2_when_2_is_input() {
		//method header explains what we test
		Wallet testWallet = new Wallet();
		//step 1 ^ construct the object being tested (unless the method is static)
		BigDecimal testInput = BigDecimal.valueOf(2);
		//step 2 ^ declare and assign any variables to be tested
		BigDecimal expected = BigDecimal.valueOf(2);
		//step 3 ^ declare and assign 'expected', a variable that holds the expected result when we
		//		   run the method with the testInput	
		BigDecimal actual= testWallet.addFunds(testInput);
		//step 4 ^ declare and assign 'actual; this should call the method with the testInput
		assertEquals(expected,actual);
		//step 5 ^ assetEquals (expected, actual);
	}
	
	@Test
	public void sale_method_returns_crunchcrunchyum_for_chip_items() {
		Wallet testWallet = new Wallet(BigDecimal.valueOf(5));
		Items testItems = new Chip(BigDecimal.valueOf(1),"TestChip","A3");
		String expected = "Crunch Crunch, Yum!";
		String actual = testWallet.sale(testItems);
		assertEquals(expected,actual);
	}
	
	@Test
	public void sale_method_returns_insufficentfunds_for_balance_less_than_price() {
		Wallet testWallet = new Wallet(BigDecimal.valueOf(1));
		Items testItems = new Gum(BigDecimal.valueOf(5),"TestGum","A3");
		String expected = "Please insert additional funds to purchase this item!";
		String actual = testWallet.sale(testItems);
		assertEquals(expected,actual);
	}
	@Test
	public void sale_method_returns_sold_out_for_items_quantity_0() {
		Wallet testWallet = new Wallet(BigDecimal.valueOf(5));
		Items testItems = new Items(BigDecimal.valueOf(1),"TestGum","A3","SOLD OUT");
		String expected = "SOLD OUT. Please make another selection.";
		String actual = testWallet.sale(testItems);
		assertEquals(expected,actual);
	}
	@Test
	public void sale_method_returns_change_correctly_for_end_of_transaction() {
		Wallet testWallet = new Wallet(BigDecimal.valueOf(.4));
		String expected = "Your change is 1 quarters, 1 dimes, 1 nickels\nYour current balance is $0.00";
		String actual = testWallet.endTransaction();
		assertEquals(expected,actual);
}
}
