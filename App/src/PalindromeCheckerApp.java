import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a word to check palindrome: ");
        String input = scanner.nextLine();

        // Convert input to lowercase for case-insensitive comparison
        String processedInput = input.toLowerCase();

        // Push characters into stack
        for (int i = 0; i < processedInput.length(); i++) {
            stack.push(processedInput.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop characters and compare
        for (int i = 0; i < processedInput.length(); i++) {
            char poppedChar = stack.pop();
            if (processedInput.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        scanner.close();
    }
}