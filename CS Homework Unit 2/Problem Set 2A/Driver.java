/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class Driver {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5);
        
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder(5, 3);
        
        
        System.out.println("Creating a circle with the default constructor!");
        System.out.println(circle1);
        System.out.println("getRadius() --> " + round(circle1.getRadius(), 2) + " units");
        System.out.println("circumference() --> " + round(circle1.circumference(), 2) + " units");
        System.out.println("area() --> " + round(circle1.area(), 2) + " units^2");
        
        System.out.println("\nCreating a circle with parameters!");
        System.out.println(circle2);
        System.out.println("getRadius() --> " + round(circle2.getRadius(), 2) + " units");
        System.out.println("circumference() --> " + round(circle2.circumference(), 2) + " units");
        System.out.println("area() --> " + round(circle2.area(), 2) + " units^2");
        
        System.out.println("\nCreating a cylinder with the default constructor!");
        System.out.println(cylinder1);
        System.out.println("getRadius() --> " + round(cylinder1.getRadius(), 2) + " units");
        System.out.println("getHeight() --> " + round(cylinder1.getHeight(), 2) + " units");
        System.out.println("surfaceArea() --> " + round(cylinder1.surfaceArea(), 2) + " units^2");
        System.out.println("volume() --> " + round(cylinder1.volume(), 2) + " units^3");
        
        System.out.println("\nCreating a cylinder with parameters!");
        System.out.println(cylinder2);
        System.out.println("getRadius() --> " + round(cylinder2.getRadius(), 2) + " units");
        System.out.println("getHeight() --> " + round(cylinder2.getHeight(), 2) + " units");
        System.out.println("surfaceArea() --> " + round(cylinder2.surfaceArea(), 2) + " units^2");
        System.out.println("volume() --> " + round(cylinder2.volume(), 2) + " units^3");

    }
    
    static double round(double value, int digits) {
        double scalar = Math.pow(10, digits);
        return Math.round(value * scalar) / scalar;
    }
}
