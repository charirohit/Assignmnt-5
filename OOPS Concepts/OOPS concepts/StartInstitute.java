import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StartInstitute {
    private static final List<Institute> institutes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeInstitutes();

        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayAllInstitutes();
                    break;
                case 2:
                    searchInstitute(sc);
                    break;
                case 3:
                    addNewInstitute(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    private static void initializeInstitutes() {
        institutes.add(new PublicInstitute("Aligarh Muslim University", "Aligarh", "Uttar Pradesh",
                "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India",
                "Ministry of Education"));
        institutes.add(new PublicInstitute("Banaras Hindu University", "Varanasi", "Uttar Pradesh",
                "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India",
                "Ministry of Education"));
        institutes.add(new PublicInstitute("University of Delhi", "Delhi", "Delhi",
                "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India",
                "Ministry of Education"));
        institutes.add(new PrivateInstitute("Atal Bihari Vajpayee IIITM, Gwalior", "Gwalior", "Madhya Pradesh",
                "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments",
                "Ministry of Education"));
        institutes.add(new PrivateInstitute("Indian Institute of Information Technology, Allahabad", "Allahabad",
                "Uttar Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments",
                "Ministry of Education"));
    }

    private static void showMenu() {
        System.out.println("=======================================================");
        System.out.println("PRESS");
        System.out.println("1. To Display all Institutes");
        System.out.println("2. To Search an Institute");
        System.out.println("3. To Add a New Institute");
        System.out.println("0. To Exit");
        System.out.println("=======================================================");
    }

    private static void displayAllInstitutes() {
        if (institutes.isEmpty()) {
            System.out.println("No institutes available.");
        } else {
            for (Institute inst : institutes) {
                inst.display();
            }
        }
    }

    private static void searchInstitute(Scanner scanner) {
        System.out.println("PRESS");
        System.out.println("1. To Search by Name");
        System.out.println("2. To Search by City");
        System.out.println("3. To Search by State");
        System.out.println("0. To Exit");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                System.out.println("Enter name of the institute to search:");
                String name = scanner.nextLine();
                searchByName(name);
                break;
            case 2:
                System.out.println("Enter the city:");
                String city = scanner.nextLine();
                searchByCity(city);
                break;
            case 3:
                System.out.println("Enter the state:");
                String state = scanner.nextLine();
                searchByState(state);
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void searchByName(String name) {
        boolean found = false;
        for (Institute inst : institutes) {
            if (inst.getName().equalsIgnoreCase(name)) {
                inst.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Institute not found.");
        }
    }

    private static void searchByCity(String city) {
        boolean found = false;
        for (Institute inst : institutes) {
            if (inst.getCity().equalsIgnoreCase(city)) {
                inst.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Institute not found.");
        }
    }

    private static void searchByState(String state) {
        boolean found = false;
        for (Institute inst : institutes) {
            if (inst.getState().equalsIgnoreCase(state)) {
                inst.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Institute not found.");
        }
    }

    private static void addNewInstitute(Scanner scanner) {
        System.out.println("Enter the name of the institute:");
        String name = scanner.nextLine();
        System.out.println("Enter City of the institute:");
        String city = scanner.nextLine();
        System.out.println("Enter State of the institute:");
        String state = scanner.nextLine();
        System.out.println("Enter Act of the institute:");
        String act = scanner.nextLine();
        System.out.println("Enter Ministry of the institute:");
        String ministry = scanner.nextLine();

        // For demonstration, we're adding as a public institute. 
        // This could be modified based on user input to select type.
        Institute newInstitute = new PublicInstitute(name, city, state, act, ministry);
        institutes.add(newInstitute);
        System.out.println("New institute added successfully.");
    }
}

