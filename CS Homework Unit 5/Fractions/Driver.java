/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */

import java.util.Scanner;

public class Driver {
    public static void PI() {
        final Fraction MILU = new Fraction("355/113");
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        
        Fraction guess = MILU.copy();
        
        while (Math.abs(Math.PI - guess.toDouble()) >= EPSILON) {
            if (guess.toDouble() > Math.PI) {
                guess.setDenom(guess.getDenom() + 1);
            } else {
                guess.setNum(guess.getNum() + 1);
            }
        }
        
        System.out.println(guess);
    }
    
    public static void FractionGame() {
        Scanner input = new Scanner(System.in);
        
        int wins = 0;
        int losses = 0;
        
        while (true) {
            Fraction f1 = new Fraction();
            Fraction f2 = new Fraction();
            
            System.out.print("What's " + f1 + " + " + f2 + "? ");
            
            Fraction result = Fraction.add(f1, f2);
            
            String answer = input.nextLine();
            if (answer.toLowerCase().equals("quit")) break;
            
            Fraction answerFrac = new Fraction(answer);
            
            if (result.equals(answerFrac)) {
                System.out.println("Correct!");
                wins++;
            } else {
                System.out.println("Haiya you inter! The answer is " + result);
                losses++;
            }
            
            System.out.println();
        }
        
        if (wins + losses > 0) {
            Fraction winrate = new Fraction(wins, wins + losses);
            int winPercent = (int) Math.round((winrate.toDouble() * 100));
            System.out.println("You were only correct " + wins + "/" + (wins+losses) + " times, " + winPercent + "% of the time");
        } else {
            System.out.println("quitter");
        }
    }
}
