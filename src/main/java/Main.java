import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int functionChoices;
        String textInput;
        JournalManager journalManager = new JournalManager();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to Personal Journal Application");
            System.out.println("1. Add your personal");
            System.out.println("2. Read your personal");
            System.out.println("3. Delete your personal");
            System.out.println("4. Clear all personal");
            System.out.println("5. Exit");
            System.out.print("Select an option : ");
            functionChoices = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (functionChoices) {
                case 1 :
                    System.out.print("Enter your personal : ");
                    textInput = scanner.nextLine();
                    System.out.println();
                    journalManager.writeEntry(new JournalEntry(textInput));
                    System.out.println("Write Successfully");
                    break;
                case 2 :
                    System.out.println("This is all of your personal\n");
                    for (String entry : journalManager.readEntries()) {
                        System.out.println(entry);
                    }
                    break;
                case 3 :
                    System.out.print("Enter your time : ");
                    textInput = scanner.nextLine();
                    System.out.println();
                    LocalDateTime date = LocalDateTime.parse(textInput, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
                    if (journalManager.deleteEntries(date)) {
                        System.out.println("Delete Successfully");
                    } else {
                        System.out.println("Personal Not Found");
                    }
                    break;
                case 4 :
                    journalManager.clearEntries();
                    System.out.println("Clear All Entries Successfully");
                    break;
                case 5 :
                    System.out.println("Exit application");
                    break;
                default :
                    System.out.println("Invalid option");
                    break;
            }
            System.out.println();
        } while (functionChoices != 5);
    }
}
