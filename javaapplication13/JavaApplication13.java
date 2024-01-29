package javaapplication13;
import java.lang.reflect.Array;
interface QueueADT
{
    boolean isEmpty();
    boolean full();
    void enqueue(int x);
    int dequeue();
}
//-------------------------------------

class Queue implements QueueADT
{
    public int elementsArray[];
    private int front;
    private int rear;

    public Queue(int size)
    {
        elementsArray=new int[size];
        front=-1;
        rear=-1;
    }

    public boolean isEmpty()
    {
        return (front==-1);
    }

    public boolean full()
    {   //here
        return (front==(rear+1)%elementsArray.length);
    }

    public void enqueue(int x)
    {
        if(full()){
            System.out.println("Queue is full!, cannot enqueue"+x);
            return;
        }
        if(front==-1)
            front=0;
        rear=(rear+1)%elementsArray.length;
        elementsArray[rear]=x;
        System.out.println("+ element " +x+" enqueued");
    }

    public int dequeue()
    {
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        int x =elementsArray[front];
        System.out.println("- element " +x+" dequeued");
        if(front==rear){
            front=-1;
            rear=-1;
        }else{
            front=(front+1)%elementsArray.length;
        }
        return x;
    }
}
//--------------------------------------

public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue Q = new Queue(9);
        System.out.println(Q.isEmpty());
        for (int i = 1; i <= 9; i++) {
            Q.enqueue(i);
            if (i % 3 == 0) {
                int x = Q.dequeue();
            }
        }
        System.out.println("The elements remaining in the queue:");
        while (!Q.isEmpty())
        {
            System.out.println("element "+ Q.dequeue());
        }
    }
}