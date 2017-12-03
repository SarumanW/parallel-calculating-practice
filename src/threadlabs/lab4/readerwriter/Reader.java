package threadlabs.lab4.readerwriter;

import java.util.Random;

public class Reader extends Thread {
    Resource resource;
    private Random random;

    public Reader(Resource resource){
        super("Reader thread");
        this.resource = resource;
        random = new Random();
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            resource.read(random.nextInt(10));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
