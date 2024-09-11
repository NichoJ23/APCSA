/**
 * AP Computer Science
 *
 * BY 
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculations
{
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Give a temperature in Celcius ");
        Double temp = input.nextDouble();
        
        System.out.println("Give a weight in kg");
        Double weight = input.nextDouble();
        
        System.out.println("Give a height in metres ");
        Double height = input.nextDouble();
        
        System.out.println("Give a number of days ");
        int days = input.nextInt();
        
        System.out.println("Give the price of an object ");
        Double price = input.nextDouble();
        
        System.out.println("Give the amount of the object you are purchasing ");
        int amount = input.nextInt();
        
        System.out.println("Give the tax rate (%) ");
        Double tax = input.nextDouble();
        
        System.out.println("Give a positive, three-digit number ");
        int num = input.nextInt();
        
        
        Double newTemp = temp * 9/5.0 + 32.0;
        Double bmi = weight/height/height; // weight / height^2
        int weeks = days / 7;
        int daysLeft = days % 7;
        Double cost = price * amount * (tax / 100.0 + 1);
        int digitSum = num / 100 + num % 100 / 10 + num % 10;
        
        System.out.println("The temperature in Fahrenheit is " + newTemp);
        System.out.format("The BMI is %.2f\n", bmi);
        System.out.println("There are " + weeks + " weeks and " + daysLeft + " days in that amount of time");
        System.out.format("The total cost is %.2f\n", cost);
        System.out.println("The sum of the digits is " + digitSum);
    }
}
