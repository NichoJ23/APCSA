/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * Circle Class
 */
public class Circle {
    private double radius;
    
    Circle() {
        radius = 1;
    }
    
    Circle(double r) {
        radius = r;
    }
    
    public String toString() {
        return "Hello, I am a circle with radius " + radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double circumference() {
        return radius * 2 * Math.PI;
    }
    
    public double area() {
        return radius * radius * Math.PI;
    }
}
