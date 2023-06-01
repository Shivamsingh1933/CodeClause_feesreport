import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Accountant {
    private String name;
    private double fees;

    public Accountant(String name, double fees) {
        this.name = name;
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}

class Admin {
    private List<Accountant> accountants;

    public Admin() {
        accountants = new ArrayList<>();
    }

    public void addAccountant(String name, double fees) {
        Accountant accountant = new Accountant(name, fees);
        accountants.add(accountant);
        System.out.println("Accountant added successfully.");
    }

    public void deleteAccountant(String name) {
        Accountant accountant = findAccountant(name);
        if (accountant != null) {
            accountants.remove(accountant);
            System.out.println("Accountant deleted successfully.");
        } else {
            System.out.println("Accountant not found.");
        }
    }

    public void generateFeesReport() {
        System.out.println("Fees Report:");
        for (Accountant accountant : accountants) {
            System.out.println("Name: " + accountant.getName() + ", Fees: " + accountant.getFees());
        }
    }

    private Accountant findAccountant(String name) {
        for (Accountant accountant : accountants) {
            if (accountant.getName().equals(name)) {
                return accountant;
            }
        }
        return null;
    }
}

public class FeeReport
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        while (true) {
            System.out.println("1. Add Accountant");
            System.out.println("2. Delete Accountant");
            System.out.println("3. Generate Fees Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter accountant name: ");
                    String name = scanner.next();
                    System.out.print("Enter accountant fees: ");
                    double fees = scanner.nextDouble();
                    admin.addAccountant(name, fees);
                    break;
                case 2:
                    System.out.print("Enter accountant name: ");
                    String deleteName = scanner.next();
                    admin.deleteAccountant(deleteName);
                    break;
                case 3:
                    admin.generateFeesReport();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}

