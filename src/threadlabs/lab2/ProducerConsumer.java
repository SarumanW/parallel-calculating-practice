package threadlabs.lab2;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        FirstQueue firstQueue = new FirstQueue();
        SecondQueue secondQueue = new SecondQueue();
        int n = 3;

        FirstProducer fp = new FirstProducer(firstQueue);
        SecondProducer sp = new SecondProducer(secondQueue);
        Consumer c = new Consumer(firstQueue, secondQueue, n);

        fp.start();
        sp.start();
        c.start();

        Thread.sleep(5000);
        fp.interrupt();
        sp.interrupt();
        c.interrupt();
        System.out.println("ARE INTERRUPTED!!!");
        System.out.println(firstQueue.getDeletedProducts());
        System.out.println(secondQueue.getItems().size());

    }
}
