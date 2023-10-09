package Threading.ThreadUsingCachedThreadPool;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers you want to print: ");
        int number = sc.nextInt();
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=1;i<=number;i++){
            NumberPrinter np = new NumberPrinter(i);
            es.execute(np);
        }
    }
}
