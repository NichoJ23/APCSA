/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class SierpenskiTriangle {
    public static void main(String[] args) {
        StdDraw.setScale(0, 1);
        
        OrderedPair topLeft = new OrderedPair(0, 1);
        OrderedPair topRight = new OrderedPair(1, 1);
        OrderedPair bottom = new OrderedPair(0.5, 0);
        
        OrderedPair startPos = new OrderedPair(0.5, 0.5);
        filledTriangle(startPos, 1, "down");
        
        StdDraw.setPenColor(StdDraw.WHITE);
        sierpinski(new OrderedPair(startPos.x, startPos.y + Math.sin(Math.PI/3)*1/4), 0.5, 7);
    }
    
    static void filledTriangle(OrderedPair pos, double sideLength, String orientation) {
        double height = Math.sin(Math.PI/3)*sideLength/2;
        System.out.println(pos.y + height);
        double[] x = {pos.x - sideLength/2, pos.x + sideLength/2, pos.x};
        double[] y;
        if (orientation.equals("up")) {
            y = new double[] {pos.y - height, pos.y - height, pos.y + height};
        } else {
            y = new double[] {pos.y + height, pos.y + height, pos.y - height};
        }
        
        StdDraw.filledPolygon(x, y);
    }
    
    static void sierpinski(OrderedPair pos, double sideLength, int order) {
        if (order < 1) {
            return;
        }
        
        filledTriangle(pos, sideLength, "up");
        double changeX = sideLength/2;
        double changeY = Math.sin(Math.PI/3)*sideLength/4;
        
        OrderedPair pos1 = new OrderedPair(pos.x + changeX, pos.y + changeY);
        OrderedPair pos2 = new OrderedPair(pos.x - changeX, pos.y + changeY);
        OrderedPair pos3 = new OrderedPair(pos.x, pos.y - 3*changeY);
        //OrderedPair pos1 = new OrderedPair(pos.x + changeX, pos.y + changeY);
        sierpinski(pos1, sideLength/2, order - 1);
        sierpinski(pos2, sideLength/2, order - 1);
        sierpinski(pos3, sideLength/2, order - 1);
    }
}
