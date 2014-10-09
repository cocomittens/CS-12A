
/*********************************************************************/
/* Program: Triangles                                                */
/* Author: Corrie Gripenstraw                                        */
/*                                                                   */
/* CMP 12A/L, Winter 2014                                            */
/* Program 3                                                         */
/* February 12, 2014                                                 */
/*                                                                   */
/* This program draws a right triangle composed of triangles in a    */
/*  "checkerboard" pattern                                           */
/*                                                                   */
/* Input:                                                            */
/* Number of rows of subtriangles, size of subtriangles, character   */
/*  used to make the triangles                                       */
/*                                                                   */
/* Output:                                                           */
/* Checkerboard triangle                                             */
/*********************************************************************/

import java.util.Scanner;

public class Triangle {
    
    /*********************************************************************/
    /* multiplyChar( char ch, int n )                                    */
    /*                                                                   */
    /* Takes a character and multiplies it n times                       */
    /*                                                                   */
    /* Input:  Character, number of times to multiply                    */
    /* Output: String containing multiplied character                    */
    /*********************************************************************/

    public static String multiplyChar(char ch, int n){
        String chStr = Character.toString(ch);
        String result = "";
        for(int i=0; i<n; i++){
            result += ""+chStr;
        }
        return result;
    }

    /**********************************************************************/
    /* getTriangle( char triChar, int triNum, int triSize )               */
    /*                                                                    */
    /* Generates a checkerboard triangle with the specified number of     */
    /*  rows, triangle size, and triangle character.                      */
    /*                                                                    */
    /* Input:  Character used for the triangle, Integer representing      */
    /*   number of rows, size of each triangle                            */
    /* Output: String containing the generated triangle                   */
    /**********************************************************************/

    public static String getTriangle(char triChar, int triNum, int triSize){
        String triangle = "";
        for(int i=0; i<triNum; i++){
            for(int j=0; j<triSize; j++){
                for(int k=0; k<=i; k++){
                    triangle += multiplyChar(triChar, j+1);
                    triangle += multiplyChar(' ', (triSize-(j+1)));
                }
                triangle +="\n";
            }
           
        }
        return triangle;
    }  
  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int triNum, triSize;
        char triChar = 's';
        String triangle;
        
        System.out.print( "Enter dimensions: ");
        triNum = scan.nextInt();
        triSize = scan.nextInt();
        triChar =  scan.next().charAt(0);
        
        triangle = getTriangle(triChar, triNum, triSize);

        System.out.print(triangle);
        System.out.println("Have a nice day. Bye.");
    }
}
