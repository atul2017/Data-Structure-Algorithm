package Threading.ProducerConsumer;

public class Consumers implements Runnable {
    private Store store;
    private int consumerNumber;

    public Consumers(Store store, int i){
        this.store = store;
        this.consumerNumber =i;
    }

    @Override
    public void run(){
        while(true){
            //System.out.println("Consumers thread: "+Thread.currentThread().getName());
            if(store.getItemCount()>0){
                try{
                    System.out.println("Consumed by consumers: "+consumerNumber);
                    System.out.println("Item number consumed by consumers: "+store.getItemCount());
                    store.setItemCount(store.getItemCount()-1);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
