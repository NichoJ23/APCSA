/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class Formulas {   
    static OrderedPair findQuadraticRoots(double a, double b, double c) {
        double root1 = (-b - (double)Math.sqrt(b*b - 4*a*c)) / (2*a);
        double root2 = (-b + (double)Math.sqrt(b*b - 4*a*c)) / (2*a);
        
        return new OrderedPair(root1, root2);
    }
    
    static double findSlope(OrderedPair a, OrderedPair b) {
        return (b.getY() - a.getY()) / (b.getX() - a.getX());
    }
    
    static OrderedPair findMidpoint(OrderedPair a, OrderedPair b) {
        return new OrderedPair((a.getX() + b.getX())/2, (a.getY() + b.getY())/2);
    }
    
    static double findArithmeticSeriesSum(double a, double d, int k) {
        return 0.5*k*(2*a + d*(k - 1));
    }
    
    static double findGeometricSeriesSum(double a, double r, int k) {
        return a*(1-(double)Math.pow(r, k))/(1-r);
    }
    
    static int rollDie(int sides) {
        return (int)(Math.random() * sides);
    }
}
