package threadlabs.lab2;

public class SecondProducer extends Thread {
    SecondQueue secondQueue;

    public SecondProducer(SecondQueue secondQueue){
        super("SecondProducer");
        this.secondQueue = secondQueue;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try{
                secondQueue.put(new Product(5));
                Thread.sleep(100);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}
