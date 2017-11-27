package threadlabs.lab2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecondQueue {
    public static int N = 3;
    List<Product> items = new LinkedList<Product>();
    ReentrantLock lock = new ReentrantLock();
    Condition emptyCondition = lock.newCondition();
    Condition fullCondition = lock.newCondition();

    public void push(Product item){
        lock.lock();

        try{
            try{
                fullCondition.await();
            } catch (InterruptedException e) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, e);
            }
            items.add(item);
            emptyCondition.signal();
        } finally{
            lock.unlock();
        }
    }

    public Product pull(){
        Product result = null;
        lock.lock();

        try{
            if(items.isEmpty()){
                try{
                    emptyCondition.await();
                } catch (InterruptedException e) {
                    Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, e);
                    return null;
                }
            }

            result = items.isEmpty() ? null : items.remove(0);
            fullCondition.signal();
        } finally{
            lock.unlock();
        }
        return result;
    }
}
