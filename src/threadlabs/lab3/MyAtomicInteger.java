package threadlabs.lab3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger extends AtomicInteger {
    public boolean updateMax(int x){
        while(true){
            int curMax = get();
            if(curMax>=x)
                return false;

            //check whether other thread has already modified the curMax value
            boolean setSuccess = compareAndSet(curMax, x);

            if(setSuccess)
                return true;
        }
    }

    public boolean updateMin(int x){
        while(true){
            int curMin = get();
            if(curMin<=x)
                return false;

            //check whether other thread has already modified the curMin value
            boolean setSuccess = compareAndSet(curMin, x);

            if(setSuccess)
                return true;
        }
    }
}
