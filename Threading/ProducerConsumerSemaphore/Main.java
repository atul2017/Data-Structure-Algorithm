package Threading.ProducerConsumerSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args){
        Store store = new Store();
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        ExecutorService es = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            Producers cs = new Producers(store,producerSemaphore,consumerSemaphore,i+1);
            es.execute(cs);
        }

        for(int i=0;i<100;i++){
            Consumers ps = new Consumers(store,producerSemaphore,consumerSemaphore,i+1);
            es.execute(ps);
        }
    }
}
