/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num = (int)(Math.random() * 101);
        
        System.out.println("I'm thinking of a number from 0-100. Take a guess!");
        int guess = -1;
        
        do {
            guess = input.nextInt();
            
            if (guess > num) {
                System.out.println("Nope. Guess lower");
            } else if (guess < num) {
                System.out.println("Nope. Guess higher");
            } 
        } while (guess != num);
        System.out.println("You got it!");
        
    }
}
