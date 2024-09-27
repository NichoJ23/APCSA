/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class StringTools {
    static String lastLetter(String str) {
        return "" + str.charAt(str.length()-1);
    }
    
    static String formatPhoneNumber(String str) {
        String newText = "(";
        newText += str.substring(0, 3);
        newText += ") ";
        newText += str.substring(3, 6);
        newText += "-";
        newText += str.substring(6);
        
        return newText;
    }
    
    static String middleThree(String str) {
        int startIndex = str.length()/2 - 1;
        int endIndex = str.length()/2 + 2;
        
        return str.substring(startIndex, endIndex);
    }
    
    static String swapLastTwo(String str) {
        String newText = str.substring(0, str.length()-2);
        newText += str.charAt(str.length()-1);
        newText += str.charAt(str.length()-2);
        
        return newText;
    }
    
    static boolean frontAgain(String str, int n) {
        String front = str.substring(0, n);
        String back = str.substring(str.length() - n);
        
        return front.equals(back);
    }
}
