package threadlabs.lab4.producerconsumer;

import threadlabs.lab2.Product;

public class Consumer extends Thread{
    Store store;

    public Consumer(Store store){
        super("Consumer thread");
        this.store = store;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try{
                store.get();
                Thread.sleep(70);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}
