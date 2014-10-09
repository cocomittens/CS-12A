//=================================================//
//  Author:      Corrie Gripenstraw                //
//  Date:        March 14, 2014                    //
//  Program:     Program 5                         //
//  Description: A class that powers Guitar.java   //
//=================================================//

public class GString{
    CQueue gbuffer;
    double frequency;
    // constructor for GString object
    public GString (double f){
        frequency = f;
        gbuffer = new CQueue((int)(44100/f) + 1);
    }
    // assigns random values between +/- 0.5 to the buffer of gbuffer
    void pluck(){
        for(int i=0; i<gbuffer.buffer.length; i++){
            gbuffer.buffer[i] = (float)(Math.random()-.5);
        }
    }
    // advances the simulation one time step
    void tic(){
        float avg;
        avg = (gbuffer.buffer[0] + gbuffer.buffer[1])/2;
        avg *= .98;
        gbuffer.buffer[0] = avg;
        gbuffer.shift();
    }
    // returns the first element of gbuffer
    double sample(){
        return gbuffer.buffer[0];
    }
}
