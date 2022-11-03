//Code written by: Seema Shabadi Date: 14/09/2022
//This is our Controller class (of MVC model) for our project. We are using it as bridge/communicator between our View class and Model Class
/*This holds the entire logic to purchase, printing bill, adding/updating stocks, printing stocks, printing purchase history */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class Stock {
    //Stock array
    StoreItem[] stocks;
    //History array
    ArrayList<PurchaseHistory> history;

    Scanner input = new Scanner(System.in);
    Date pdt;

    //We are using constructor here to create and initialize our store items, also creating the objects of history and customer arraylist
    Stock() {
        stocks = new StoreItem[]{new StoreItem("Pants", 10, 100),
                new StoreItem("Shoes", 40, 400),
                new StoreItem("Shirts", 50, 99)};
        history = new ArrayList<PurchaseHistory>();

    }

    //Following arraylist for ProdName, ProdQuantity, ProdPrice is for display ease while printing the bill

    ArrayList<String> ProdName = new <String>ArrayList();
    ArrayList<Integer> ProdQuantity = new <Integer>ArrayList();
    ArrayList<Double> ProdPrice = new <Double>ArrayList();
    double bill = 0;
    String CustomerName;

    //purchase() function will be invoked whenever user has to purchase
    //in this function stocks will be updated whenever a purchase is made

    public void purchase() {
        char op;
        String choice = new String();
        int i=0,quantity=0;

        System.out.println("***********************   Welcome to New Trend Clothing   ***********************");
        System.out.print("Your Name?: ");
        CustomerName = input.next();

        do {
            System.out.println("  Product\t" + "\tPrice\t" + "\tQuantity Available");
            System.out.println("1. " + stocks[0].getItemName() + "\t" + "\t" + stocks[0].getItemPrice() + "\t" + "\t" + stocks[0].getItemQty());
            System.out.println("2. " + stocks[1].getItemName() + "\t" + "\t" + stocks[1].getItemPrice() + "\t" + "\t" + stocks[1].getItemQty());
            System.out.println("3. " + stocks[2].getItemName() + "\t" + "\t" + stocks[2].getItemPrice() + "\t" + "\t" + stocks[2].getItemQty());
            System.out.println("Which would you like to purchase?");
            op = input.next().charAt(0);
            switch (op) {
                case '1':
                    System.out.println("Total Pants quantity available:" + stocks[0].getItemQty());
                    if (stocks[0].getItemQty() <= 0) {
                        System.out.println("Sorry, we are out of stock...");
                    } else {
                        System.out.println("How many pants would you like to purchase?");
                        quantity = input.nextInt();
                        if (quantity > stocks[0].getItemQty()) {
                            System.out.println("Sorry, we can't take your order with this quantity...\nPlease enter the quantity less or equal to: " + stocks[0].getItemQty());
                        } else {
                            stocks[0].setItemQty(stocks[0].getItemQty() - quantity);
                            bill = bill + (quantity * stocks[0].getItemPrice());
                            System.out.println("Total Pants quantity available:" + stocks[0].getItemQty());
                            ProdName.add(stocks[0].getItemName());
                            ProdQuantity.add(quantity);
                            ProdPrice.add(quantity * stocks[0].getItemPrice());
                            StoreItem obj=stocks[0];
                            pdt=new Date();
                            PurchaseHistory p_hist=new PurchaseHistory(obj.getItemName(),obj.getItemPrice(),quantity,pdt);
                            history.add(p_hist);
                        }
                    }
                    i=0;
                    break;
                case '2':
                    System.out.println("Total Shoes quantity available:" + stocks[1].getItemQty());
                    if (stocks[1].getItemQty() <= 0) {
                        System.out.println("Sorry, we are out of stock...");
                    } else {
                        System.out.println("How many Shoes would you like to purchase?");
                        quantity = input.nextInt();
                        if (quantity > stocks[1].getItemQty()) {
                            System.out.println("Sorry, we can't take your order with this quantity...\nPlease enter the quantity less or equal to: " + stocks[1].getItemQty());
                        } else {
                            stocks[1].setItemQty(stocks[1].getItemQty() - quantity);
                            bill = bill + (quantity * stocks[1].getItemPrice());
                            System.out.println("Total Shoes quantity available:" + stocks[1].getItemQty());
                            ProdName.add(stocks[1].getItemName());
                            ProdQuantity.add(quantity);
                            ProdPrice.add(quantity * stocks[1].getItemPrice());
                            StoreItem obj=stocks[1];
                            pdt=new Date();
                            PurchaseHistory p_hist=new PurchaseHistory(obj.getItemName(),obj.getItemPrice(),quantity,pdt);
                            history.add(p_hist);
                        }
                    }
                    i=1;
                    break;
                case '3':
                    System.out.println("Total Shirts quantity available:" + stocks[2].getItemQty());
                    if (stocks[2].getItemQty() <= 0) {
                        System.out.println("Sorry, we are out of stock...");
                    } else {
                        System.out.println("How many Shirts would you like to purchase?");
                        quantity = input.nextInt();
                        if (quantity > stocks[2].getItemQty()) {
                            System.out.println("Sorry, we can't take your order with this quantity...\nPlease enter the quantity less or equal to: " + stocks[2].getItemQty());
                        } else {
                            stocks[2].setItemQty(stocks[2].getItemQty() - quantity);
                            bill = bill + (quantity * stocks[2].getItemPrice());
                            System.out.println("Total Shirts quantity available:" + stocks[2].getItemQty());
                            ProdName.add(stocks[2].getItemName());
                            ProdQuantity.add(quantity);
                            ProdPrice.add(quantity * stocks[2].getItemPrice());
                            StoreItem obj=stocks[2];
                            pdt=new Date();
                            PurchaseHistory p_hist=new PurchaseHistory(obj.getItemName(),obj.getItemPrice(),quantity,pdt);
                            history.add(p_hist);
                        }
                    }
                    i=2;
                    break;

            }
//            StoreItem obj=stocks[i];
//            pdt=new Date();
//            PurchaseHistory p_hist=new PurchaseHistory(obj.getItemName(),obj.getItemPrice(),quantity,pdt);
            //add to history arraylist to print later
           // history.add(p_hist);

            System.out.println("Do you want to continue purchasing? (Yes/No):");
            choice = input.next();
        } while (choice.equals("Yes") || choice.equals("YES") || choice.equals("yes") || choice.equals("y") || choice.equals("Y"));

        printBill(pdt);
    }

    //printBill() prints the bill for customer with details customer name, and all the purchase item details and date, time at what purchase is made

    public void printBill(Date purchaseDT) {
        Object[] Product = ProdName.toArray();
        Object[] q = ProdQuantity.toArray();
        Object[] rate = ProdPrice.toArray();
        if (bill != 0.0) {
            System.out.println("Customer Name: " + CustomerName);
            System.out.println("You purchased:");
            for (int i = 0; i < Product.length; i++)
                System.out.println(Product[i] + "\t" + q[i] + "\t" + rate[i]);
            System.out.println("Your total bill is: $" + bill);
            System.out.println("Purchased On: " + purchaseDT);
            System.out.println("Thank you for the purchase. Please visit us again for more New Trend Clothing...");
            System.out.println("****************************** Welcome to New Trend Clothing  ******************************");
        } else {
            System.out.println("Please visit us again to serve you with more New Trend Clothing...");
            System.out.println("****************************** Welcome to New Trend Clothing  ******************************");
        }
    }

    //updateStock() is used by Manager privilege to add the stock

    public void updateStock() {
        System.out.println("What do you want to update? \n1. Pants\n2. Shoes\n3. Shirts");
        int qty;
        switch (input.next().charAt(0)) {
            case '1':
                System.out.println("What quantity of pants you want to add?");
                qty = input.nextInt();
                stocks[0].setItemQty(stocks[0].getItemQty() + qty);
                System.out.println("Total Pants quantity available:" + stocks[0].getItemQty());
                break;
            case '2':
                System.out.println("What quantity of shoes you want to add?");
                qty = input.nextInt();
                stocks[1].setItemQty(stocks[1].getItemQty() + qty);
                System.out.println("Total Shoes quantity available:" + stocks[1].getItemQty());
                break;
            case '3':
                System.out.println("What quantity of shirts you want to add?");
                qty = input.nextInt();
                stocks[2].setItemQty(stocks[2].getItemQty() + qty);
                System.out.println("Total Shirts quantity available:" + stocks[2].getItemQty());
                break;

        }

    }



//printStock() is to print the stocks whenever manager wants to see the stock
    public void printStock() {
        for (int i = 0; i < stocks.length; i++) {
            System.out.println((i + 1) + "-" + stocks[i].toString());

        }

    }
    //showPurchaseHistory() is to display the purchase history under manager control when manager wants to see the purchase history
    public void showPurchaseHistory(){
        if (history.isEmpty())
            System.out.println("No purchases have been made...");
        for (PurchaseHistory ph : history) {
            System.out.println(ph.toString());
        }
    }

}

