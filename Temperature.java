import java.util.*;
//==================================================//
//  Author:      Corrie Gripenstraw                 //
//  Date:        1/23/14                            //
//  Program:     Lab 2 assignment                   //
//  Description: Takes a temperature and displays   //
//               its equivalent Celsius, Fahrenheit,//
//				 and Kelvin value                   //
//==================================================//



public class Temperature {
    /**********************************************************************/
    /* convertTemp( char tempScale, double Temp )                         */
    /*                                                                    */
    /* Computes the value of a temperature (with a valid temperature      */
    /* scale) in all temperature scales	                                  */
    /*                                                                    */
    /* Input:  Character representing the temperature scale, Temperature  */
    /*          to convert                                                */
    /* Output: An array containing the values of the converted temperature*/
	/*			in the order: Celsius, Fahrenheit, Kelvin, or an array    */
	/*			of 0s if invalid temperature scale.                       */
    /**********************************************************************/
    public static double[] convertTemp(char tempScale, double temp){
        char tempScaleLower = Character.toLowerCase(tempScale);
        double tempC = 0;
        double tempF = 0;
        double tempK = 0;
        switch(tempScaleLower){
            case 'c': 
                tempC = temp;
                tempF = (temp * (9.0/5.0)) + 32;
                tempK = temp + 273.15;
                break;
            case 'f':
                tempC = (temp - 32) * (5.0/9.0);
                tempF = temp;
                tempK = (temp + 459.67) * (5.0/9.0);
                break;
            case 'k':
                tempC = temp - 273.15;
                tempF = (temp * (9.0/5.0)) - 459.67;
                tempK = temp;
                break;
            default:
                System.out.println(tempScale + " is an unknown temperature scale.\nGoodbye.");
                return new double[]{0, 0, 0};
        }
            return new double[] {tempC, tempF, tempK};
        
    }
    
    public static void main(String[] args){
        double temp;
        char tempScale;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        temp = scan.nextDouble();
        tempScale = scan.next().charAt(0);
        double result[] = convertTemp(tempScale, temp);
        boolean valid = result[0] == result[1] ? false: true;
        if(valid){
            System.out.format("%.2f Centigrade = %.2f Fahrenheit = %.2f Kelvin%n", result[0], result[1], result[2]);
            System.out.println("Have a nice day. Goodbye.");
        }
    }

}
