package threadlabs.lab4.producerconsumer;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        producer.start();
        consumer.start();

        Thread.sleep(1000);
        producer.interrupt();
        consumer.interrupt();
    }
}
