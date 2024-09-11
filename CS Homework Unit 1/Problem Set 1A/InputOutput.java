/**
 * AP Computer Science
 *
 * BY 
 */

import java.util.Scanner;

public class InputOutput
{
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("What is your favourite sport? ");
        String sport = input.nextLine();
        
        System.out.print("What is your favourite video game? ");
        String game = input.nextLine();
        
        System.out.print("How many hours do you spend at school every day? ");
        Double schoolTime = input.nextDouble();
        
        System.out.print("How many hours do you spend studying every day? ");
        Double studyTime = input.nextDouble();
        
        System.out.println("Summary:");
        System.out.println("Your favourite sport is " + sport);
        System.out.println("Your favourite video game is " + game);
        System.out.println("You spend " + schoolTime + " hours at school per day");
        System.out.println("You spend " + studyTime + " hours studying per day");
        System.out.println("That's " + (schoolTime + studyTime) + " hours wasted on school when you could've been playing " + game + " or " + sport);
    }
}
