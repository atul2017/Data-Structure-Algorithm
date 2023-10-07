package Threading.AddSubtractorUsingLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {

    Value val = null;

    Lock lock = null;

    public Adder(Value val, Lock lock){
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Void call(){
       //If you put the lock.lock before starting the for loop &
        //lock.unlock() right after immediately end of for loop
        //This will not result in the parallel execution of the threads
        for(int i=1;i<=1000;i++){
            System.out.println("Requesting lock for adding " + i );
            lock.lock();
            //System.out.println("Adder Print current thread: "+Thread.currentThread().getName());
            val.number = val.number + 1;
            lock.unlock();
        }
        return null;
    }

}
