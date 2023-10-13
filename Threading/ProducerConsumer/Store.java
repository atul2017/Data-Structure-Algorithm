package Threading.ProducerConsumer;

public class Store {

    private int itemCount=0;

    private int maxItemCount;

    public Store(int items){
        this.maxItemCount = items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) throws Exception{
        this.itemCount = itemCount;
        if(itemCount>=maxItemCount || itemCount<0){
            throw new Exception("Issue");
        }
    }

    public int getMaxItemCount() {
        return maxItemCount;
    }

    public void setMaxItemCount(int maxItemCount) {
       this.maxItemCount = maxItemCount;
    }
}
