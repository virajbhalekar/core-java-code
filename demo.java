import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class demo {

    public static void main(String[] args) {
        // For Problem 1 (single run), uncomment this line
        // runOnce();

        // For Problem 2 (continuous run), uncomment this block
        while (true) {
            runOnce();
            try {
                TimeUnit.SECONDS.sleep(5); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void runOnce() {
        // Step 1: Write current date and time to prg1w.txt
        writeCurrentDateTimeToFile("prg1w.txt");

        // Step 2: Read prg2w.txt and print its contents with a unique serial number
        readAndPrintPrg2Contents("prg2w.txt");

        // Step 3: Print current date and time
        Date currentDate = new Date();
        System.out.println("Current Date and Time: " + currentDate);
    }

    private static void writeCurrentDateTimeToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Date currentDate = new Date();
            writer.write(currentDate.toString());
        } catch (IOException e) {
            System.err.println("Error writing to " + fileName + ": " + e.getMessage());
        }
    }

    private static void readAndPrintPrg2Contents(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int serialNumber = 1;
            boolean contentFound = false;

            while ((line = reader.readLine()) != null) {
                contentFound = true;
                System.out.println("Line " + serialNumber++ + ": " + line);
            }

            if (!contentFound) {
                System.out.println("No contents found in " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + fileName + ": " + e.getMessage());
        }
    }
}
