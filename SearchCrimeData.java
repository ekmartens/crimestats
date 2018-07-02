/*
* File: SearchCrimeData.java
* Author: Emily Martens
* Date: April 3, 2018
* Purpose: This program allows the user to learn the answers to questions about crime in the US by selecting from a menu. The program then prints a thank you and the time elapsed since the program started.
*/

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SearchCrimeData {
  public static void main(String[] args) throws IOException {

    Timer runTime = new Timer(); // create new Timer object to keep track of total runtime
    Scanner takeInput = new Scanner(System.in);
    char theInput;
    char quit;
    boolean isDone = false;

    //create new crime object on program start
    USCrime crime = new USCrime(args[0]);
    System.out.println("\n********* Welcome to the US Crime Statistics App *********\n");

    while (isDone == false) {
      //Selection Menu
      System.out.println("Select your question. Enter Q to quit the program.");
      System.out.println("1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
      System.out.println("2. What year was the Murder rate the highest?");
      System.out.println("3. What year was the Murder rate the lowest?");
      System.out.println("4. What year was the Robbery rate the highest?");
      System.out.println("5. What year was the Robbery rate the lowest?");
      System.out.println("6. What was the average total of violent crimes from 1994 to 2013?");
      System.out.println("7. What was the total number of property crimes from 1994 - 2004?");
      System.out.println("Q. Quit the program");

      theInput = takeInput.next().charAt(0);

      switch(Character.toUpperCase(theInput)) {
        case '1':
           crime.popGrowth();
           break;
        case '2':
           crime.highestMurderRate();
           break;
        case '3':
           crime.lowestMurderRate();
           break;
        case '4':
           crime.highestRobberyRate();
           break;
        case '5':
           crime.lowestRobberyRate();
           break;
        case '6':
           crime.averageViolentCrimes();
           break;
        case '7':
           crime.totalPropertyCrimes();
           break;
        case 'Q':
           isDone = true;
           break;
       default:
           System.out.println("Please select a valid entry");
           break;
      }//end switch
    }//end while

    System.out.println("\nThank you for trying the US Crime Statistics App");

    System.out.println(runTime.getTotalTime()); // call the Timer function to calculate total runtime

  }//end main
}//end class
