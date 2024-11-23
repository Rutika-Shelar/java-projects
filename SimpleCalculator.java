import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");

        while (true) {
            try {
                // Prompt the user for the first number
                System.out.print("Enter the first number: ");
                double num1 = getValidDouble(scanner);

                // Prompt the user for the operation
                System.out.print("Enter an operation (+, -, *, /): ");
                char operation = getValidOperation(scanner);

                // Prompt the user for the second number
                System.out.print("Enter the second number: ");
                double num2 = getValidDouble(scanner);

                // Perform the operation
                double result = performCalculation(num1, num2, operation);
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ask the user if they want to perform another calculation
            System.out.print("Would you like to perform another calculation? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    // Method to validate and parse numeric input
    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a numeric value: ");
            }
        }
    }

    // Method to validate and parse the operation input
    private static char getValidOperation(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.print("Invalid operation. Please enter one of (+, -, *, /): ");
        }
    }

    // Method to perform the calculation
    private static double performCalculation(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalStateException("Unexpected operation: " + operation);
        }
    }
}
