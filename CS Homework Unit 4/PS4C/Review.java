import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        //System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * @returns the average sentiment value of a piece of text between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double totalSentiment( String fileName ) {
      String text = textToString(fileName);
      double sentiment = 0;
      int sentimentWords = 0;
      
      while (text.length() > 0) {
          int nextSpace = text.indexOf(" ");
          if (nextSpace > 0) {
              String word = text.substring(0, nextSpace);
              
              double score = sentimentVal(removePunctuation(word));
              
              if (score != 0.0) {
                  sentiment += score;
                  sentimentWords++;
              }
          
              text = text.substring(nextSpace + 1);
              
          } else {
              double score = sentimentVal(removePunctuation(text));
              
              if (score != 0.0) {
                  sentiment += score;
                  sentimentWords++;
              }
              
              break;
          }
      }
      
      return Math.round(sentiment / sentimentWords * 1000) / 1000.0;
  }
  
  /**
   * @returns the expected star rating of a review out of 5 stars
   */
  public static double starRating(String fileName) {
      double sentiment = totalSentiment(fileName);
      double stars = sentiment * 2.5 + 2.5;
      return Math.round(stars * 1000) / 1000.0;
  }
  
  public static String fakeReview(String fileName) {
      String text = textToString(fileName);
      text += " ";
      for (int i = 0; i < text.length()-1; i = text.indexOf(" ", i+1)+1) {
          int nextSpace = text.indexOf(" ", i);
          String word = text.substring(i, nextSpace);
          if (word.charAt(0) == '*') {
              String mainWord = word.substring(1);
              double sentiment = sentimentVal(removePunctuation(mainWord));
              if (sentiment == 0) {
                  sentiment += Math.random() - 0.5;
              }
              if (sentiment > 0) {
                  text = text.substring(0, i) + randomPositiveAdj() + getPunctuation(mainWord) + text.substring(nextSpace);
              } else {
                  text = text.substring(0, i) + randomNegativeAdj() + getPunctuation(mainWord) + text.substring(nextSpace);
              }
          }
          
      }
      
      return text;
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }
  
    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
}