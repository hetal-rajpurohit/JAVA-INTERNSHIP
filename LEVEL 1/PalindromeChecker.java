import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== PALINDROME CHECKER =====");

        while (true) {

            String input;
            String cleaned;

            // Input validation
            while (true) {

                System.out.print("Enter a word or phrase: ");
                input = sc.nextLine();

                // Remove spaces and punctuation
                cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                if (cleaned.isEmpty()) {
                    System.out.println("Invalid input! Please enter a word or phrase.");
                    continue;
                }

                break;
            }

            // Check palindrome
            boolean isPalindrome = true;

            for (int i = 0; i < cleaned.length() / 2; i++) {

                if (cleaned.charAt(i) != cleaned.charAt(cleaned.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            // Displays the result
            if (isPalindrome) {
                System.out.println("It is a palindrome!");
            } else {
                System.out.println("It is not a palindrome.");
            }

            // Ask to try again
            while (true) {

                System.out.print("Do you want to try another palindrome? (Y/N): ");
                char choice = sc.nextLine().charAt(0);

                if (choice == 'Y' || choice == 'y') {
                    break;
                }

                else if (choice == 'N' || choice == 'n') {
                    System.out.println("Thank you for using Palindrome Checker!");
                    sc.close();
                    return;
                }

                else {
                    System.out.println("Invalid input! Please enter Y or N.");
                }
            }
        }
    }
}