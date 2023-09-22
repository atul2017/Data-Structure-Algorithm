package Threading.Thread;

public class HelloWorld implements Runnable {

    @Override
    public void run() {
        System.out.println("I am in the main method");
        System.out.println(Thread.currentThread().getName());
    }
}
