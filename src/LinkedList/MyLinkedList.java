/*
 * File: MyLinkedList.java
 * Author: Gabriel Ribeiro

I affirm that this program is entirely my own work and none of it is the work
of anyone else.
 */
package LinkedList;

/**
 *A LinkedList of generic nodes, where each Node object has two instance 
 * variables: an object of the “type variable” class, and a pointer to the 
 * next node on the list.
 */
public class MyLinkedList<E> {
    
    private Node head;        // pointer to first Node on the list
    
    /**
    * Implements a simple generic list
    */
    public MyLinkedList(){
        head = null;	  // initially, list is empty
    }
    
    // utility method returns a pointer to the last node on the list
    private Node lastNode(){
        if (head == null)       // if list empty...
        {
            return null;        // ...no last node
        } 
        else                    // get pointer to last node
        {
            Node temp = head;           // ...start at head of list
            while (temp.next != null)   // ...while not at last node...
            {
                temp = temp.next;   // ......move to next node
            }
            return temp;            // ...return pointer to last node
        }
    }
      
    // delete the node AFTER the one pointed to by p
    private void deleteAfter(Node p){
        Node temp = p.next;             // temp points to node to be removed
        p.next = temp.next;             // cut node out of the list
    }
        
    /**
     * Append an object to the end of the list
     * @param X the object to be appended
     */
    public void APPEND(E X){
        // create new Node with "info" member pointing to x
        Node temp = new Node(X);

        if (head == null){
            head = temp;            // put new Node at head of list.
        } 
        else{
            lastNode().next = temp; // append new node to end of list
        }
    }
    
    /**
     * 
     * @param N
     * @param X 
     */
    public void ADD(E N, E X){
        
        if (head == null){
            return;   // if empty list, we're done
        }
        
        Node newNode = new Node(X);       
        Node current = head;		
        Node prev = null;	
        int position = 1;
        
        while (!N.equals(position)){
            prev = current;
            current = current.next;
            position++;
        }

        if (current == head){
            newNode.next = head;
            head = newNode;
        } 
        else{
            newNode.next = current;
            prev.next = newNode; 
        }
    
    }
    
    /**
     * deletes a node from the list
     * @param N the user specified position of the element to be deleted
     */
    public void DELETE(E N){    
        
        if (head == null){
            return;   // if empty list, we're done
        }
               
        Node current = head;	// point current to 1st node
        Node prev = null;	
        int position = 1;      //start at the first element
        
        //repeat while the user specified position is not equal to the current one
        while (!N.equals(position)){    
            
            //advances the Node by 1 element and increments the position 
            prev = current;
            current = current.next;
            position++;
        }

        if (current == head){
            head = head.next;	   // ...remove it and update head
        } 
        else{
            current = current.next; 
            deleteAfter(prev);  // ...remove the node
        }

    }
    
    /**
     * Swaps two nodes in the list
     * @param M the user specified position of the 1st element to be swapped
     * @param N the user specified position of the 2nd element to be swapped
     */
    public void SWAP(E M, E N){
    
        if (head == null){
            return;   // if empty list, we're done
        }
        
        //finds the position of nodeN
        Node nodeN = head;		
        int position = 1;
        
        while (!N.equals(position)){ 
            nodeN = nodeN.next;
            position++;
        }
        
        //finds the position of nodeM
        Node nodeM = head;		
        position = 1;
        
        while (!M.equals(position)){    
            nodeM = nodeM.next;
            position++;
        }
        
        //deletes the node at position N
        DELETE(N);
        //adds nodeM at the position N
        ADD(N, nodeM.info);
        
        //deletes the node at position M
        DELETE(M);
        //adds nodeN at the position M
        ADD(M, nodeN.info);           
    }
    
    /**
     * reverses the list by 
     */
    public void REVERSE(){
    
        if (head == null){
            return;   // if empty list, we're done
        }
        
        //saves the original last node
        Node last = lastNode() ;
        Node temp = head ;
        
        
        //For each node on the list except the last...  	
        while(!head.equals(last)){
            
            //remove the node from the list       
            head = head.next;
            
            //keeps the list going
            Node afterLast = last.next ;                  
            Node newNode = new Node(temp.info);
            
            //and insert it immediately after the original last node
            last.next = newNode;           
            newNode.next = afterLast;
            
            temp = temp.next;
        }               
        
    }
    
    /**
     * Make the list empty.
     */
    public void CLEAR(){
        head = null; 
    }
    
    /**
     * Return a String containing all the objects on the list
     * @return the list as a String
     */
    public String toString(){
        String out = "";
        Node temp = head; 		// start at head of list 
        
        if(head == null){
            return "The list is empty. \n";
        }
        while (temp != null)            // while more nodes on list...
        {
            out += temp.info + "  ";	// ...append current obj
            temp = temp.next;		// ...and move to next node
        }
        return out + "\n";
    }
    
    //inner class
    class Node{
        private E info;      // stores an object of the type parameter class
                            
        private Node next;   // points to next node on the list

        /**
         * Create a Node object
         * @param x param of class E
         */
        Node(E x){
            info = x;       // set info portion to parameter passed
            next = null;    // not yet pointing to another Node
        }
    }
    
}
