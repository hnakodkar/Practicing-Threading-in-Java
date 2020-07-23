package com.company;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        InventoryManager invManager = new InventoryManager();

        Thread inventoryTask = new Thread(new Runnable() {

            @Override
            public void run() {
                invManager.populateSoldProducts();

            }
        });

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                invManager.displaySoldProductsList();
            }
        });

        inventoryTask.start();
        Thread.sleep(2000);
        displayTask.start();


    }


}