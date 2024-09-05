public class Butterfly {
    public static void main(String[] args) {
        int n = 5; // You can change this value to adjust the size of the butterfly

        // Top half of the butterfly
        for (int i = 1; i <= n; i++) {
            // Print the first part of the pattern
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in the middle
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print the second part of the pattern
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Bottom half of the butterfly
        for (int i = n; i >= 1; i--) {
            // Print the first part of the pattern
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in the middle
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print the second part of the pattern
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
