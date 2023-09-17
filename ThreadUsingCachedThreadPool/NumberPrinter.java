package ThreadUsingCachedThreadPool;

public class NumberPrinter implements Runnable {

    int number = 0;
    public NumberPrinter(int i){
        this.number = i;
    }

    @Override
    public void run(){
        System.out.println("Print the number: "+number +" :"+Thread.currentThread().getName());
    }
}
