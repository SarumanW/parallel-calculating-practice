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
        while(!isInterrupted()){
            try {
                eat();
                Thread.sleep(400);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void eat(){
        if(fork_low.take()){
            if(fork_high.take()){
                System.out.println(Thread.currentThread().getName() + " is eating");
                fork_high.putDown();
                fork_low.putDown();
            }
            else{
                fork_low.putDown();
            }
        }
    }
}
