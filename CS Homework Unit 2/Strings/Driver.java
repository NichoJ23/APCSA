/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                
        System.out.println("**lastLetter()**\nEnter a word: ");
        String lastLetterInput = input.nextLine();
        String lastLetter = StringTools.lastLetter(lastLetterInput);
        System.out.println("The last letter in " + lastLetterInput + " is " + lastLetter);
        
        System.out.println("\n**middleThree()**\nEnter a word: ");
        String middleThreeInput = input.nextLine();
        String middleThree = StringTools.middleThree(middleThreeInput);
        System.out.println("The middle three letters in " + middleThreeInput + " are " + middleThree);
    }
}
