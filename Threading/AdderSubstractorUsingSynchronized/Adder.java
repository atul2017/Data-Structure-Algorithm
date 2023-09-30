package Threading.AdderSubstractorUsingSynchronized;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {

    Value val = null;

    public Adder(Value val){
        this.val = val;
    }

    @Override
    public Void call(){
        for(int i=1;i<=100;i++){
            System.out.println("Requesting lock for adding " + i );
            //You are synchronizing the critical section below
            synchronized (val){
                val.number = val.number + 1;
            }
        }
        return null;
    }

}
