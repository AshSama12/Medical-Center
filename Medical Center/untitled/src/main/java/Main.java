import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMedical Center System:");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient by DOB");
            System.out.println("3. Add Drug to Stock");
            System.out.println("4. Issue Drug to Patient");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Disease: ");
                    String disease = scanner.nextLine();
                    System.out.print("Enter Issued Drug: ");
                    String drugIssued = scanner.nextLine();

                    PatientDAO.addPatient(name, dob, age, disease, drugIssued);
                    break;

                case 2:
                    System.out.print("Enter Patient DOB (YYYY-MM-DD): ");
                    String searchDob = scanner.nextLine();
                    PatientDAO.searchPatientByDOB(searchDob);
                    break;

                case 3:
                    System.out.print("Enter Drug Name: ");
                    String drugName = scanner.nextLine();
                    System.out.print("Enter Drug Count: ");
                    int drugCount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    DrugInsert.addDrug(drugName, drugCount);
                    break;

                case 4:
                    System.out.print("Enter Drug Name to Issue: ");
                    String issueDrugName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int issueQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    DrugIssue.issueDrug(issueDrugName, issueQuantity);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
