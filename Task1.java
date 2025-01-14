// CREATE A JAVA PROGRAM TO READ, WRITE, AND MODIFY TEXT FILES.
// DELIVERABLE: A SCRIPT
// DEMONSTRATING FILE OPERATIONS
// WITH CLEAR DOCUMENTATION.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileHandling {

    private String fileName; // To store the user-specified file name

    // Method to set the file name
    public void setFileName(String fileName , String extension ) {
        if(!extension.startsWith(".")){
            extension = "."+ extension;//here extension start with .
        }
        this.fileName = fileName+extension; 
    }

    // Method to create a file
    public void createFile() {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // Method to read a file
    public void readFile() {
        try (Scanner sc = new Scanner(new File(fileName))) {
            System.out.println("Reading file content:");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    // Method to write to a file
    public void writeFile() {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("This is a new line of text. This is my first task, hope you like my work...");
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to append text to a file
    public void appendToFile() {
        try (FileWriter writer = new FileWriter(fileName, true)) { // 'true' enables appending
            writer.append("\nHello, this is appended text...");
            System.out.println("Text appended to file successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    // Method to delete a file
    public void deleteFile() {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("File not found or could not be deleted.");
        }
    }
}

public class Task1 {

    public static void main(String[] args) {
        FileHandling fileHandler = new FileHandling();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name (without extension ): ");//only input file name
        String userFileName = sc.nextLine();
        System.out.print("Enter the file extension like .txt or .word: ");//input file extension

        String userExtension = sc.nextLine();
        fileHandler.setFileName(userFileName , userExtension);

        while (true) {
            // Display menu
            System.out.println("\nFile Handling Menu:");
            System.out.println("1. Create a file");
            System.out.println("2. Read a file");
            System.out.println("3. Write to a file");
            System.out.println("4. Delete a file");
            System.out.println("5. Append to a file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Validate user input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                sc.next(); // Clear invalid input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline left after nextInt()

            switch (choice) {
                case 1:
                    fileHandler.createFile();
                    break;
                case 2:
                    fileHandler.readFile();
                    break;
                case 3:
                    fileHandler.writeFile();
                    break;
                case 4:
                    fileHandler.deleteFile();
                    break;
                case 5:
                    fileHandler.appendToFile();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 6.");
            }
        }
    }
}
