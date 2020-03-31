package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_REPORT = "";
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String DOLLAR_AMOUNT_1 = "Add $1.00";
	private static final String DOLLAR_AMOUNT_2 = "Add $2.00";
	private static final String DOLLAR_AMOUNT_5 = "Add $5.00";
	private static final String DOLLAR_AMOUNT_10 = "Add $10.00";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String[] ADD_DOLLAR_OPTIONS = { DOLLAR_AMOUNT_1, DOLLAR_AMOUNT_2, DOLLAR_AMOUNT_5,
			DOLLAR_AMOUNT_10 };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}


	public void run() {
		Map<String, Items> inventory = IO.createInventory();
		IO.createLog();
		System.out.println(IO.timeStamp());
		while (true) {
			String choiceMain = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choiceMain.equals("report")) {
				System.out.println(IO.salesReport(inventory) + " created:");
			}
			else if (choiceMain.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayInventory(inventory);

			} else if (choiceMain.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean inPurchaseMenu = true;
				Wallet wallet = new Wallet();
				while (inPurchaseMenu) {
					System.out.println("Current Balance: $" + String.format("%.2f", wallet.getBalance()));
					String choicePurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (choicePurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						boolean inAddDollar = true;
						while (inAddDollar) {
							String choiceAddDollar = (String) menu.getChoiceFromOptions(ADD_DOLLAR_OPTIONS);

							if (choiceAddDollar.equals(DOLLAR_AMOUNT_1)) {
								wallet.addFunds(BigDecimal.valueOf(1));
								inAddDollar = false;
							} else if (choiceAddDollar.equals(DOLLAR_AMOUNT_2)) {
								wallet.addFunds(BigDecimal.valueOf(2));
								inAddDollar = false;
							} else if (choiceAddDollar.equals(DOLLAR_AMOUNT_5)) {
								wallet.addFunds(BigDecimal.valueOf(5));
								inAddDollar = false;
							}

							else if (choiceAddDollar.equals(DOLLAR_AMOUNT_10)) {
								wallet.addFunds(BigDecimal.valueOf(10));
								inAddDollar = false;
							} // end of add dollar menu
						}
					} else if (choicePurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

						boolean inSelectProduct = true;
						String[] vendPositions = new String[inventory.size()];
						int x = 0;
						for (String key : inventory.keySet()) {

							vendPositions[x] = key; 
							x++;
						}
						while (inSelectProduct) {
							displayInventory(inventory);
							
							String selectedProduct = Query.askValid("\nPlease Select A Product:", vendPositions);
							
							System.out.println(wallet.sale(inventory.get(selectedProduct)));
							inSelectProduct = false;
						}

					} else if (choicePurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						System.out.println(wallet.endTransaction());
						inPurchaseMenu = false;
					}
				}
			} // end of purchase menu
		 else if (choiceMain.equals(MAIN_MENU_OPTION_EXIT)) {
			 System.out.println("Log out at "+ IO.timeStamp());
			 
			 System.exit(0);
		 } else if (choiceMain.equals(MAIN_MENU_OPTION_REPORT)) {
			 System.out.println("Report generated");
		 }
		}//End of main menu

	}

	public String displayInventory(Map<String, Items> inventory) {
		System.out.print("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("\n+++++++++++++++++++Vendo-Matic 800++++++++++++++++++++++");
		System.out.print("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("\n-ID#--------QTY----------Product-----------------$$$----\n");
		for (String pos : inventory.keySet()) {

			System.out.print(String.format("||%-5s|", pos));
			System.out.print(String.format("|%8s|", inventory.get(pos).getQuantity()));
			System.out.print(String.format("|%20s|", inventory.get(pos).getName()));
			System.out.print(String.format("|%13s||\n", String.format("$%.2f", inventory.get(pos).getPrice())));
		}
		System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		return inventory.keySet() + "";
	}

	public static void main(String[] args) {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run(); // Starts the menu which returns an Object named choice

	}
}
