import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check if a string is palindrome using Deque
    public static boolean isPalindrome(String input) {

        // Create a Deque
        Deque<Character> deque = new LinkedList<>();

        // Convert string to lowercase and remove spaces
        input = input.toLowerCase().replaceAll("\\s+", "");

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear characters
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Deque Based Palindrome Checker ===");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("Result: \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}