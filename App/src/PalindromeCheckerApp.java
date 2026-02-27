public class PalindromeCheckerApp {

    // Method 1: Reverse String using StringBuilder
    public static boolean isPalindromeUsingReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    // Method 2: Two-pointer technique
    public static boolean isPalindromeUsingTwoPointer(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 3: Recursive approach
    public static boolean isPalindromeUsingRecursion(String input) {
        return checkRecursive(input, 0, input.length() - 1);
    }

    private static boolean checkRecursive(String input, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }
        return checkRecursive(input, left + 1, right - 1);
    }

    public static void main(String[] args) {

        // Test string (large input for performance comparison)
        String testString = "racecar";

        // Increase size for better performance comparison
        for (int i = 0; i < 10000; i++) {
            testString += "racecar";
        }

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===\n");

        // Algorithm 1 Timing
        long start1 = System.nanoTime();
        boolean result1 = isPalindromeUsingReverse(testString);
        long end1 = System.nanoTime();
        long duration1 = end1 - start1;

        // Algorithm 2 Timing
        long start2 = System.nanoTime();
        boolean result2 = isPalindromeUsingTwoPointer(testString);
        long end2 = System.nanoTime();
        long duration2 = end2 - start2;

        // Algorithm 3 Timing
        long start3 = System.nanoTime();
        boolean result3 = isPalindromeUsingRecursion(testString);
        long end3 = System.nanoTime();
        long duration3 = end3 - start3;

        // Display Results
        System.out.println("Reverse Method Result: " + result1);
        System.out.println("Execution Time (ns): " + duration1 + "\n");

        System.out.println("Two-Pointer Method Result: " + result2);
        System.out.println("Execution Time (ns): " + duration2 + "\n");

        System.out.println("Recursive Method Result: " + result3);
        System.out.println("Execution Time (ns): " + duration3 + "\n");

        // Compare fastest algorithm
        long fastest = Math.min(duration1, Math.min(duration2, duration3));

        System.out.println("=== Fastest Algorithm ===");
        if (fastest == duration1) {
            System.out.println("Reverse Method is fastest.");
        } else if (fastest == duration2) {
            System.out.println("Two-Pointer Method is fastest.");
        } else {
            System.out.println("Recursive Method is fastest.");
        }
    }
}