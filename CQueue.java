//===============================================//
//  Author:      Corrie Gripenstraw              //
//  Date:        March 6, 2014                   //
//  Program:     Lab 5 assignment                //
//  Description: A class with 2 methods: printing//
//   the elements in the queue and shifting      //
//   them to the left by 1                        //
//===============================================//

public class CQueue{
    int size;
    float[] buffer;
    // constructor for CQueue object
    public CQueue (int capacity){
        size = capacity;
        buffer = new float[size];
    }
    // circular shift of the elements of the CQueue instance to the left
    public void shift(){
        float a = buffer[0];
        for (int i=0; i < size-1;  i++){
            buffer[i] = buffer[i+1];
        }
        buffer[size-1] = a;
    }
    // prints the value of element on a new line
    public void print(){
        for(int i=0; i<size; i++){
        float element = buffer[i];
        System.out.format("Element %4d: %.2f %n", i, element );
        }
    }
}
