/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * Cylinder Class
 */
public class Cylinder {
    double height;
    Circle base;
    
    Cylinder() {
        height = 1;
        base = new Circle();
    }
    
    Cylinder(double r, double h) {
        height = h;
        base = new Circle(r);
    }
    
    public String toString() {
        return "Hello, I am a cylinder with a radius of " + base.getRadius() + " and height of " + height;
    }
    
    public double getRadius() {
        return base.getRadius();
    }
    
    public double getHeight() {
        return height;
    }
    
    public double surfaceArea() {
        return 2*base.area() + height*base.circumference();
    }
    
    public double volume() {
        return base.area() * height;
    }
}
