/*
 * SNHU IT - 145
 * 6-3 Assignment.
 * Paint1.java
 * Author: Ricahard Elphinstone
 * Modifications: 12/04/2021
 *    Formated to industry standards.
 *    Debugged and found 3 errors.
 *    Implemented do-while loop for validation of wall height.
 *    Implemented do-while loop for validation of wall width.
 * Modifications: 12/07/2021
 *    Imported Math class.
 *    Initialized gallonsPerCan and cans Needed.
 *    Added calculation of how many cans of paint needed.
 *    	-Used Math.ceil() to round up for total cans needed.
 *    	-Added output to display as assignment requested.
 */

import java.util.Scanner;
import java.lang.Math;

public class Paint1 {

   public static void main(String[] args) {
      double wallHeight = 0.0;
      double wallWidth = 0.0;
      double wallArea = 0.0;
      double gallonsPaintNeeded = 0.0;
      final double squareFeetPerGallons = 350.0;
      
      double gallonsPerCan = 1.0;
      double cansNeeded;
          
      // Implemented a do-while loop to ensure input is valid      
      do {
         try {
            Scanner scnr = new Scanner(System.in);
            System.out.println("Enter wall height (feet): ");                   // Prompt user to input wall's height.     
            wallHeight = scnr.nextInt();                                                   
            if(wallHeight <= 0 ) {                                              // Validation of height greater than 0.
               throw new Exception("Wall height is not greater than 0.");                                                     
            }                                                                              
            else {                                                                       
               break;                                                           // Exit loop when user input is correct.
            }                                                                                    
         }                                                                                   
         catch(Exception excpt) {                                                
        	System.out.println(excpt.getMessage());                                   
            System.out.println("\n--Input incorrect. Please Try again.--\n");   // Incorrect input was entered.
         }                                                                               
      } while (true);                                                                             
                                                                                                    
         // Implement a do-while loop to ensure input is valid                                                 
      do {                                                                                 
         try {                                                                                   
            Scanner scnr = new Scanner(System.in);                                         
            System.out.println("Enter wall width (feet): ");                    // Prompt user to input wall's width.        
            wallWidth = scnr.nextInt();                                                   
            if(wallWidth <= 0 ) {                                               // Validation of width greater than 0.
               throw new Exception("Wall width is not greater than 0.");                                                       
            }                                                                            
            else {                                                                          
               break;                                                           // Exit loop when user input is correct.
            }                                                                                  
         }                                                                               
         catch(Exception excpt) {
        	System.out.println(excpt.getMessage());
            System.out.println("\n--Input incorrect. Please Try again.--\n");   // Incorrect input was entered.
         }    
      } while (true);

      // Calculate and output wall area
      wallArea = wallHeight * wallWidth;
      System.out.println("Wall area:  " + wallArea + " square feet");

      // Calculate and output the amount of paint (in gallons) needed to paint the wall
      gallonsPaintNeeded = wallArea/squareFeetPerGallons;
      System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
      
      // Calculate and output the number of paint cans needed to paint the wall,
      // rounded up to nearest integer
      // Complete this code block
      cansNeeded = Math.ceil(gallonsPaintNeeded * gallonsPerCan);
      System.out.println("Cans needed: " + cansNeeded + " can(s)");
   }
}