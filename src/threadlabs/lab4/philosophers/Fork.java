package threadlabs.lab4.philosophers;

import java.util.concurrent.Semaphore;

public class Fork {
    private Semaphore fork;
    private int id;

    Fork(int id) {
        this.id = id;
        fork = new Semaphore(1);
    }

    public int getId() {
        return id;
    }

    public boolean take() {
        return fork.tryAcquire();
    }

    public void putDown() {
        fork.release();
    }
}
