//Code written by: Seema Shabadi Date: 14/09/2022
//PurchaseHistory class is another Model class (of MVC model) to our project where we will initialize/add the history which is date and time whenever purchase is made
//PurchaseHistory class is inherited from StoreItem


import java.util.Date;
public class PurchaseHistory extends StoreItem {
     private Date purchaseTime;
    //Here we are using constructor to set the date whenever a purchase is made
    //default constructor is needed to have parameterized constructor
   PurchaseHistory(){

     }

     public PurchaseHistory(String name, double price, int qnt, Date pTime) {
          super(name, qnt, price);
          this.purchaseTime = pTime;
     }


    //We are overriding the toString definition as we want to display the purchase history in a form that we need
     @Override
     public String toString() {
          return "PurchaseHistory{" +
                  "\tItem : "+ getItemName()+
                  "\tQuantity : " + getItemQty() +
                  "\tpurchaseTime : " + purchaseTime +
                  '}';
     }

}


