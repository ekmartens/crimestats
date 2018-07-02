/*
* File: USCrime.java
* Author: Emily Martens
* Date: April 3, 2018
* Purpose: This program creates a USCrime object to store all of the information in the crime.csv file
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class USCrime {

  private String file;
  public ArrayList<String> fileContents;
  public String[] categories;
  public int[] population;
  public int[] year;
  public float[] murderRate;
  public float[] robberyRate;
  public int[] violentCrimes;
  public int[] propertyCrimes;
  public String[][] theData;

  //Constructor
  public USCrime(String filename){
    this.file = filename;
    storeFile();
    getCategories();
    getPopulation();
    getYear();
    getMurderRate();
    getRobberyRate();
    getViolentCrimes();
    getPropertyCrimes();
  }


  //getter method
  public String getFileName(){
    return this.file;
  }

  //method to read the file and store the info in a multidimensional array
  public void storeFile() {
    //initialize BufferedReader
    BufferedReader inBuffer = null;
    this.fileContents = new ArrayList <String>();

    String l; //lines of file
    try {
      //open file, ready to read
      inBuffer = new BufferedReader(new FileReader(this.file));

        //read contents of cities file line by line
        while ((l = inBuffer.readLine() ) != null) {
          this.fileContents.add(l);
        } // end while
      }  catch (IOException io) {
           //for any input/output issues, print message
           System.out.println("File IO exception " + io.getMessage());
        } finally { //clean up regardless of above try block
            try {
                // Close inBuffer
                if (inBuffer != null) {
                inBuffer.close();
                }
             } catch (IOException io) {
                System.out.println("Problem closing file: " + io.getMessage());
               }
      }

      int fileSize = this.fileContents.size();
      String[] tempArray = new String[fileSize];
      this.fileContents.toArray(tempArray);
      this.theData = new String[fileSize][tempArray.length];

      for (int j = 0; j < tempArray.length; j++){
        this.theData[j] = tempArray[j].split(",");
      }
  }

  //method to store the crime categories
  public void getCategories(){
    this.categories = new String[this.theData[0].length];
    for (int i = 0; i < this.theData[0].length; i++){
      this.categories[i] = this.theData[0][i];
    }
  }

  //method to store the population
  public void getPopulation() {
    //calculate the index of the Population category
    String findCategory = "Population";
    int popIndex = 0;
    for (int i = 0; i < this.categories.length; i++){
      if (this.categories[i].equals(findCategory)){
        popIndex = i;
      }
    }

    //get all population values from their indexes in the multidimensional data array, parse to int and save in population
    this.population = new int[this.theData.length - 1];
    for (int j = 0; j < this.theData.length - 1; j++){
      this.population[j] = Integer.parseInt(this.theData[j+1][popIndex]);
    }
  }

  //method to store the years
  public void getYear(){
    //calculate the index of the Population category
    String findCategory = "Year";
    int yearIndex = 0;
    for (int i = 0; i < this.categories.length; i++){
      if (this.categories[i].equals(findCategory)){
        yearIndex = i;
      }
    }

    //get all year values from their indexes in the multidimensional data array, parse to int and save in year
    this.year = new int[this.theData.length - 1];
    for (int j = 0; j < this.theData.length - 1; j++){
      this.year[j] = Integer.parseInt(this.theData[j+1][yearIndex]);
    }
  }

  //method to store the murder rates
  public void getMurderRate() {
    //calculate the index of the Population category
    String findCategory = "Murder and nonnegligent manslaughter rate";
    int murderIndex = 0;
    for (int i = 0; i < this.categories.length; i++){
      if (this.categories[i].equals(findCategory)){
        murderIndex = i;
      }
    }

    //get all murder rate values from their indexes in the multidimensional data array, parse to int and save in population
    this.murderRate = new float[this.theData.length - 1];
    for (int j = 0; j < this.theData.length - 1; j++){
      this.murderRate[j] = Float.parseFloat(this.theData[j+1][murderIndex]);
    }
  }

  //method to store the robbery rates
  public void getRobberyRate() {
    //calculate the index of the Population category
    String findCategory = "Robbery rate";
    int robberyIndex = 0;
    for (int i = 0; i < this.categories.length; i++){
      if (this.categories[i].equals(findCategory)){
        robberyIndex = i;
      }
    }

    //get all robbery rate values from their indexes in the multidimensional data array, parse to int and save in population
    this.robberyRate = new float[this.theData.length - 1];
    for (int j = 0; j < this.theData.length - 1; j++){
      this.robberyRate[j] = Float.parseFloat(this.theData[j+1][robberyIndex]);
    }
  }

  //method to store the violent crimes
  public void getViolentCrimes(){
    //calculate the index of the Violent Crime category
    String findCategory = "Violent crime";
    int violenceIndex = 0;
    for (int i = 0; i < this.categories.length; i++){
      if (this.categories[i].equals(findCategory)){
        violenceIndex = i;
      }
    }

    //get all violent crime values from their indexes in the multidimensional data array, parse to int and save in year
    this.violentCrimes = new int[this.theData.length - 1];
    for (int j = 0; j < this.theData.length - 1; j++){
      this.violentCrimes[j] = Integer.parseInt(this.theData[j+1][violenceIndex]);
    }
  }

  //method to store the property crimes
  public void getPropertyCrimes(){
    //calculate the index of the Violent Crime category
    String findCategory = "Property crime";
    int propertyIndex = 0;
    for (int i = 0; i < this.categories.length; i++){
      if (this.categories[i].equals(findCategory)){
        propertyIndex = i;
      }
    }

    //get all property crime values from their indexes in the multidimensional data array, parse to int and save in year
    this.propertyCrimes = new int[this.theData.length - 1];
    for (int j = 0; j < this.theData.length - 1; j++){
      this.propertyCrimes[j] = Integer.parseInt(this.theData[j+1][propertyIndex]);
    }
  }

  //method to calculate population growth
  public void popGrowth(){
    float percentageGrowth;
    for (int i = 0; i < this.population.length - 1; i++){
      percentageGrowth = ((this.population[i+1] - this.population[i])/ (float) this.population[i])*100;
      System.out.println("Growth from " + this.year[i] + " - " + this.year[i+1] + ": " + percentageGrowth + "%");
    }
  }

  //method to calculate the highest murder rate
  public void highestMurderRate(){
    float max = this.murderRate[0];
    int maxYear = this.year[0];
    for(int i = 0; i < this.murderRate.length; i++){
      if (this.murderRate[i] > max){
        max = this.murderRate[i];
        maxYear = this.year[i];
      }
    }
    System.out.println("The Murder rate was highest in " + maxYear);
  }

  //method to calculate the lowest murder rate
  public void lowestMurderRate(){
    float min = this.murderRate[0];
    int minYear = this.year[0];
    for(int i = 0; i < this.murderRate.length; i++){
      if (this.murderRate[i] < min){
        min = this.murderRate[i];
        minYear = this.year[i];
      }
    }
    System.out.println("The Murder rate was lowest in " + minYear);
  }

  //method to calculate the highest robbery rate
  public void highestRobberyRate(){
    float max = this.robberyRate[0];
    int maxYear = this.year[0];
    for(int i = 0; i < this.robberyRate.length; i++){
      if (this.robberyRate[i] > max){
        max = this.robberyRate[i];
        maxYear = this.year[i];
      }
    }
    System.out.println("The Robbery rate was highest in " + maxYear);
  }

  //method to calculate the lowest robbery rate
  public void lowestRobberyRate(){
    float min = this.robberyRate[0];
    int minYear = this.year[0];
    for(int i = 0; i < this.robberyRate.length; i++){
      if (this.robberyRate[i] < min){
        min = this.robberyRate[i];
        minYear = this.year[i];
      }
    }
    System.out.println("The Robbery rate was lowest in " + minYear);
  }

  //method to calculate the average number of violent violentCrimes
  public void averageViolentCrimes(){
    int total = 0;
    int average = 0;
    for (int i = 0; i < this.violentCrimes.length; i++){
      total += this.violentCrimes[i];
    }
    average = total/this.violentCrimes.length;
    System.out.println("The average number of violent crimes from 1994 - 2013 was " + average);
  }

  //method to calculate the total property crimes from 1994 - 2004
  public void totalPropertyCrimes(){
    int total = 0;
    for (int i = 0; i < 10; i++){
      total += this.propertyCrimes[i];
    }
    System.out.println("The total property crimes from 1994 - 2004 were: " + total);
  }
  
}
