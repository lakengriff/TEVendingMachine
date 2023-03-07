package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.util.Map;
import java.util.Scanner;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private VendingMenu menu;

    public String getMAIN_MENU_OPTION_DISPLAY_ITEMS() {
        return MAIN_MENU_OPTION_DISPLAY_ITEMS;
    }

    public VendingMachineCLI(VendingMenu menu) {
        this.menu = menu;
    }

    Scanner input = new Scanner(System.in);
    Inventory inventory = new Inventory();
    Balance customerBalance = new Balance();
    Map<String, Product> inventoryMap = inventory.importInformation();

    public static void main(String[] args) {
        VendingMenu menu = new VendingMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            switch (choice) {
                case MAIN_MENU_OPTION_DISPLAY_ITEMS:
                    inventory.displayItems(inventoryMap);
                    break;
                case MAIN_MENU_OPTION_PURCHASE:
                    String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    switch (purchaseChoice) {
                        case PURCHASE_MENU_OPTION_FEED_MONEY:
                            customerBalance.feedMoney();
                            System.out.println("Your available balance is: $" + customerBalance.getBalance());
                            break;
                        case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                            customerBalance.dispenseItem(inventoryMap, customerBalance, purchaseChoice, inventory);
                            break;
                        case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
                            customerBalance.makeChange(customerBalance.getBalance());
                            customerBalance.setBalanceToZero();
                            break;
                    }
                    break;
                case MAIN_MENU_OPTION_EXIT:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please type a number 1-3. Option 4 is under construction!");
                    break;
            }
        }
    }
}