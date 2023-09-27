package Threading.AdderSubstractorSynchronizedmethod;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value val = null;

    public Adder(Value val){
        this.val = val;
    }

    @Override
    public Void call() throws Exception {
        for(int i=1;i<=100;i++){
            val.increamentBy(i);
            System.out.println("The value is: "+val.value+" "+Thread.currentThread().getName());
        }
        return null;
    }
}
