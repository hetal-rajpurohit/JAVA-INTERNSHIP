import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            
            String lowercase = "abcdefghijklmnopqrstuvwxyz";
            String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numbers = "0123456789";
            String special = "!@#$%^&*";
            
            char again = 0;
            
            System.out.println("===== RANDOM PASSWORD GENERATOR =====");
            
            do {
                
                int length;
                
                // Password length validation
                while (true) {
                    System.out.print("\nEnter password length (4-50): ");
                    
                    if (sc.hasNextInt()) {
                        length = sc.nextInt();
                        
                        if (length >= 4 && length <= 50) {
                            break;
                        } else {
                            System.out.println(
                                    "Please enter a length between 4 and 50."
                            );
                        }
                        
                    } else {
                        System.out.println("Invalid input! Enter a number.");
                        sc.next();
                    }
                }
                
                // Character choices
                char numberChoice;
                char lowercaseChoice;
                char uppercaseChoice;
                char specialChoice;
                
                // Numbers
                while (true) {
                    System.out.print("Include numbers? (Y/N): ");
                    String input = sc.next().toLowerCase();
                    
                    if (input.equals("y") || input.equals("n")) {
                        numberChoice = input.charAt(0);
                        break;
                    } else {
                        System.out.println("Please enter only Y or N.");
                    }
                }
                
                // Lowercase
                while (true) {
                    System.out.print("Include lowercase letters? (Y/N): ");
                    String input = sc.next().toLowerCase();
                    
                    if (input.equals("y") || input.equals("n")) {
                        lowercaseChoice = input.charAt(0);
                        break;
                    } else {
                        System.out.println("Please enter only Y or N.");
                    }
                }
                
                // Uppercase
                while (true) {
                    System.out.print("Include uppercase letters? (Y/N): ");
                    String input = sc.next().toLowerCase();
                    
                    if (input.equals("y") || input.equals("n")) {
                        uppercaseChoice = input.charAt(0);
                        break;
                    } else {
                        System.out.println("Please enter only Y or N.");
                    }
                }
                
                // Special characters
                while (true) {
                    System.out.print("Include special characters? (Y/N): ");
                    String input = sc.next().toLowerCase();
                    
                    if (input.equals("y") || input.equals("n")) {
                        specialChoice = input.charAt(0);
                        break;
                    } else {
                        System.out.println("Please enter only Y or N.");
                    }
                }
                
                // Creating character pool
                String characters = "";
                
                if (numberChoice == 'y') {
                    characters += numbers;
                }
                
                if (lowercaseChoice == 'y') {
                    characters += lowercase;
                }
                
                if (uppercaseChoice == 'y') {
                    characters += uppercase;
                }
                
                if (specialChoice == 'y') {
                    characters += special;
                }
                
                // Check if at least one type is selected
                if (characters.length() == 0) {
                    System.out.println(
                            "\nYou must select at least one character type."
                    );
                    continue;
                }
                
                // Generate password
                String password = "";
                
                for (int i = 0; i < length; i++) {
                    
                    int index = random.nextInt(characters.length());
                    
                    password += characters.charAt(index);
                }
                
                // Display password
                System.out.println("\n===== GENERATED PASSWORD =====");
                System.out.println(password);
                System.out.println("Password length: " + password.length());
                
                // Ask to generate again
                while (true) {
                    System.out.print(
                            "\nDo you want to generate another password? (Y/N): "
                    );
                    
                    String input = sc.next().toLowerCase();
                    
                    if (input.equals("y") || input.equals("n")) {
                        again = input.charAt(0);
                        break;
                    } else {
                        System.out.println("Please enter only Y or N.");
                    }
                }
                
            } while (again == 'y');
            
            System.out.println("\nThank you for using the Password Generator!");
        }
    }
}
