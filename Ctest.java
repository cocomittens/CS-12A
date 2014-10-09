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
public class Ctest{
public class CQueue{
	int size;
	public CQueue (int capacity){
		size = capacity;
	}
	static float buffer[] = new float[size];
	// circular shift of the elements of the CQueue instance to the left
	public static void shift(){
	}
	
	// prints the value of element on a new line
	public static void print(){
		float element;
		for(int i=0; i<size; i++){
			element = buffer[i];
			System.out.println("Element " + i + ": ");
		}
	}
}
    public static void main(String[] args) {

        CQueue  my_favorites = new CQueue( 11 );
        int     i;

	for( i=0; i < my_favorites.size; i++ )
	    my_favorites.buffer[i] = (float) 1.1 * (i+1);

        System.out.println( "My favorites" );
        my_favorites.print();
		}
}