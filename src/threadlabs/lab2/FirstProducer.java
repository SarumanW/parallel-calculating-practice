package threadlabs.lab2;

public class FirstProducer extends Thread {
    FirstQueue firstQueue;

    public FirstProducer(FirstQueue firstQueue){
        this.firstQueue = firstQueue;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            firstQueue.push(new Product(5));
            System.out.println("First producer pushed product");
            try{
                Thread.sleep(20);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
