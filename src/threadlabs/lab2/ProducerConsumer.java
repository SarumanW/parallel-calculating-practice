package threadlabs.lab2;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        FirstQueue firstQueue = new FirstQueue();
        SecondQueue secondQueue = new SecondQueue();

        Consumer consumer = new Consumer(firstQueue, secondQueue);
        FirstProducer firstProducer = new FirstProducer(firstQueue);
        SecondProducer secondProducer = new SecondProducer(secondQueue);

        consumer.start();
        firstProducer.start();
        secondProducer.start();

        Thread.sleep(15000);
        consumer.interrupt();
        firstProducer.interrupt();
        secondProducer.interrupt();
    }
}
