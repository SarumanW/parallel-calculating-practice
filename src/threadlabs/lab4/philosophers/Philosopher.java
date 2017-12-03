package threadlabs.lab4.philosophers;

public class Philosopher extends  Thread{
    private Fork fork_low;
    private Fork fork_high;

    Philosopher(Fork fork_low, Fork fork_high, String name) {
        super(name);
        this.fork_low = fork_low;
        this.fork_high = fork_high;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }

        while (true) {
            eat();
        }
    }

    private void eat(){
        if(fork_low.take()){
            if(fork_high.take()){
                try {
                    System.out.println(Thread.currentThread().getName() + " is eating");
                    Thread.sleep(2000); // eating;
                } catch (InterruptedException ex) {

                }
                fork_high.putDown();
                fork_low.putDown();
            }
            else{
                fork_low.putDown();
            }
        }
    }
}
