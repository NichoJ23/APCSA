/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * Problem Set 2C Sep. 26th 2024
 */
public class OrderedPair {
    double x;
    double y;
    
    OrderedPair() {
        x = y = 0;
    }
    
    OrderedPair(double _x, double _y) {
        x = _x;
        y = _y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
