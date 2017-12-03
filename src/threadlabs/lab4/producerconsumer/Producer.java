package threadlabs.lab4.producerconsumer;

import threadlabs.lab2.Product;

public class Producer extends Thread {
    Store store;

    public Producer(Store store){
        super("Producer thread");
        this.store = store;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try{
                store.put(new Product(5));
                Thread.sleep(10);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}
