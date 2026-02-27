import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check palindrome (ignoring spaces and case)
    public static boolean isPalindrome(String input) {

        // Normalize the string:
        // 1. Remove all spaces using regex
        // 2. Convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Convert string to char array
        char[] charArray = normalized.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        // Check palindrome
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: The given string is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}