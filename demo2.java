import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class demo2 {

    public static void main(String[] args) {
        // For Problem 1 (single run), uncomment this line
        // runOnce();

        // For Problem 2 (continuous run), uncomment this block
        while (true) {
            runOnce();
            try {
                TimeUnit.SECONDS.sleep(6); // Wait for 6 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void runOnce() {
        // Step 1: Access data from worldtimeapi.org and append to a.txt
        appendWorldTimeToAFile();

        // Step 2: Read a.txt, parse information and write to prg2w.txt
        readAFileAndWriteToPrg2W();

        // Step 3: Read prg1w.txt and print its contents
        readAndPrintPrg1Contents("prg1w.txt");
    }

    private static void appendWorldTimeToAFile() {
        try {
            URL url = new URL("http://worldtimeapi.org/api/timezone/Asia/Tokyo");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Append to a.txt
            try (FileWriter writer = new FileWriter("a.txt", true)) {
                writer.write(response.toString() + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error accessing worldtimeapi.org: " + e.getMessage());
        }
    }

    private static void readAFileAndWriteToPrg2W() {
        try (BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("prg2w.txt"))) {

            String line;
            String lastLine = null;

            while ((line = reader.readLine()) != null) {
                lastLine = line; // Read the last line
            }

            if (lastLine != null) {
                String[] parts = lastLine.split(",");
                if (parts.length >= 3) {
                    String ipAddress = parts[0].trim();
                    String dateTime = parts[1].trim();
                    String dayOfWeek = getDayOfWeek(Integer.parseInt(parts[2].trim()));

                    String content = ipAddress + ", " + dateTime + ", " + dayOfWeek;
                    writer.write(content);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading from/writing to files: " + e.getMessage());
        }
    }

    private static String getDayOfWeek(int day) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (day >= 0 && day < 7) {
            return daysOfWeek[day];
        } else {
            return "Unknown";
        }
    }

    private static void readAndPrintPrg1Contents(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean contentFound = false;

            while ((line = reader.readLine()) != null) {
                contentFound = true;
                System.out.println("Content from " + fileName + ": " + line);
            }

            if (!contentFound) {
                System.out.println("No contents found in " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + fileName + ": " + e.getMessage());
        }
    }
}
