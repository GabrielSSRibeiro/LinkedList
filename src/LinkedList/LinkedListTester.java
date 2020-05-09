/*
 * File: LinkedListTester.java
 * Author: Gabriel Ribeiro
 * This class implements a generic linkedList class.

 */
package LinkedList;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/**
 *Tester class that creates a MyLinkedList object and read instructions for it 
 * from a file.
 */
public class LinkedListTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(new File("list-ops.txt"));
        
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        
        while (scan.hasNext()) {
         
            //scan the whole instruction line, breaking it into parts that are 
            //stored in a array
            String[] instructions = scan.nextLine().split(" ");
            int[] specs = new int[2];
            
            //stores only the specs for each instruction in a array of ints
            for(int i = 1 ; i < instructions.length ; i++){
                specs[i - 1] = Integer.parseInt(instructions[i]);  
            }
                 
            // calls the correct method according to the instructions from the 
            //file and prints the operartion
            switch (instructions[0]) {
                case "APPEND":
                    list.APPEND(specs[0]);
                    System.out.println("appended " + specs[0]);
                break;
                case "ADD":
                    list.ADD(specs[0], specs[1]);
                    System.out.println("added " + specs[1] + " at position "
                            + specs[0]);
                break;
                case "DELETE":
                   list.DELETE(specs[0]);
                   System.out.println("deleted item at position " + specs[0]);
                break;
                case "SWAP":
                   list.SWAP(specs[0], specs[1]);
                   System.out.println("swapped " + specs[0] + " and " + specs[1]);
                break;
                case "REVERSE":
                    list.REVERSE();
                    System.out.println("list reversed");
                break;
                case "CLEAR":
                    list.CLEAR();
                    System.out.println("list cleared");
                break;
            }   
            //prints the updated list after each interaction
            System.out.println(list);
        }
    scan.close();
    
    }
}
