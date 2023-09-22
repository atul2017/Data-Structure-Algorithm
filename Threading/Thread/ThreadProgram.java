package Threading.Thread;

import java.util.Scanner;

public class ThreadProgram {

    public static void main(String [] args){

        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter second number");
        int firstNumber = myInput.nextInt();
        System.out.println("Enter first number");
        int secondNumber = myInput.nextInt();
        HelloWorld hw = new HelloWorld();
        Thread th= new Thread(hw);
        System.out.println(Thread.currentThread().getName());
        th.start();
    }
}
