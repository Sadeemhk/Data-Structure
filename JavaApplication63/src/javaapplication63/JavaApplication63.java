/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication63;
/**
 *
 * @author batool
 */

interface List {

    void addFront(int x); //Add Element at the beginning of the list

    void addEnd(int x); //Add Element at the end of the list

    void addMid(int val, int x); //Add Element after the value val in the list

    void print(); // print all the elements in the list

    boolean empty();// return true if the list is empty

    void removeEnd();// remove the last element in the list

    void removeFront();// remove the first element in the list

    void remove(int x);// remove the element x from the list

    void removeAll();// remove all elements in the list

    boolean exist(int x);// check if the element x is in the list
}
//=================================================//

class DoubleLinkedList implements List {

    private DNode head;
    private DNode tail;
//--------------------------------------------------

    public DoubleLinkedList() 
    {
        head = null;
        tail = null;
        
    }
//--------------------------------------------------

    @Override
    public void addFront(int x) {
      DNode newNode = new DNode(x);
      
      if(head==null){ //new node is the only element so both points to the newNode
          head= newNode;
          tail= newNode;  
      }
      else{
          head.previous=newNode; //prev points to the node inserted
          newNode.next=head; //sl
          head= newNode; //sl
      }
    }
//--------------------------------------------------

    public void addEnd(int x) {
       DNode newNode = new DNode(x);
       if(head==null){
           tail = newNode;
           head = newNode;
       }
       else{
           tail.next = newNode;
           newNode.previous = tail;
           tail = newNode;
       }
    }
//--------------------------------------------------

    @Override
public void addMid(int val, int x) {
    DNode newNode = new DNode(x);
    DNode temp = head;
    while (temp != null) {
        if (temp.data == val) {
            newNode.next = temp.next;
            newNode.previous = temp;
            
            if (temp.next != null) {
                temp.next.previous = newNode;
            }
            
            temp.next = newNode;
            
            if (temp == tail) {
                tail = newNode;
            }
            
            break;
        }
        temp = temp.next;
    }
}

//--------------------------------------------------

    @Override
    public void print() {
        System.out.println("printing the elements forwards");
        if(head==null)
            System.out.println("the list is empty");
        DNode temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        
  
                
        
    }
//--------------------------------------------------

    @Override
    public boolean empty() {
       return head == null;
    }
//--------------------------------------------------

    @Override
    public void removeEnd() {
    if(tail!=null){ //if thers an element to remove
        tail=tail.previous;
        
        if(tail != null)//more than one element
            tail.next=null; 
        else //only element
          head=null;  
    }
    }
//--------------------------------------------------

    @Override
    public void removeFront() {
        if(head!=null){
            head=head.next;
            if(head!=null)
                head.previous=null;
            else
                tail=null;
        }
    }
//--------------------------------------------------

    @Override
    public void remove(int x) {
   
    DNode temp = head;
    while (temp != null && temp.data != x) {
        temp = temp.next;
    }

    if (temp == null) {
        System.out.println("Item is not found");
        return;
    }

    // Update the next and previous references 
    if (temp.previous != null) {
        temp.previous.next = temp.next;
    } else {
        // If the node to remove is the head update the head
        head = temp.next;
    }

    if (temp.next != null) {
        temp.next.previous = temp.previous;
    } else {
        // If the node to remove is the tail, update the tail
        tail = temp.previous;
    }
       
       
    }
//--------------------------------------------------

    @Override
    public void removeAll() {
         head=null;
         tail=null;
    }
//--------------------------------------------------

    @Override
    public boolean exist(int x) {
       
       DNode current = head;
    
    while (current != null) {
        if (current.data == x) {
            return true;
        }
        current = current.next;
    }
    
    return false;
    }
    
}
//=======================================================================//

class DNode {

    int data;
    DNode next;
    DNode previous;

    public DNode(int data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public String toString() {
        return data + " ";
    }

}
//=======================================================================//

public class JavaApplication63 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLinkedList L1 = new DoubleLinkedList();
        //--------------------------------adding
        L1.addFront(3);
        L1.addEnd(3);
        L1.addMid(3, 50);
        L1.addFront(2);
        L1.addEnd(2);
        L1.addMid(50, 10);
        L1.addMid(3, 10);
        L1.addFront(1);
        L1.addEnd(1);
        
        
        L1.exist(50);
        System.out.println("After adding elements:");
        L1.print();
        System.out.println();
        //--------------------------------removing
        L1.removeFront();
        L1.removeEnd();
        L1.remove(50);
        System.out.println("After deleteing elements:");
        L1.print();
        System.out.println();
        //--------------------------------searching
        int num = 50;
        if (!L1.exist(num)) {
            System.out.print(num + " is not found in the list\n");
        } else {
            System.out.print("Number is in the list\n");
        }
        //---------------------------------removing all
        L1.removeAll();
        if (L1.empty()) {
            System.out.print("linke list now is empty\n");
        }

    }

}
