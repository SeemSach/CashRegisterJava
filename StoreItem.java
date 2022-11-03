//Code written by: Seema Shabadi Date: 14/09/2022
//StoreItem class is a Model class (of MVC model) to our project where we will initialize/add the StoreItems
//Here we are using constructor to set the initial values for store item name, quantity and price

public class StoreItem {
      private String ItemName;
      private int ItemQty;
      private double ItemPrice;
      public StoreItem()
      {

      }
      public StoreItem(String itemName, int itemQty, double itemPrice)
      {
          this.ItemName=itemName;
          this.ItemQty=itemQty;
          this.ItemPrice=itemPrice;
      }

      //Following are getter and setter methods to update/add the store

      public String getItemName() {
        return ItemName;
    }

      public void setItemName(String itemName) {this.ItemName = itemName;}

      public int getItemQty() {
        return ItemQty;
    }

      public void setItemQty(int itemQty) {
        this.ItemQty = itemQty;
    }

      public double getItemPrice() {
        return ItemPrice;
    }

      public void setItemPrice(double itemPrice) {
        this.ItemPrice = itemPrice;
    }


     //We are overriding the toString definition as we want to display the store items in the form that we need
    @Override
    public String toString() {
        return "StoreItem{" +
                "ItemName='" + ItemName + '\'' +
                ", ItemQty=" + ItemQty +
                ", ItemPrice=" + ItemPrice +
                '}';
    }
}



