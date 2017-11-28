package threadlabs.lab2;

public class Consumer extends Thread {
    FirstQueue firstQueue;

    public Consumer(FirstQueue firstQueue){
        super("Consumer");
        this.firstQueue = firstQueue;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try {
                firstQueue.get();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
