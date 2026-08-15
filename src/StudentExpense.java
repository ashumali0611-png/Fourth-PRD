
import java.util.Scanner;

public class StudentExpense {

    String studentName;
    double dailyBudget;
    double foodExpense;
    double travelExpense;
    double studyExpense;
    double otherExpense;

    public double calculateTotalExpense() {
        return foodExpense + travelExpense + studyExpense + otherExpense;
    }

    public double calculateRemainingAmount() {
        return dailyBudget - calculateTotalExpense();
    }

    public boolean isWithinBudget() {
        return calculateTotalExpense() <= dailyBudget;
    }

    public double calculateExceededAmount() {
        double totalExpense = calculateTotalExpense();
        if (totalExpense > dailyBudget) {
            return totalExpense - dailyBudget;
        } else {
            return 0.0;
        }
    }

    public String getBudgetStatus() {
        double totalExpense = calculateTotalExpense();

        if (totalExpense < dailyBudget) {
            return "Within Budget";
        } else if (totalExpense == dailyBudget) {
            return "Budget Fully Used";
        } else {
            return "Budget Exceeded";
        }
    }

    public void displayExpenseReport() {
        double totalExpense = calculateTotalExpense();

        System.out.println("---------- DAILY EXPENSE REPORT ----------");
        System.out.println("Student Name: " + studentName);
        System.out.println("Daily Budget: " + dailyBudget);
        System.out.println("Food Expense: " + foodExpense);
        System.out.println("Travel Expense: " + travelExpense);
        System.out.println("Study Expense: " + studyExpense);
        System.out.println("Other Expense: " + otherExpense);
        System.out.println("Total Expense: " + calculateTotalExpense());

        if (isWithinBudget()) {
            System.out.println("Remaining Amount: " + calculateRemainingAmount());
        } else {
            System.out.println("Exceeded Amount: " + calculateExceededAmount());
        }

        System.out.println("Budget Status:" + getBudgetStatus());
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentExpense student = new StudentExpense();

        System.out.println("Enter student name: ");
        student.studentName = scanner.nextLine();

        System.out.println("Enter daily budget: ");
        student.dailyBudget = scanner.nextDouble();

        System.out.println("Enter food expense: ");
        student.foodExpense = scanner.nextDouble();

        System.out.println("Enter travel expense: ");
        student.travelExpense = scanner.nextDouble();

        System.out.println("Enter study expense: ");
        student.studyExpense = scanner.nextDouble();

        System.out.println("Enter other expense: ");
        student.otherExpense = scanner.nextDouble();

        System.out.println();

        student.displayExpenseReport();
        scanner.close();
    }
}
