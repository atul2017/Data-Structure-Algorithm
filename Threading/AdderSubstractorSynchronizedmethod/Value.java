package Threading.AdderSubstractorSynchronizedmethod;

public class Value {
    public int value =0;

    public synchronized void increamentBy(int i){
        this.value = this.value + i;
    }
}
