package Threading.ThreadsUsingRunnable;

public class NumberPrinter implements Runnable{
    int printNumber;

    public NumberPrinter(int num){
        printNumber = num;
    }

    public void run(){
        System.out.println("This thread is printing number: "+printNumber);
    }
}
