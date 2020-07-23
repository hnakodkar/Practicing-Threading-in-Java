package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

    List<Product> soldProductsList = new CopyOnWriteArrayList<Product>();
    List<Product> purchasedProductsList = new CopyOnWriteArrayList<>();

    Vector vector = new Vector();
    public void populateSoldProducts(){
        for(int i =0 ;i<1000; i++){
            Product product = new Product(i,"test_product" + i);
            soldProductsList.add(product);
            System.out.println("added product " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProductsList(){
        for(Product product : soldProductsList){
            System.out.println("displaying list of sold products " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Arraylist is not thread safe so use CopyOnWriteArraylist instead of ArrayList
        // make sure to use concurrent util collection import for multi threading for working with collection

    }


}
