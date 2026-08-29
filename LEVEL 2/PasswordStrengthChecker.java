import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        `
        System.out.println("================================");
        System.out.println("     PASSWORD STRENGTH CHECKER");
        System.out.println("================================");

        while (true) {

            System.out.print("\nEnter your password: ");
            String password = sc.nextLine();

            // Input validation
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty!");
                continue;
            }

            // Variables to check password criteria
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasNumber = false;
            boolean hasSpecial = false;

            // Check every character
            for (int i = 0; i < password.length(); i++) {

                char ch = password.charAt(i);

                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                }
                else if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                }
                else if (Character.isDigit(ch)) {
                    hasNumber = true;
                }
                else {
                    hasSpecial = true;
                }
            }

            // Count the criteria
            int score = 0;

            if (password.length() >= 8) {
                score++;
            }

            if (hasUppercase) {
                score++;
            }

            if (hasLowercase) {
                score++;
            }

            if (hasNumber) {
                score++;
            }

            if (hasSpecial) {
                score++;
            }

            // Display results
            System.out.println("\n---------- RESULT ----------");

            System.out.println("Length (8+): "
                    + (password.length() >= 8 ? "Yes" : "No"));

            System.out.println("Uppercase: "
                    + (hasUppercase ? "Yes" : "No"));

            System.out.println("Lowercase: "
                    + (hasLowercase ? "Yes" : "No"));

            System.out.println("Number: "
                    + (hasNumber ? "Yes" : "No"));

            System.out.println("Special Character: "
                    + (hasSpecial ? "Yes" : "No"));

            System.out.println("Score: " + score + "/5");

            // Password strength
            if (score == 5) {
                System.out.println("Password Strength: STRONG");
            }
            else if (score >= 3) {
                System.out.println("Password Strength: MEDIUM");
            }
            else {
                System.out.println("Password Strength: WEAK");
            }

            // Feedback
            System.out.println("\nFeedback:");

            if (password.length() < 8) {
                System.out.println("- Use at least 8 characters.");
            }

            if (!hasUppercase) {
                System.out.println("- Add at least one uppercase letter.");
            }

            if (!hasLowercase) {
                System.out.println("- Add at least one lowercase letter.");
            }

            if (!hasNumber) {
                System.out.println("- Add at least one number.");
            }

            if (!hasSpecial) {
                System.out.println("- Add at least one special character.");
            }

            if (score == 5) {
                System.out.println("- Great! Your password meets all criteria.");
            }

            // Ask whether the user wants to check another password
            while (true) {

                System.out.print("\nDo you want to check another password? (Y/N): ");
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("Y")) {
                    break;
                }
                else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("\nThank you for using Password Strength Checker!");
                    sc.close();
                    return;
                }
                else {
                    System.out.println("Invalid input! Please enter only Y or N.");
                }
            }
        }
    }
}