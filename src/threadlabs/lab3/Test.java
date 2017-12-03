package threadlabs.lab3;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyAtomicInteger count = new MyAtomicInteger();
        MyAtomicInteger max = new MyAtomicInteger();
        MyAtomicInteger min = new MyAtomicInteger();
        MyAtomicInteger xor = new MyAtomicInteger();

        int array[] = ArrayGenerator.generateArray(5);

        byte[] byteArray = ArrayGenerator.convertFromInt(array);

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

        executor.submit(()->{
            for(byte i = 1; i<byteArray.length - 2; i++){
                xor.set((byte) (xor.get()^byteArray[i]));
            }
        });

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Count - " + count.get());
        System.out.println("Max - " + max.get());
        System.out.println("Min - " + min.get());
        System.out.println("XOR - " + xor.get());
    }
}
