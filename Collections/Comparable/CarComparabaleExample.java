package Collections.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CarComparabaleExample {

    public static void main(String[] args){
        Car c1 = new Car(120,100);
        Car c2 = new Car(180,80);
        System.out.println(c1.compareTo(c2));


        //Compare the object stored in the priority queue data structure
        PriorityQueue<Car> pq = new PriorityQueue<Car>();
        pq.add(new Car(100,200));
        pq.add(new Car(200,400));
        pq.add(new Car(300,600));
        while(!pq.isEmpty()){
            System.out.println(pq.remove().speed);
        }

        //Comparing the object using the list data structure
        List<Car> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        Collections.sort(list);
        for (Car c: list
             ) {
            System.out.println("Car object speed"+ c.speed);
        }


    }
}
