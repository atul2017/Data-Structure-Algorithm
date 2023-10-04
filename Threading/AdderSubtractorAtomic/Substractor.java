package Threading.AdderSubtractorAtomic;

import java.util.concurrent.Callable;

public class Substractor implements Callable<Void> {

    private Value val;
    public Substractor(Value val){
        this.val = val;
    }


    @Override
    public Void call() throws Exception {

        for(int i=1;i<=100;i++){
            val.number.addAndGet(-i);
        }

        return null;
    }
}
