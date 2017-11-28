package threadlabs.lab2;

public class Consumer extends Thread {
    FirstQueue firstQueue;
    SecondQueue secondQueue;
    int n;
    int count = 0;

    public Consumer(FirstQueue firstQueue, SecondQueue secondQueue, int n){
        super("Consumer");
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
        this.n = n;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try {
                if(count%n == 0 && count!=0)
                    secondQueue.get();
                else {
                    count++;
                    firstQueue.get();
                }
                Thread.sleep(25);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
