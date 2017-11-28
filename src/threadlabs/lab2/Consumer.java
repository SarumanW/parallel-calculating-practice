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
                if(count == n){
                    secondQueue.get();
                    count = 0;
                }
                else {
                    firstQueue.get();
                    count++;
                }
                Thread.sleep(40);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
