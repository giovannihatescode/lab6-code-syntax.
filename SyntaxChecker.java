import java.util.Stack;

public class SyntaxChecker {

    // Checks whether parentheses, brackets, and braces are balanced
    public static boolean isBalanced(String line) {

        // Create an empty stack to store opening symbols
        Stack<Character> buffer = new Stack<>();

        // Check each character in the string
        for (int i = 0; i < line.length(); i++) {

            char current = line.charAt(i);

            // Add opening symbols to the stack
            if (current == '(' || current == '{' || current == '[') {
                buffer.push(current);
            }

            // Check closing symbols
            else if (current == ')' || current == '}' || current == ']') {

                // If there is no opening symbol, return false
                if (buffer.isEmpty()) {
                    return false;
                }

                // Get the most recent opening symbol
                char opening = buffer.pop();

                // Make sure the symbols match
                if (current == ')' && opening != '(') {
                    return false;
                }

                if (current == '}' && opening != '{') {
                    return false;
                }

                if (current == ']' && opening != '[') {
                    return false;
                }
            }
        }

        // True means all opening symbols were matched
        return buffer.isEmpty();
    }

    public static void main(String[] args) {

        String line1 = "public static void main(String[] args) { ... }";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println('Hello');)";
        String line4 = "List list = new ArrayList<{String>();";
        String line5 = "if (x > 0) {";

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}