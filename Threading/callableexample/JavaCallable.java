package threads.callableexample;

import java.util.Random;
import java.util.concurrent.Callable;

public class JavaCallable implements Callable {

    @Override
    public Object call() throws Exception {
        Random randomObj = new Random();
        Integer randNo = randomObj.nextInt();
        Thread.sleep(10000);
        return randNo;
    }
}
