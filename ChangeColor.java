//===============================================//
//  Author:      Corrie Gripenstraw              //
//  Date:        Feb 21, 2014                    //
//  Program:     Lab 4 assignment                //
//  Description: Converts an image to gray and   //
//                  sepia tones                  //
//===============================================//

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

public class ChangeColor{
    
  //===================================//
  // reads in an image                 //
  //===================================//

  static BufferedImage readImage( String fname ) throws Exception {

    BufferedImage image = ImageIO.read( new File(fname) );
    return( image );
  }

  //===================================//
  // saves file                        //
  //===================================//

  public static void saveImage( BufferedImage img, File file ) throws IOException {

        ImageWriter      writer = null;
        java.util.Iterator iter = ImageIO.getImageWritersByFormatName("jpg");

        if( iter.hasNext() ){
            writer = (ImageWriter)iter.next();
        }

        ImageOutputStream ios = ImageIO.createImageOutputStream( file );
        writer.setOutput(ios);

        ImageWriteParam param = new JPEGImageWriteParam( java.util.Locale.getDefault() );
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
        param.setCompressionQuality(0.98f);

        writer.write(null, new IIOImage( img, null, null ), param);

    }
    
  //===================================//
  // converts color image to grayscale //
  //===================================//

  public static BufferedImage color2gray( BufferedImage inImage ) {

    int            width    = inImage.getWidth();
    int            height   = inImage.getHeight();
    BufferedImage  outImage = new BufferedImage( width, height, BufferedImage.TYPE_3BYTE_BGR );

    // Here are the steps needed to process each color pixel:
    // a. read each pixel from the BufferedImage using getRGB,
    // b. turn the int representing the pixel into red, green, blue components, each scaled 0..1,
    // c. combine the components into a gray scale value using the given formula in the description,
    // d. make a new Color object with this gray scale value,
    // e. find the int equivalent of that color using getRGB, and
    // f. save that as new pixel value in outImage using setRGB
    //
    // put your code here -- about 20 lines of code
    //
    int pixel;
    float red, green, blue, out_r, out_g, out_b, gray;
    for(int y=0; y<height; y++){
        for(int x=0; x<width; x++){
            pixel = inImage.getRGB(x, y);
            //extracts the RGB values from a pixel and scales from 0-1
            blue = (pixel & 0xFF)/ 256.0f;
            green = ((pixel >> 8) & 0xFF)/ 256.0f;
            red = ((pixel >> 16) & 0xFF)/ 256.0f;
            //formula to convert to grayscale
            gray = out_r = out_g = out_b = (red * 0.2126f + green * 0.7152f + blue * 0.0722f);

            Color grayColor = new Color(out_r, out_g, out_b);
            outImage.setRGB(x, y, grayColor.getRGB());
        }
    }

    return( outImage );
  }

  //===================================//
  // converts color image to sepia     //
  //===================================//
    
  public static BufferedImage color2sepia( BufferedImage inImage ) {

    int            width    = inImage.getWidth();
    int            height   = inImage.getHeight();
    BufferedImage  outImage = new BufferedImage( width, height, BufferedImage.TYPE_3BYTE_BGR );

    // Here are the steps needed to process each color pixel:
    // a. read each pixel from the BufferedImage using getRGB,
    // b. turn the int representing the pixel into red, green, blue components, each scaled 0..1,
    // c. combine the components into sepia color components using the formula in the description,
    // d. make a new Color object with this sepia color components,
    // e. find the int equivalent of that color using getRGB, and
    // f. save that as new pixel value in outImage using setRGB
    //
    // put your code here -- about 20 lines of code
    //
    int pixel;
    float red, green, blue, out_r, out_g, out_b;
    for(int y=0; y<height; y++){
        for(int x=0; x<width; x++){
            pixel = inImage.getRGB(x, y);
            //extracts the RGB values from a pixel and scales from 0-1
            blue = (pixel & 0xFF) / 256.0f;
            green = ((pixel >> 8) & 0xFF) / 256.0f;
            red = ((pixel >> 16) & 0xFF) / 256.0f;
            //formula to convert to sepia
            out_r = (red * .393f) + (green *.769f) + (blue * .189f);
            out_g = (red * .349f) + (green *.686f) + (blue * .168f);
            out_b = (red * .272f) + (green *.534f) + (blue * .131f);
            //caps the RGB values at 1
            out_r = out_r > 1 ? 1 : out_r;
            out_g = out_g > 1 ? 1 : out_g;
            out_b = out_b > 1 ? 1 : out_b;
        
            Color sepiaColor = new Color(out_r, out_g, out_b);
            outImage.setRGB(x, y, sepiaColor.getRGB());
        }
    }
    
    return( outImage );
  }

  //===================================//
  // main method here                  //
  //===================================//

  public static void main(String[] args) throws Exception {
    
    BufferedImage colorImage, grayImage, sepiaImage;

    if (args.length != 1)
        System.out.println( "usage is: java ChangeColor filename" );
    else
    {
        colorImage = readImage  ( args[0] );
    grayImage  = color2gray ( colorImage );
    sepiaImage = color2sepia( colorImage );

    saveImage( grayImage,  new File( "gray" + args[0] ) );
    saveImage( sepiaImage, new File( "sepia"+ args[0] ) );
    }
  }
    
}
