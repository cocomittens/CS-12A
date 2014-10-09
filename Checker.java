import java.util.Scanner;

/**************************************************/
/* Author:      Corrie Gripenstraw                */
/*  Date:        February 7, 2014                 */
/*  Program:     Lab 3 assignment                 */
/*  Description: Generates a checkerboard with    */
/*    the number of columns and rows and the      */ 
/*      character used for and size of the tiles  */
/*      entered by the user                       */
/*                                                */
/**************************************************/


public class Checker {
    
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

    /*********************************************************************/
    /* getBoard ( char tileChar, int numRows, int numCols, int tileSize )*/
    /*                                                                   */
    /* Generates a checkerboard with the specified number of rows,       */
    /*  columns, tile size, and tile character.                          */
    /*                                                                   */
    /* Input:  Character used for the tiles, number of rows, number      */
    /*     of columns, size of each tile                                 */
    /* Output: String containing the generated board                     */
    /*********************************************************************/

    public static String getBoard(char tileChar, int numRows, int numCols, int tileSize){
        String board = "";
        for(int i=0; i<numCols; i++){
            for(int j=0; j<tileSize; j++){
                for(int k=0; k<numRows; k++){
                    // every other column starts with a filled tile
                    if(i%2 == 0)
                        board += (k%2==0) ? multiplyChar(tileChar, tileSize) : multiplyChar(' ', tileSize);
                    else
                       board += (k%2==0) ? multiplyChar(' ', tileSize) : multiplyChar(tileChar, tileSize); 
                }
            board +="\n";
            }
        }
        return board;
    }
    
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int numRows, numCols, cellSize;
        char cellChar = 's';
        String grid;

        System.out.print( "Enter dimensions: ");
        numRows = scan.nextInt();
        numCols = scan.nextInt();
        cellSize = scan.nextInt();
        cellChar =  scan.next().charAt(0);
          
        grid = getBoard(cellChar, numRows, numCols, cellSize);

        System.out.print(grid);
          

    }

}
