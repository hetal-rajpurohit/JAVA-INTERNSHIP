import java.util.Scanner;

public class Temperature{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char again;
        System.out.println("WELCOME TO TEMPERATURE CONVERTER");

        do {
            System.out.print("Enter temperature: ");
            double temp = sc.nextDouble();

            System.out.print("Enter unit (C/F): ");
            char unit = sc.next().charAt(0);

            double converted;

            if (unit == 'C' || unit == 'c') {
                converted = (temp * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + converted + " °F");
            }
            else if (unit == 'F' || unit == 'f') {
                converted = (temp - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + converted + " °C");
            }
            else {
                System.out.println("Invalid unit entered.");
                
            }

            System.out.print("\nDo you want to convert another temperature? (Y/N): ");
            again = sc.next().charAt(0);

        } while (again == 'Y' || again == 'y');

        System.out.println("Thank you!");

        sc.close();
    }
}
