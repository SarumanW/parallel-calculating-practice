package threadlabs.lab2;

public class SecondProducer extends  Thread{
    SecondQueue secondQueue;

    public SecondProducer(SecondQueue secondQueue){
        this.secondQueue = secondQueue;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            secondQueue.push(new Product(5));
            System.out.println("Second producer pushed product");
            try{
                Thread.sleep(20);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
