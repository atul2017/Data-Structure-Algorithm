package Threading.AdderSubtractorAtomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception{
        Value val = new Value();
        Adder adder = new Adder(val);
        Substractor sub = new Substractor(val);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> futureAdd = es.submit(adder);
        Future<Void> futureSub = es.submit(sub);

        futureAdd.get();
        futureSub.get();

        System.out.println("Value of the value->"+val.number);

        es.shutdown();

    }
}
