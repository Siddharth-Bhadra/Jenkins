public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Group A - Spetnaz");

        System.out.println();
        System.out.println();
        
        int rows = 5; // Number of rows for the triangle

        // Outer loop for number of rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print spaces
            for (int j = rows - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Inner loop to print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}
