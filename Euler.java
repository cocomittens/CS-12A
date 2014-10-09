/*********************************************************************/
/* Program: Euler's Number                                           */
/* Authors: Corrie Gripenstraw (cgripens@ucsc.edu)                   */
/*                                                                   */
/* CMPS 12A/L, Winter 2014                                           */
/* Programming Assignment #1                                         */
/* January 15, 2014                                                  */
/*                                                                   */
/* This program approximates Euler's number (e) to a user-defined    */
/* precision (n) and compares the approximate value with the true    */
/* value of e.                                                       */
/*                                                                   */
/* Input:                                                            */
/* Integer to determine precision                                    */
/*                                                                   */
/* Output:                                                           */
/* Approximate value of e, true value of e, % error of approximation */
/*********************************************************************/


import java.util.InputMismatchException;
import java.util.Scanner;

public class Euler {
    private static final double trueE = Math.E;
    	/****************************************************************/
        /* getN( String Prompt)                                         */
        /*                                                              */
        /* Gets a positive integer from the user                        */
        /*                                                              */
        /* Input: The prompt displayed to the user                      */
        /* Output: Positive integer                                     */
        /****************************************************************/
        public static int getN(String prompt){
            Scanner scan = new Scanner( System.in );
            int n = 0;
            boolean valid = false;
                     
            while(!valid){
            valid = true;
                try{
                    System.out.print(prompt);
                    n = scan.nextInt();
                    if(n < 0){
                        System.out.println("Error: n cannot be negative.");
                        valid = false;
                    }
                }
                catch(InputMismatchException num){
                    System.out.println("Error: n must be an integer.");
                    scan.nextLine();
                    valid = false;
                }
             }
                        
            return n;
        }
        /****************************************************************/
        /* getEuler( Integer n )                                        */
        /*                                                              */
        /* Approximates Euler's number to precision n                   */
        /*                                                              */
        /* Input:  Degree of precision                                  */
        /* Output: Approximated Eulers' number                          */
        /****************************************************************/
        public static double getEuler(int n){
            // return approximated Euler's number, of n precision
            double e = Math.pow(1+(1.0/ n), n);
            return e;
        }
                 
        public static void main(String[] args){
        	/* Print the approximated and true values of e and the % error */
			int n = getN("Enter n: ");
            double percentErr = (trueE-getEuler(n)) / trueE*100;
            System.out.format( "approximated e: %.10f%n", getEuler(n));
            System.out.format( "true value of e: %.10f%n", trueE);
            System.out.format( "percentage error: %.2f%%%n", percentErr);
			}
        }

