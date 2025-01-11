import java.util.Scanner;

//code had tested from QA team

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Greet");
            System.out.println("2. Display Current Time");
            System.out.println("3. Perform Calculation");
            System.out.println("4. Exit");
            System.out.print("Enter your ch: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1 -> greetUser(scanner);
                case 2 -> displayCurrentTime();
                case 3 -> performCalculation(scanner);
                case 4 -> {
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                }
                default -> System.out.println("Invalid choice! Please select an option from 1 to 4.");
            }
        }

        scanner.close();
    }

    private static void greetUser(Scanner scanner) {
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to the program.");
    }

    private static void displayCurrentTime() {
        System.out.println("\nCurrent time is: " + java.time.LocalTime.now());
    }

    private static void performCalculation(Scanner scanner) {
        System.out.print("\nEnter the first number: ");
        double num1 = getValidDouble(scanner);

        System.out.print("Enter the second number: ");
        double num2 = getValidDouble(scanner);


        System.out.print("Choose an operation (+, -, *, /, //, %): ");

        String operation = scanner.nextLine();

        double result;
        switch (operation) {
            case "+" -> {
                result = num1 + num2;
                System.out.println("Result: " + result);
            }
            case "-" -> {
                result = num1 - num2;
                System.out.println("Result: " + result);
            }
            case "*" -> {
                result = num1 * num2;
                System.out.println("Result: " + result);
            }
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error! Division by zero is undefined.");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
            }

            case "%" -> {
                result = num1 % num2;
            }

            case "//" -> {
                result = (int)(num1 / num2);
                System.out.println("Result: " + result);
            }
            default -> System.out.println("Invalid operation! Please select +, -, *, /, // or %.");
        }
    }

    private static double getValidDouble(Scanner scanner) {
        double num;
        while (true) {
            try {
                num = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Please enter a valid numerical value: ");
            }
        }
        return num;
    }
}
