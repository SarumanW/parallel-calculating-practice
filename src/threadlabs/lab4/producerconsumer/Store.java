package threadlabs.lab4.producerconsumer;

import threadlabs.lab2.Product;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private static final int MAX_SIZE = 5;
    private final List<Product> items = new LinkedList<>();

    public synchronized void put(Product product) throws InterruptedException {
        while(items.size() == MAX_SIZE) {
            wait();
        }

        items.add(product);
        System.out.println("Producer added product");

        notifyAll();
    }

    public synchronized void get(){
        while(items.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product product = items.get(0);
        if(product!=null){
            items.remove(0);
            System.out.println("Consumer took product");
            notifyAll();
        }
    }
}
