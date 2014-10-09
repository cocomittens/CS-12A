/*********************************************************/
/* Author: Corrie Gripenstraw                            */
/* Date: 1/7/14                                          */
/* Program: Lab 1 assignment                             */
/* Description: Testing & making sure everything works   */
/*********************************************************/

import java.util.*;

class Hello{
    public static void main( String[] args)
    {
	String  name;

	Scanner scan = new Scanner( System.in );
	System.out.print( "What's your name? ");
	name = scan.next();
	
	System.out.format( "Hi %s!\n", name );
	System.out.println("The CMPS12A webpage is: http://users.soe.ucsc.edu/~pang/12a/w14/");
    }
}