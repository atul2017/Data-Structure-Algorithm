package Threading.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumers implements Runnable{

    private Store store;

    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private int consumerNumber = 0;

    public Consumers(Store store,Semaphore producerSemaphore,Semaphore consumerSemaphore, int i){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.consumerNumber = i;
    }

    @Override
    public void run() {
       while(true){
           conItem();
       }
    }

    public void conItem(){
        try{
            System.out.println("Consumer"+consumerNumber);
            consumerSemaphore.acquire();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        store.removeItem(consumerNumber);
        producerSemaphore.release();
    }
}
