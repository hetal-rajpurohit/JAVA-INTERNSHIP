import java.util.Scanner;

public class Grade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char again;

        System.out.println("===== STUDENT GRADE CALCULATOR =====");

        do {

            int numberOfGrades;

            // Validate number of grades
            while (true) {
                System.out.print("\nEnter the number of grades: ");

                if (sc.hasNextInt()) {
                    numberOfGrades = sc.nextInt();

                    if (numberOfGrades > 0) {
                        break;
                    } else {
                        System.out.println("Error: Number of grades must be greater than 0.");
                    }
                } else {
                    System.out.println("Error: Please enter a valid integer.");
                    sc.next();
                }
            }

            double[] grades = new double[numberOfGrades];
            double sum = 0;

            // Input and validate grades
            for (int i = 0; i < numberOfGrades; i++) {

                while (true) {
                    System.out.print("Enter grade " + (i + 1) + " (0-100): ");

                    if (sc.hasNextDouble()) {
                        double grade = sc.nextDouble();

                        if (grade >= 0 && grade <= 100) {
                            grades[i] = grade;
                            sum += grade;
                            break;
                        } else {
                            System.out.println("Error: Grade must be between 0 and 100.");
                        }
                    } else {
                        System.out.println("Error: Please enter a valid number.");
                        sc.next();
                    }
                }
            }

            // Calculate average
            double average = sum / numberOfGrades;

            System.out.println("\n===== RESULT =====");
            System.out.printf("Average Grade: %.2f%n", average);

            // Calculate grade category
            if (average >= 90) {
                System.out.println("Grade: A");
            } else if (average >= 80) {
                System.out.println("Grade: B");
            } else if (average >= 70) {
                System.out.println("Grade: C");
            } else if (average >= 60) {
                System.out.println("Grade: D");
            } else {
                System.out.println("Grade: F");
            }

            // Validate Y/N input
            while (true) {
                System.out.print("\nDo you want to calculate another student's grade? (Y/N): ");

                String choice = sc.next();

                if (choice.equalsIgnoreCase("Y")) {
                    again = 'Y';
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    again = 'N';
                    break;
                } else {
                    System.out.println("Error: Please enter only Y or N.");
                }
            }

        } while (again == 'Y');

        System.out.println("\nThank you for using Student Grade Calculator!");

        sc.close();
    }
}