package ThreadUsingFixThreadPool;

public class NumberPrinter implements Runnable {
    int printNumber  = 0;
    public NumberPrinter(int num){
        printNumber = num;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(" This is my number: "+printNumber);
    }
}
