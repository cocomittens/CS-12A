import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.util.*;



//===============================================//
//  Author:      Corrie Gripenstraw              //
//  Date:        February 28, 2014               //
//  Program:     Program 4                       //
//  Description: Generates images of the         //
//   Julia set of the function                   //
//   f(z) = z^2 + c                              //
//===============================================//

class Julia
{
    static class Complex
    { 
      double real, imaginary;
      public Complex(double realC, double imaginaryC)
      {
          real = realC;
          imaginary = imaginaryC;
      }
      //multiply complex numbers
      public static Complex multiply(Complex x,Complex y)
      {
          Complex c = new Complex((x.real*y.real)-(x.imaginary*y.imaginary),(x.real*y.imaginary)+(x.imaginary*y.real));
          return c;
      }
      //add complex numbers
      public static Complex add(Complex x,Complex y)
      {
          Complex c = new Complex(x.real+y.real,x.imaginary+y.imaginary);
          return c;
      }
      //get the magnitude of complex numbers
      public double getMagnitude()
      {
          return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
      }
    }

    // hsb color table
    public static int getHSBColor(int idx)
    {
        return Color.getHSBColor((float)(idx/255.0), 1.0f, 1.0f).getRGB();
    }

    //evalutes the funcion f(z) = z^2 + c
    public static Complex evaluateFunction(Complex z, Complex c)
    {
        z = Complex.multiply(z,z);
        z = Complex.add(z,c);
        return z;
    }
    
  public static void main(String[] args)
    {
       System.out.println("Input: C(real) C(imag) Xmin Xmax Ymin Ymax fname"); 
       Scanner scan = new Scanner(System.in);
       double real = scan.nextDouble();
       double imaginary  = scan.nextDouble();
       double minX=scan.nextDouble();
       double maxX=scan.nextDouble();
       double minY=scan.nextDouble();
       double maxY=scan.nextDouble();
       String fileName = scan.next();
       
       BufferedImage img = new BufferedImage(512, 512, BufferedImage.TYPE_3BYTE_BGR);
       //change in x and y
       double incrementX = (maxX - minX)/512.0;
       double incrementY = (maxY - minY)/512.0;
       Complex c = new Complex(real, imaginary);
       
       //image is 512x512 pixels
       for(int i=0;i<512;i++)
       {
           for(int j=0;j<512;j++)
           {
               Complex z = new Complex( (minX+j*incrementX) , (minY+i*incrementY) );
               int counter = 0;
               boolean valid = true;

               while (valid)
               {
                   z = evaluateFunction(z, c);
                   ++counter;
                  
                   //either z has escaped or has iterated enough times
                   if(counter == 255 || z.getMagnitude()>=2)
                        valid = false;
               }

               img.setRGB(j,i,getHSBColor(counter));
           }
       }
       //create the image
         try{
            ImageIO.write(img, "JPG", new File(fileName+".jpg"));
         }
        catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
         }

    }
}
 
