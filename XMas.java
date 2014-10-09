/*********************************************************************/
/* Program: Days Until Christmas                                     */
/* Author: Corrie Gripenstraw (cgripens@ucsc.edu)                    */
/*                                                                   */
/* CMP 12A/L, Winter 2014                                            */
/* Programming Assignment #2                                         */
/* January 29, 2014                                                  */
/*                                                                   */
/* This program calculates the number of days until Christmas from   */
/*    a date inputted by the user.                                   */
/*                                                                   */
/* Input:                                                            */
/* Date in MMDDYYYY format                                           */
/*                                                                   */
/* Output:                                                           */
/* Date in a readable format (e.g. December 24, 1999) and the        */
/* number of days until Christmas of that year                       */
/*                                                                   */
/* Bugs and limitations:                                             */
/* If a date is entered as the 31st day of a month that does not have*/
/* 31 days (e.g. April 31st), the program will not catch the error   */
/* and will return the equivalent days until Christmas of the last   */
/* day of that month (e.g. April 30th)                               */
/*********************************************************************/

import java.util.Scanner;

public class XMas{

    /*********************************************************************/
    /* getMonth( int month )                                             */
    /*                                                                   */
    /* Takes the number of a month and returns the corresponding         */
    /*    month name (e.g. an input of 5 will return "May")              */
    /*                                                                   */
    /* Input:  Number (1-12) of a month                                  */
    /* Output: String containing the name of the month                   */
    /*********************************************************************/

    public static String getMonth(int month){
        switch(month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Invalid month";
        }
    }

    /*********************************************************************/
    /* daysTilXMas ( int month, int day, int year )                      */
    /*                                                                   */
    /* Calculates the number of days until Christmas. Date cannot be     */
    /* after Christmas of that year. Considers the possibility of leap   */
    /* years.                                                            */
    /*                                                                   */
    /* Input: An integer representing the month, day, and year           */          
    /* Output: Number of days until Christmas                            */
    /*********************************************************************/
    
        public static int daysTilXMas(int month, int day, int year){
            int days = 0;
            boolean isLeapYear;
            isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)); 
            for(int i=month; i<12; i++){
                if(i==2)
                    if(isLeapYear)
                        days+=29;
                    else
                        days+=28;
                else if(i==1||i==3||i==5||i==7||i==8||i==10)
                    days+=31;
                else
                    days+=30;
            }
            days += 25 - day;
            return days;
        }
        
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter date: ");
        int date = scan.nextInt();
                
        //extracts the month, day, and year from the date entered
        int day, month, year;
        year = date % 10000;
        date = date / 10000;
        day = date % 100;
        date = date / 100;
        month = date;

        //prints the date and the number of days until Christmas
        int daysTilXMas = daysTilXMas(month, day, year);
        String monthStr = getMonth(month);
        if(month > 12 || month < 1)
            System.out.println("Invalid month.");
        else if(day > 31 || day < 1)
            System.out.println("Invalid day.");
        else if(month == 12 && day > 25)
            System.out.println("Invalid input.");
                else{
            System.out.println("Date is: " + monthStr + " " + day + ", " + year);
                        if(daysTilXMas != 0)
                            System.out.println("Days until Christmas: " + daysTilXMas);
                        else
                            System.out.println("Merry Christmas!");
                }
        
    }
}