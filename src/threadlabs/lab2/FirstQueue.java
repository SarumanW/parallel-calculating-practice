package threadlabs.lab2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FirstQueue {
    private static final int MAX_SIZE = 3;
    private final List<Product> items = new LinkedList<>();
    private static int deletedProducts = 0;
    //private final Random random = new Random();

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    public int getDeletedProducts() {
        return deletedProducts;
    }

    public void put(Product product) throws InterruptedException {
        lock.lock();
        try {
            if (items.size() == MAX_SIZE) {
                System.out.println(Thread.currentThread().getName() + " : Buffer is full, product deleted");
                deletedProducts++;
                return;
            }

            boolean isAdded = items.add(product);
            if (isAdded) {
                System.out.println(Thread.currentThread().getName() + " added product to the first queue : " + items.size());
                bufferNotFull.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        lock.lock();
        try{
            while(items.size() == 0){
                System.out.println("Can't get from First queue");
                bufferNotFull.await();
            }

            Product product = items.get(0);

            if(product!=null){
                items.remove(0);
                System.out.println("Consumer took product from the first queue");
                bufferNotEmpty.signalAll();
            }
        } finally{
            lock.unlock();
        }
    }
}
