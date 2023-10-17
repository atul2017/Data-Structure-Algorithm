package Collections.Comparable;

public class Car implements Comparable<Car>{

    int speed;

    int engineCapacity;

    public Car(int speed, int engineCapacity){
        this.speed = speed;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public int compareTo(Car o) {
        return this.speed - o.speed;
    }
}
