package Queues;

public class QueuesUsingLinkedList {
    static Queue frontPointer = null;
    static Queue rearPointer = null;

    static  int numberofNodes =  0;

    public static void main(String[] args) {
        new QueuesUsingLinkedList().enqueue(10);
        new QueuesUsingLinkedList().enqueue(20);
        new QueuesUsingLinkedList().enqueue(100);
        new QueuesUsingLinkedList().dequeue();
        new QueuesUsingLinkedList().dequeue();
        new QueuesUsingLinkedList().dequeue();
        new QueuesUsingLinkedList().enqueue(10);
        System.out.println("Is queue empty->"+new QueuesUsingLinkedList().isEmpty());
        System.out.println("Rear->"+new QueuesUsingLinkedList().rear());
        System.out.println("Front->"+new QueuesUsingLinkedList().front());
    }

    void enqueue(int data) {
        Queue node = new Queue(data);
        if(rearPointer==null){
            rearPointer = node;
            frontPointer = node;
            numberofNodes++;
        }else{
            node.next = rearPointer;
            rearPointer = node;
            numberofNodes++;
        }
    }

    void dequeue() {
        if(frontPointer==null) {
            System.out.println("Queue is Empty");
        }else if(frontPointer==rearPointer){
            rearPointer =null;
            frontPointer = null;
            numberofNodes--;
        }else{
            Queue tempTraverseNode = rearPointer;
            int i =1;
            while(i<=numberofNodes){
                if(i==numberofNodes-1){
                    frontPointer = tempTraverseNode;
                    tempTraverseNode.next = null;
                    numberofNodes--;
                    break;
                }
                i++;
                tempTraverseNode = tempTraverseNode.next;
            }
        }
    }

    boolean isEmpty() {
        if(rearPointer==null){
            return true;
        }
        return false;
    }

    int front(){
        if(frontPointer!=null){
            return frontPointer.data;
        }
        return -1;
    }

    int rear(){
        if(rearPointer!=null){
            return rearPointer.data;
        }
        return -1;
    }
}
class Queue{
    int data;
    Queue next;
    Queue(int data){
        this.data = data;
        next = null;
    }
}
