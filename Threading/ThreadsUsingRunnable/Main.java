package Threading.ThreadsUsingRunnable;

public class Main {
    public static void main(String[] args){
        //print the number from 1-10 using different threads

        for(int i=1;i<=10;i++){
            NumberPrinter np = new NumberPrinter(i);
            Thread th = new Thread(np);
            th.start();
        }

    }
}
