package Threading.AdderSubstractorUsingSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception{
        Value val = new Value();

        Adder adder = new Adder(val);
        Substractor substractor = new Substractor(val);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> futureAdder = es.submit(adder);
        Future<Void> futureSubstractor  = es.submit(substractor);

        futureAdder.get();
        futureSubstractor.get();

        System.out.println("Value->"+val.number);
    }
}
