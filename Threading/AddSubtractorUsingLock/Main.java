package Threading.AddSubtractorUsingLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception{
        Value val = new Value();
        Lock lock = new ReentrantLock();

        Adder adder = new Adder(val,lock);
        Substractor substractor = new Substractor(val,lock);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> futureAdder = es.submit(adder);
        Future<Void> futureSubstractor  = es.submit(substractor);

        futureAdder.get();
        futureSubstractor.get();

        System.out.println("Value->"+val.number);


    }
}
