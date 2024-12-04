import java.util.Scanner;

public class WeeklyTaxWithholding {

    public static void main(String[] args) {
        // Step 1: Declare variables to hold weekly incomes and total tax.
        double[] weeklyIncomes = new double[10]; // Array to store weekly incomes for 10 weeks
        double totalTax = 0; // Variable to store total tax withholding
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Step 2: Prompt the user to enter weekly incomes for 10 weeks
        System.out.println("Enter your income for each of the 10 weeks:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Week " + (i + 1) + ": ");
            weeklyIncomes[i] = scanner.nextDouble(); // Read income for each week
        }

        // Step 3: Loop through incomes to calculate the tax and display the breakdown
        System.out.println("\nTax Breakdown by Week:");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Week", "Income", "Rate (%)", "Tax ($)");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < weeklyIncomes.length; i++) {
            double income = weeklyIncomes[i];
            double rate = getTaxRate(income); // Get the tax rate based on the income
            double tax = income * (rate / 100); // Calculate tax for the income
            totalTax += tax; // Add the calculated tax to the total

            // Display the breakdown for this week
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f%n", (i + 1), income, rate, tax);
        }

        System.out.println("---------------------------------------------------");

        // Step 4: Calculate and display the average tax withholding
        double averageTax = totalTax / 10;
        System.out.printf("The weekly average tax withholding is: $%.2f%n", averageTax);

        // Close the scanner
        scanner.close();
    }

    // Method to get the tax rate based on income brackets
    public static double getTaxRate(double income) {
        if (income < 500) {
            return 10; // 10% tax for income less than $500
        } else if (income >= 500 && income < 1500) {
            return 15; // 15% tax for income between $500 and $1499
        } else if (income >= 1500 && income < 2500) {
            return 20; // 20% tax for income between $1500 and $2499
        } else {
            return 30; // 30% tax for income $2500 and above
        }
    }
}
