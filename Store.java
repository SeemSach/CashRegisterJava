/*
Implement a Cash	Register
        • Command	line	application
        • Your	store	has	a	list	items
        – 1-	10	Pants	at	price	100.
        – 2-	40	Shoes	at	price	400
        – 3-	50	Shirts	at	price	99
        – …
        Each	of	these	items	have	price,	quantity	and	description.
        Your	program	should	print	the	list	of	all	the	items	in	the	store	as
        shown	above	and	ask	the	user
        Program:	which	would	you	like	to	purchase:
        user:	<1>
        Program:	how	many	pants	would	you	like?
        user:	<2>
        Program:	your	total	cost	is	200$
        Program	should	adjust	the	quantity	leQ	in	the
store	for	that	item.
• Maintain	a	history	list	of	all	the	purchase	that
includes	the	name,	amount,	the	item	name,
total	amount.
Bonus
• Your	program	should	have	a	manager	menu.
• If	manager	enters	the	special	key.
• The	program	will	allow	the	manager	to
restock
• The	program	will	allow	the	manger	to	view
history.
• This	program	does	not	persist	any	data.
 */

//Code written by: Seema Shabadi Date: 14/09/2022

//This is our View class (of MVC model) for our project. We are using it as an interface to interact with user
//This class also is a starting point
//In this class we are printing the menu and asking user about if a purchase is to be made or manager control to add, print  stock or print the purchase history
//This has self explinatory options for user how to interact with our store application


import java.util.*;

public class Store {

    public static void main(String []args)
    {
        Scanner scan=new Scanner(System.in);
        Stock st=new Stock();

        System.out.println("****************************** Welcome to New Trend Clothing  ******************************");

        do {
            System.out.println("What do you want to do?\n1. Purchase\n2. Manager");
            switch (scan.next().charAt(0)) {
                    case '1':
                        st.purchase();
                        break;
                    case '2':


                           System.out.println("Please enter password:");
                           if (scan.next().equals("mgr123")) {
                               do {
                               System.out.println("What do you want to do?\n1.\tAdd Stock\n2.\tDisplay Stock\n3.\tDisplay Purchase History");
                               switch (scan.next().charAt(0)) {
                                   case '1':
                                       st.updateStock();
                                       break;
                                   case '2':
                                       st.printStock();
                                       break;
                                   case '3':
                                       st.showPurchaseHistory();
                                       break;
                               }

                               System.out.println("Manager, do you want to continue?(Yes-y/No-n)");
                           }while (scan.next().charAt(0) != 'n') ;

                       }
                       else
                       {System.out.println("Incorrect Password...");}

                        break;
                }
            System.out.println("Do you want to return to main menu?(Yes-y/No-n)");
            }while(scan.next().charAt(0)!='n');

    }
}

