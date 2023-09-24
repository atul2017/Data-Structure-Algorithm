package Threading.AdderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception{
        Value val = new Value(0);
        ExecutorService es = Executors.newCachedThreadPool();
        Adder adder = new Adder(val);
        Substractor substractor = new Substractor(val);

        Future<Void> addFuture = es.submit(adder);
        Future<Void> subFuture = es.submit(substractor);

        addFuture.get();
        subFuture.get();

        System.out.println("Value->"+val.number);
    }
}
