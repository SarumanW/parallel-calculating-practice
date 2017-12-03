package threadlabs.lab3;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyAtomicInteger count = new MyAtomicInteger();
        MyAtomicInteger max = new MyAtomicInteger();
        MyAtomicInteger min = new MyAtomicInteger();

        int array[] = ArrayGenerator.generateArray();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            for (int x : array) {
                if (x == 2)
                    count.incrementAndGet();
            }
        });

        executor.submit(() ->{
            for(int x : array){
                max.updateMax(x);
                min.updateMin(x);
            }
        });

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println(count.get());
        System.out.println(max.get());
        System.out.println(min.get());
    }
}
