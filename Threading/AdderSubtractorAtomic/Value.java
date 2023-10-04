package Threading.AdderSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {

    public AtomicInteger  number;

    public Value(){
        number = new AtomicInteger(0);
    }

}
