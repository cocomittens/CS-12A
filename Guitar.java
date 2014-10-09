//=================================================//
//  Author:      Corrie Gripenstraw                //
//  Date:        March 14, 2014                    //
//  Program:     Program 5                         //
//  Description: A program that simulates a guitar //
//   using a computer keyboard. Each note can      //
//   be played with the corresponding key of the   //
//   keyboard. E.g. note A can be played by typing //
//   'A'.                                          //
//=================================================//

public class Guitar{
    public static void main(String[] args){
    //frequency values of each note on the C4 Major scale
    double c = 261.626, d = 293.665, e = 329.628, f = 349.228, g = 391.995, a = 440.000, b = 493.883;
    GString stringC = new GString(c);
    GString stringD = new GString(d);
    GString stringE = new GString(e);
    GString stringF = new GString(f);
    GString stringG = new GString(g);
    GString stringA = new GString(a);
    GString stringB = new GString(b);

     while (true) {
        // if the user has typed a key, pluck the appropriate string
        if (StdDraw.hasNextKeyTyped()) {
            char key = StdDraw.nextKeyTyped();
                switch(key){
                    case 'c':
                        stringC.pluck();
                        break;
                    case 'd':
                        stringD.pluck();
                        break;
                    case 'e':
                        stringE.pluck();
                        break;
                    case 'f':
                        stringF.pluck();
                        break;
                    case 'g':
                        stringG.pluck();
                        break;
                    case 'a':
                        stringA.pluck();
                        break;
                    case 'b':
                        stringB.pluck();
                        break;
                    }
}
              // determine what note or combination of notes is to be played
              double sample = stringA.sample() + stringB.sample() + stringC.sample() + stringD.sample() + stringE.sample() + stringF.sample() + stringG.sample();
  
              // play the note
              StdAudio.play(sample);
  
              // advance the simulation of each guitar string by one step   
              stringA.tic();
              stringB.tic();
              stringC.tic();
              stringD.tic();
              stringE.tic();
              stringF.tic();
              stringG.tic();

          }
        

    }
}
