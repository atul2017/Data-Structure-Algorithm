package threads.callableexample;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) throws Exception{

        JavaCallable javaCallable = new JavaCallable();

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(javaCallable);

        Integer result = future.get();

        System.out.println("Result is ->"+ result);

    }
}
