/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class Patterns {
    public static void main(String pattern) {
        pattern = pattern.toLowerCase();
        switch (pattern) {
            case "grid":
                drawGrid();
                break;
            case "bendylines":
                drawBendyLines();
                break;
            case "target":
                drawTarget();
                break;
        }
    }
    
    static void drawGrid() {
        StdDraw.setScale(0, 500);
        
        for (int x = 0; x < 500; x += 25) {
            StdDraw.line(x, 0, x, 500);
        }
        
        for (int y = 0; y < 500; y += 25) {
            StdDraw.line(0, y, 500, y);
        }
    }
    
    static void drawBendyLines() {
        StdDraw.setScale(0, 500);
        
        for (int i = 0; i < 500; i += 25) {
            StdDraw.line(0, i, i, 500);
            StdDraw.line(500, i, i, 0);
        }
    }
    
    static void drawTarget() {
        StdDraw.setScale(0, 500);
        
        for (int r = 350; r > 0; r -= 50) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledCircle(250, 250, r);
            
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(250, 250, r-25);
        }
    }
    
}
