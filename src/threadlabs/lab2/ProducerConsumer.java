package threadlabs.lab2;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        FirstQueue firstQueue = new FirstQueue();

        FirstProducer fp = new FirstProducer(firstQueue);
        Consumer c = new Consumer(firstQueue);

        fp.start();
        c.start();

        Thread.sleep(5000);
        fp.interrupt();
        c.interrupt();
        System.out.println("ARE INTERRUPTED!!!");

    }
}
