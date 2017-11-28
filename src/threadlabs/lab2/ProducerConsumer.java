package threadlabs.lab2;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        FirstQueue firstQueue = new FirstQueue();
        SecondQueue secondQueue = new SecondQueue();
        int n = 2;

        FirstProducer fp = new FirstProducer(firstQueue);
        SecondProducer sp = new SecondProducer(secondQueue);
        Consumer c = new Consumer(firstQueue, secondQueue, n);

        fp.start();
        sp.start();
        c.start();

        Thread.sleep(4000);
        fp.interrupt();
        sp.interrupt();
        c.interrupt();
        System.out.println("ARE INTERRUPTED!!!");
        System.out.println("Deleted products from first queue : " + firstQueue.getDeletedProducts());
        System.out.println("Size of second queue is : " + secondQueue.getItems().size());

    }
}
