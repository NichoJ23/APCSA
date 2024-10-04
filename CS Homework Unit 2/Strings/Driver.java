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
        
        System.out.println("**formatPhoneNumber()**\nEnter a word: ");
        String phoneNumberInput = input.nextLine();
        String phoneNumber = StringTools.formatPhoneNumber(phoneNumberInput);
        System.out.println("The formatted phone number is " + phoneNumber);
        
        System.out.println("\n**middleThree()**\nEnter a word: ");
        String middleThreeInput = input.nextLine();
        String middleThree = StringTools.middleThree(middleThreeInput);
        System.out.println("The middle three letters in " + middleThreeInput + " are " + middleThree);
        
        System.out.println("\n**swapLastTwo()**\nEnter a word: ");
        String swapLastTwoInput = input.nextLine();
        String lastTwo = StringTools.swapLastTwo(swapLastTwoInput);
        System.out.println("The new word is " + lastTwo);
        
        System.out.println("\n**frontAgain()**\nEnter a word: ");
        String frontAgainInput = input.nextLine();
        System.out.println("Enter a number of characters: ");
        int chars = input.nextInt();
        boolean frontAgain = StringTools.frontAgain(frontAgainInput, chars);
        if (frontAgain) {
            System.out.println("The first " + chars + " characters are repeated at the end of the word");
        } else {
            System.out.println("The first " + chars + " characters are not repeated at the end of the word");
        }
    }
}
