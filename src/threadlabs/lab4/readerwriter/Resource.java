package threadlabs.lab4.readerwriter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Resource {
    private List<String> items;
    private final ReadWriteLock readWriteLock;
    private final Lock readLock;
    private final Lock writeLock;

    public Resource(){
        items = new ArrayList<>();
        readWriteLock = new ReentrantReadWriteLock(true);
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();

        fillWithData();
    }

    public void read(int key){
        readLock.lock();

        try{
            System.out.println("The data for key is " + items.get(key) + " read by "
                    + Thread.currentThread().getName());
        } finally{
            readLock.unlock();
        }
    }

    public void write (String value){
        writeLock.lock();

        try{
            items.add(value);
            System.out.println("The data is setted by "
                    + Thread.currentThread().getName());
        } finally{
            writeLock.unlock();
        }
    }

    private void fillWithData(){
        for(int i = 0; i<10; i++){
            items.add("Data" + i);
        }
    }
}
