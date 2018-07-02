/*
* File: Timer.java
* Author: Emily Martens
* Date: April 3, 2018
* Purpose: This program creates a Timer object to keep track of start time, end time, and duration of the program
*/

import java.util.*;

public class Timer {
  //create variables to store the start time (second)
  private Calendar startTime; // create an instance of today
  private long start; // get the current second
  private String totalTime;

  //constructor
  public Timer(){
    this.start = System.currentTimeMillis();
  }

  //getter methods
  public Calendar getStartTime(){
    return this.startTime;
  }

  public long getStart(){
    return this.start;
  }

  //method
  public String getTotalTime(){
    //create a new calendar instance and store the end time to calculate the total program run time
    Calendar endTime = Calendar.getInstance(); // create an instance of today's date
    long end = System.currentTimeMillis(); // get the current second
    long totalSeconds = (end - start)/1000;
    String totalTime = "Elapsed time in seconds: " + Long.toString(totalSeconds);
    return totalTime;
  }


}//end class
