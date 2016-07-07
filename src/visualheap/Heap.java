/*
 * Assignment #8 - Visual Heap
 * Nick Robinson - CIS 2168 Section 1
 * Heap.java - This file builds the structure of the heap
 */

package visualheap;

import java.awt.Color;
import simplegui.SimpleGUI;


public class Heap {
    int lastIndex;
    int[] heap;
    int[] copy;
    Color nonum = new Color(204, 204, 204);
    
    public Heap(int size) { 
        heap = new int[size];
        copy = new int[size];
        lastIndex = 0;
    }
 
    
    public int getParent(int index) {
        return ((index - 1)  / 2);
    }
    
  
    public void insert(int num) {
        int child = lastIndex;

        //copy before you insert
        makeACopy();
     
        //insert and check
        heap[child] = num;

        int parent = getParent(child);
        while (parent >= 0 && heap[child] < heap[parent]) {
            //swap
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;

            //then set child = parent
            child = parent;

            //compute parent to check again
            parent = getParent(child);

        }

        lastIndex++;
        
        
    }
    
    public void delete() {
        
        
    }
    
    public void makeACopy() {
        for(int i = 0; i < heap.length; i++) {
            copy[i] = heap[i];
            
        }
        
    }
    
    
    
    public boolean isFull() {
        return lastIndex == heap.length;
    }
    
    
    public void print() {
        System.out.print("Copy: "  );
        for(int i : copy) {
            
        System.out.print("[" + i +"]");
        }
        System.out.println("");
        
        System.out.print("Heap: "  );
        for(int g : heap) {
            System.out.print("[" + g +"]");
        }
        System.out.println("");
        

    }
    
    public void visualize(SimpleGUI sg) {
        int distance = 0;
        
        //these two offsets put the text in the middle of the squares
        int xOffset = 15;
        int yOffset = 20;
        
        for(int i = 0; i < heap.length; i++) {
            String numText = heap[i] + "";
             if (heap[i] == 0) {
                 sg.drawFilledBox(50 + distance, 100, 40, 40, nonum, 1, "BoxBefore" + i);
                 sg.drawText(numText, 50 + distance + xOffset, 100 + yOffset);
             } else if (i != lastIndex-1 && copy[i] != heap[i]) {
                 sg.drawFilledBox(50 + distance, 100, 40, 40, Color.red, 1, "BoxBefore" + i);
                 sg.drawText(numText, 50 + distance + xOffset, 100 + yOffset);
             } else {
                 sg.drawFilledBox(50 + distance, 100, 40, 40, Color.green, 1, "BoxBefore" + i);
                 sg.drawText(numText, 50 + distance + xOffset, 100 + yOffset);
             }
             distance = distance + 41;
        }
        
    }
    
    public void setupHeap(SimpleGUI sg) {
        int distance = 0;
        
        for (int i = 0; i < heap.length; i++) {
            String numText = heap[i] + "";
            sg.drawFilledBox(50 + distance, 100, 40, 40, nonum, 1.0, "box" + i);
            sg.drawText(numText, 50 + distance, 100);
            distance = distance + 41;
        }
    }

     
}
