package threadlabs.lab2;

public class FirstProducer extends Thread {
    FirstQueue firstQueue;

    public FirstProducer(FirstQueue firstQueue){
        super("FirstProducer");
        this.firstQueue = firstQueue;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try{
                firstQueue.put(new Product(5));
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
