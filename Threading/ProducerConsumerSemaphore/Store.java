package Threading.ProducerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Store {
    public Queue<Object> items;

    public Store(){
        items = new ConcurrentLinkedQueue<>();
    }

    public void addItem(int object){
        items.add(new Object());
    }

    public void removeItem(int item){
        items.remove();
    }

    public Queue<Object> getItems(){
        return items;
    }
}
