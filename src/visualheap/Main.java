/*
 * Assignment #8 - Visual Heap
 * Nick Robinson - CIS 2168 Section 1
 * Main.java - This file builds the structure of the heap
 */

package visualheap;

import java.awt.Color;
import simplegui.SimpleGUI;


public class Main {
    int size = 20;
    Heap heap = new Heap(size);
    SimpleGUI sg;
    
    
    public static void main(String args[]) {
        Main mn = new Main();
    }
    
    public Main() {
        sg = new SimpleGUI(900, 200);
        sg.setBackgroundColor(Color.CYAN);
        this.setupHeap();
        this.start();
    }
    
    public void start() {
       
        while(!heap.isFull()) {
            heap.visualize(sg);
            sg.print("Enter a new number: ");
            int input = (int) sg.keyReadDouble();
            heap.insert(input);
            heap.print();
            sg.eraseAllDrawables();
           
            
            
        }
        
    }
    
    public void setupHeap() {
    }
    
}
