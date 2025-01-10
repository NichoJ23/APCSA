/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class Fraction {
    private int numerator;
    private int denominator;
    
    Fraction() {
        setNum((int) (Math.random() * 21));
        setDenom((int) (Math.random() * 20) + 1);
        
        reduce();
    }
    
    Fraction(int _numerator, int _denominator) {
        setNum(_numerator);
        setDenom(_denominator);
        
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannt be 0");
        }
        
        reduce();
    }
    
    Fraction(String fraction) {
        String[] values = fraction.split("/");
        setNum(Integer.valueOf(values[0]));
        setDenom(Integer.valueOf(values[1]));
        
        reduce();
    }
    
    Fraction(Fraction f) {
        setNum(f.numerator);
        setDenom(f.denominator);
    }
    
    public Fraction copy() {
        return new Fraction(numerator, denominator);
    }
    
    public int getNum() {
        return numerator;
    }
    
    public void setNum(int n) {
        numerator = n;
    }
    
    public int getDenom() {
        return denominator;
    }
    
    public void setDenom(int n) {
        denominator = n;
        
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be 0");
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public double toDouble() {
        return (double) numerator / denominator;
    }
    
    public void reduce() {
        if (numerator == denominator) {
            numerator = denominator = 1;
            return;
        }
        
        if (numerator == 0) {
            setDenom(1);
            return;
        }
        
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        
        int gcf = gcf(Math.abs(numerator), Math.abs(denominator));
        if (gcf != 1) {
            numerator /= gcf;
            denominator /= gcf;
        }
    }
    
    private int gcf(int x, int y) {
        // Euclid's method for greatest commen factor
        while (x != y) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        }
        
        return x;
    }
    
    public boolean equals(Fraction other) {
        return getNum() == other.getNum() && getDenom() == other.getDenom();
    }
    
    static boolean equals(Fraction f1, Fraction f2) {
        return f1.equals(f2);
    }
    
    static Fraction multiply(Fraction f1, Fraction f2) {
        Fraction product = new Fraction(f1.getNum() * f2.getNum(), f1.getDenom() * f2.getDenom());
        
        product.reduce();
        return product;
    }
    
    static Fraction divide(Fraction f1, Fraction f2) {
        Fraction product = new Fraction(f1.getNum() * f2.getDenom(), f1.getDenom() * f2.getNum());
        
        product.reduce();
        return product;
    }
    
    static Fraction add(Fraction f1, Fraction f2) {
        f1 = f1.copy();
        f2 = f2.copy();
        
        if (f1.denominator != f2.denominator) {
            int oldf1Denom = f1.denominator;
            
            f1.setNum(f1.getNum() * f2.getDenom());
            f1.setDenom(f1.getDenom() * f2.getDenom());
            
            f2.setNum(f2.getNum() * oldf1Denom);
            f2.setDenom(f2.getDenom() * oldf1Denom);
        }
        
        Fraction result = new Fraction(f1.getNum() + f2.getNum(), f1.getDenom());
        result.reduce();
        
        return result;
    }
    
    static Fraction subtract(Fraction f1, Fraction f2) {
        f1 = f1.copy();
        f2 = f2.copy();
        
        if (f1.denominator != f2.denominator) {
            int oldf1Denom = f1.denominator;
            
            f1.setNum(f1.getNum() * f2.getDenom());
            f1.setDenom(f1.getDenom() * f2.getDenom());
            
            f2.setNum(f2.getNum() * oldf1Denom);
            f2.setDenom(f2.getDenom() * oldf1Denom);
        }
        
        Fraction result = new Fraction(f1.getNum() - f2.getNum(), f1.getDenom());
        result.reduce();
        
        return result;
    }
}
