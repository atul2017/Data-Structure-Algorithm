package Threading.AdderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value val = null;
    public Adder(Value val){
        this.val = val;
    }


    @Override
    public Void call() {
        for(int i=1;i<=100;i++){
            System.out.println("Adder Print current thread: "+Thread.currentThread().getName());
            val.number = val.number +1;
        }
        return null;
    }
}
