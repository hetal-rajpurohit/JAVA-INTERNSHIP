import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

    // Method to encrypt or decrypt text
    public static String processText(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            result.append((char) (ch + key));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== File Encryption/Decryption ===");

            System.out.print("Enter 1 for Encryption or 2 for Decryption: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter the encryption key (number): ");
            int key = scanner.nextInt();

            // Read file content
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

            String result;

            if (choice == 1) {
                // Encryption
                result = processText(content.toString(), key);

                BufferedWriter writer =
                        new BufferedWriter(new FileWriter("encrypted.txt"));

                writer.write(result);
                writer.close();

                System.out.println("File encrypted successfully!");
                System.out.println("Encrypted file saved as encrypted.txt");

            } else if (choice == 2) {
                // Decryption
                result = processText(content.toString(), -key);

                BufferedWriter writer =
                        new BufferedWriter(new FileWriter("decrypted.txt"));

                writer.write(result);
                writer.close();

                System.out.println("File decrypted successfully!");
                System.out.println("Decrypted file saved as decrypted.txt");

            } else {
                System.out.println("Invalid choice!");
            }

        } catch (IOException e) {
            System.out.println("Error: File not found or cannot be read.");
        }

        scanner.close();
    }
}