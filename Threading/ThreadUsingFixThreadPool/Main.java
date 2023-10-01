package Threading.ThreadUsingFixThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        ExecutorService th = Executors.newFixedThreadPool(10);
        for(int i=0;i<=21;i++){
            NumberPrinter np = new NumberPrinter(i);
            th.execute(np);
        }
    }
}
