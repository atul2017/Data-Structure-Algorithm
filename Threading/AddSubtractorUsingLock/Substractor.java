package Threading.AddSubtractorUsingLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Substractor implements Callable<Void> {

    Value val = null;

    Lock lock = null;

    public Substractor(Value val, Lock lock){
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Void call(){
        //If you put the lock.lock before starting the for loop &
        //lock.unlock() right after immediately end of for loop
        //This will not result in the parallel execution of the threads

        for(int i=1;i<=900;i++){
            System.out.println("Requesting lock for substracting " + i );
            lock.lock();
            //System.out.println("Substractor Print current thread: "+Thread.currentThread().getName());
            val.number = val.number -1;
            lock.unlock();
        }

        return null;
    }


}
