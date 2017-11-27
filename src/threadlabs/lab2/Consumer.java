package threadlabs.lab2;

public class Consumer extends Thread {
    FirstQueue firstQueue;
    SecondQueue secondQueue;

    public Consumer(FirstQueue firstQueue, SecondQueue secondQueue){
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
    }

    @Override
    public void run(){
        int iter = 1;
        while(!isInterrupted()){
            Product product;
            if(iter%3==0)
                product = secondQueue.pull();
            product = firstQueue.pull();
            System.out.println("Consumer took product");
            iter++;
            if(product!=null){
                try{
                    System.out.println("Task is perfoming");
                    Thread.sleep(product.time);
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                Thread.yield();
            }

        }
    }
}
