package Threading.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){

        Store store = new Store(5);

        ExecutorService es = Executors.newCachedThreadPool();

        for(int i=0;i<3;i++){
            Producers p = new Producers(store,i+1);
            es.execute(p);
        }

        for(int i=0;i<100;i++){
            Consumers c = new Consumers(store,i+1);
            es.execute(c);
        }

    }
}
