package threadlabs.lab4.readerwriter;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Reader reader = new Reader(resource);
        Writer writer = new Writer(resource);

        reader.start();
        writer.start();

        Thread.sleep(3000);
        reader.interrupt();
        writer.interrupt();
    }
}
