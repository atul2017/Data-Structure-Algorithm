package Threading.AdderSubstractorSynchronizedmethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception{
        Value val = new Value();
        Adder adder = new Adder(val);
        Substractor subs = new Substractor(val);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<Void> addFuture = es.submit(adder);
        Future<Void> subsFuture = es.submit(subs);

        subsFuture.get();
        addFuture.get();

        System.out.println("The value of number is: "+val.value);
    }
}
