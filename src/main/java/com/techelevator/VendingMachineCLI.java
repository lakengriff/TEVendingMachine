package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.math.BigDecimal;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;

	public String getMAIN_MENU_OPTION_DISPLAY_ITEMS() {
		return MAIN_MENU_OPTION_DISPLAY_ITEMS;
	}

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;
	}
	Display display = new Display();
	PurchaseDisplay purchaseDisplay = new PurchaseDisplay();


	public void run() {
		boolean running = true;
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					purchaseDisplay.displayItems();
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					purchaseDisplay.purchaseMenu();
					break;
				case MAIN_MENU_OPTION_EXIT:
					//exit
					break;
				case MAIN_MENU_SECRET_OPTION:
					//secret menu print sales report
					break;
				default:
					System.out.println("Invalid choice, please type a number 1-4.");
					break;
			}
		}
	}

	public static void main(String[] args) {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}



}
