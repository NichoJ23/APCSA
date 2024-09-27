/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Quadratic formula: finds the roots of ax^2 + bx + c. Enter a, b and c.");
        System.out.print("a: ");
        double a = input.nextDouble();
        System.out.print("b: ");
        double b = input.nextDouble();
        System.out.print("c: ");
        double c = input.nextDouble();
        OrderedPair roots = Formulas.findQuadraticRoots(a, b, c);
        System.out.println(String.format("The roots of the equation %sx^2 + %sx + %s are %s and %s", a, b, c, roots.getX(), roots.getY()));
        System.out.println();
        
        System.out.println("Slope formula: finds the slope between the points (x1, y1) and (x2, y2)");
        System.out.print("x1: ");
        double x1 = input.nextDouble();
        System.out.print("x2: ");
        double y1 = input.nextDouble();
        System.out.print("x3: ");
        double x2 = input.nextDouble();
        System.out.print("x4: ");
        double y2 = input.nextDouble();
        double slope = Formulas.findSlope(new OrderedPair(x1, y1), new OrderedPair(x2, y2));
        System.out.println(String.format("A line from (%s, %s) to (%s, %s) has a slope of %s", x1, y1, x2, y2, slope));
        System.out.println();
        
        System.out.println("Midpoint formula: find the midpoint between (x1, y1) and (x2, y2)");
        System.out.print("x1: ");
         x1 = input.nextDouble();
        System.out.print("x2: ");
         y1 = input.nextDouble();
        System.out.print("x3: ");
         x2 = input.nextDouble();
        System.out.print("x4: ");
         y2 = input.nextDouble();
        OrderedPair midPoint = Formulas.findMidpoint(new OrderedPair(x1, y1), new OrderedPair(x2, y2));
        System.out.println(String.format("The midpoint between (%s, %s) and (%s, %s) is %s", x1, y1, x2, y2, midPoint));
        System.out.println();
        
        System.out.println("Sum of an arithmetic series");
        System.out.print("Number of terms: ");
        int terms = input.nextInt();
        System.out.print("Starts at: ");
        double start = input.nextDouble();
        System.out.print("Increases by: ");
        double diff = input.nextDouble();
        double arithSum = Formulas.findArithmeticSeriesSum(start, diff, terms);
        System.out.println(String.format("The sum of the first %s terms in an arithmetic series that starts at %s and increases by %s is %s", terms, start, diff, arithSum));
        System.out.println();
        
        System.out.println("Sum of a geometric series");
        System.out.print("Number of terms: ");
        terms = input.nextInt();
        System.out.print("Starts with: ");
        start = input.nextDouble();
        System.out.print("Rate of growth: ");
        double rate = input.nextDouble();
        double geoSum = Formulas.findGeometricSeriesSum(start, rate, terms);
        System.out.println(String.format("The sum of the first %s terms of a finite geometric series that starts with %s and increases by a rate of %s is %s", terms, start, rate, geoSum));
        System.out.println();
        
        System.out.println("Die roller");
        System.out.print("How many dies does your die have? ");
        int sides = input.nextInt();
        int roll = Formulas.rollDie(sides);
        System.out.println(String.format("Rolling a %s-sided die... you got %s!", sides, roll));
    }
}
