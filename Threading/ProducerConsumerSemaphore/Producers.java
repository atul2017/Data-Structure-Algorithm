package Threading.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producers implements Runnable {

    private Store store;

    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    int producerNumber;

    public Producers(Store store,Semaphore producerSemaphore,Semaphore consumerSemaphore,int i){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.producerNumber = i;
    }


    public void prodItem(){
        try{
            System.out.println("Producer"+producerNumber);
            producerSemaphore.acquire();
            Thread.sleep(100);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        store.addItem(producerNumber);
        consumerSemaphore.release();

    }

    @Override
    public void run() {
        while(true){
            prodItem();
        }
    }


}
