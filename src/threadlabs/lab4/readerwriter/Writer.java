package threadlabs.lab4.readerwriter;

import java.util.Random;

public class Writer extends Thread {
    Resource resource;
    private Random random;

    public Writer(Resource resource){
        super("Writer thread");
        this.resource = resource;
        random = new Random();
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            resource.write("Data" + random.nextInt(100));
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
