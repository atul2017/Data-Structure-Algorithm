package Threading.ProducerConsumer;

public class Producers implements Runnable{

    private Store store;
    private int producerNumber;


    public Producers(Store store, int i){
        this.store = store;
        this.producerNumber =i;
    }


    @Override
    public void run() {
        while(true){
            if(store.getItemCount()<store.getMaxItemCount()){
                try{
                    System.out.println("Produced by producer: "+producerNumber);
                    System.out.println("Item produced by producer: "+store.getItemCount());
                    store.setItemCount(store.getItemCount()+1);
                }catch(Exception ex){
                    ex.printStackTrace();
                }

            }
        }
    }
}
