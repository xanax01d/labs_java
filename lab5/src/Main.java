/**
 * @author xanax01d
 * @LaboratoryWorkNumber 5
 * @Subject ToPMP
 */
import java.util.Scanner;
import java.util.Random;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                while (true) {
                    // Display the menu
                    System.out.println("=== Main Menu ===");
                    System.out.println("1. Run Judges");
                    System.out.println("2. Run ArraySorter");
                    System.out.println("3. Run MatrixSum");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    if (!scanner.hasNextLine()) {
                        System.out.println("\nInput stream closed. Exiting.");
                        break;
                    }

                    String input = scanner.nextLine().trim();

                    // Check if input is a valid integer
                    int choice;
                    try {
                        choice = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid input. Please enter a number.");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            System.out.println("\nRunning Judges...");
                            Judges.main(args);
                            break;

                        case 2:
                            System.out.println("\nRunning ArraySorter...");
                            ArraySorter.main(args);
                            break;

                        case 3:
                            System.out.println("\nRunning MatrixSum...");
                            MatrixSum.main(args);
                            break;

                        case 0:
                            System.out.println("\nExiting the program. Goodbye!");
                            scanner.close();
                            return;

                        default:
                            System.out.println("\nInvalid choice. Please try again.");
                    }
                    System.out.println(); // Add a blank line for better readability
}}}
/**
 * The Judges class helps simulate a competition where four judges rate participants.
 * Each participant receives a score from 0 to 100 (with one decimal place) from each judge.
 * The winner is determined based on the highest average score.
 */
class Judges {

    private static final int NUM_PARTICIPANTS = 30;
    private static final int NUM_JUDGES = 4;

    /**
     * Main method to simulate the competition and determine the winner.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        double[][] scores = new double[NUM_PARTICIPANTS][NUM_JUDGES];
        double[] averageScores = new double[NUM_PARTICIPANTS];

        generateScores(scores);
        countAverages(scores,averageScores);
        int winnerIndex = findWinner(averageScores);
        System.out.println("Результаты соревнований:");
        for (int i = 0; i < NUM_PARTICIPANTS; i++) {
            System.out.printf("Участник %d: Средняя оценка = %.1f\n", i + 1, averageScores[i]);
        }
        System.out.printf("\nПобедитель: Участник %d с средней оценкой: %.1f\n",
                winnerIndex + 1, averageScores[winnerIndex]);
    }

    /**
     * Generates random scores (0 to 100 with one decimal precision) for all participants.
     *
     * @param scores A 2D array to store the scores from judges for each participant
     */
    private static void generateScores(double[][] scores) {
        Random random = new Random();
        for (int i = 0; i < scores.length; i++) { // Iterate over participants
            for (int j = 0; j < scores[i].length; j++) { // Iterate over judges
                scores[i][j] = Math.round((random.nextDouble() * 100) * 10.0) / 10.0;
            }
        }
    }

    /**
     * Calculates the average scores for each participant based on the judges' scores.
     *
     * @param scores        A 2D array containing scores from judges for each participant
     * @param averageScores An array to store the calculated average scores
     */
    private static void countAverages(double[][] scores, double[] averageScores) {
        for (int i = 0; i < scores.length; i++) {
            double total = 0;
            for (int j = 0; j < scores[i].length; j++) {
                total += scores[i][j];
            }
            averageScores[i] = total / scores[i].length;
        }
    }
    /**
     * Finds the index of the participant with the highest average score.
     *
     * @param averageScores An array containing the average scores of participants
     * @return The index of the participant with the highest average score
     */
    private static int findWinner(double[] averageScores) {
        int winnerIndex = 0;
        double highestScore = averageScores[0];
        for (int i = 0; i < averageScores.length; i++) {
            if (averageScores[i] > highestScore) {
                highestScore = averageScores[i];
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
}
/**
 * The ArraySorter class generates a random 2D array,
 * sorts the first half of the array rows in ascending order,
 * and the second half in descending order.
 */
class ArraySorter{
    public static void main(String[] args){
        // Define the dimensions of the array and the range of random numbers
        int rows = 6; // Number of rows
        int cols = 5; // Number of columns
        int min = -10; // Minimum value for random numbers
        int max = 10;  // Maximum value for random numbers

        // Generate the 2D array
        int[][] array = generateArray(rows, cols, min, max);

        // Print the original array
        System.out.println("Original Array:");
        printArray(array);

        // Sort the array
        sortArray(array);

        // Print the sorted array
        System.out.println("\nSorted Array:");
        printArray(array);
    }
    /**
     * Generates a 2D array with random integers in the specified range.
     *
     * @param rows    The number of rows in the array.
     * @param cols    The number of columns in the array.
     * @param min     The minimum value for random numbers.
     * @param max     The maximum value for random numbers.
     * @return        A 2D array filled with random integers in the given range.
     */
    private static int[][] generateArray(int rows, int cols, int min, int max){
        Random random = new Random();
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                array[i][j] = random.nextInt(max-min + 1) + min;
            }
        }
        return array;}
    /**
     * Sorts the first half of the array rows in ascending order
     * and the second half in descending order.
     *
     * @param array The 2D array to be sorted.
     */
    private static void sortArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        // Calculate the total number of elements in the array
        int totalElements = rows * cols;

        // Calculate the middle index (split the array horizontally)
        int middleIndex = (totalElements + 1) / 2;

        // Create a temporary array to hold all elements
        int[] tempArray = new int[totalElements];

        // Copy all elements from the 2D array into the temporary array
        int index = 0;
        for (int[] row : array) {
            for (int value : row) {
                tempArray[index++] = value;
            }
        }

        // Sort the first half in ascending order
        bubbleSort(tempArray, 0, middleIndex, true);

        // Sort the second half in descending order
        bubbleSort(tempArray, middleIndex, totalElements, false);

        // Copy the sorted elements back into the original 2D array
        index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = tempArray[index++];
            }
        }
    }

    /**
     * Custom implementation of the Bubble Sort algorithm for sorting part of a 1D array.
     *
     * @param array     The 1D array to be sorted.
     * @param start     The starting index of the portion to be sorted.
     * @param end       The ending index (exclusive) of the portion to be sorted.
     * @param ascending If true, sorts in ascending order; otherwise, sorts in descending order.
     */
    private static void bubbleSort(int[] array, int start, int end, boolean ascending) {
        for (int i = start; i < end - 1; i++) {
            for (int j = start; j < end - 1 - (i - start); j++) {
                if (ascending && array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (!ascending && array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    /**
     * Prints a 2D array to the console.
     *
     * @param array The 2D array to be printed.
     */
    private static void printArray(int[][] array){
        for(int[] row: array){
            System.out.print('[');
            for(int i = 0; i < row.length; i++){
                System.out.print(row[i]);
                if(i < row.length - 1){
                    System.out.print(',');
                }
            }
            System.out.println(']');
        }
    }
}
/**
 * This program calculates the sum of positive elements in a square matrix
 * that are located above or on the main diagonal.
 */
class MatrixSum{
    /**
     * Main method to run the program.
     *
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Input matrix order (n x n)
        System.out.print("Enter the order of the square matrix (n): ");
        int n = scanner.nextInt();

        // Input range for random numbers
        System.out.print("Enter the minimum value for random numbers: ");
        int min = scanner.nextInt();
        System.out.print("Enter the maximum value for random numbers: ");
        int max = scanner.nextInt();

        // Generate the matrix with random values
        int[][] matrix = new int[n][n];
        generateRandomValuesToMatrix(matrix, n, min, max);

        // Display the generated matrix
        System.out.println("Generated matrix:");
        printMatrix(matrix, n);

        // Calculate the sum of positive elements above or on the main diagonal
        int sum = calculatePositiveSum(matrix, n);

        // Output the result
        System.out.println("The sum of positive elements above or on the main diagonal is: " + sum);

        scanner.close();


    }
    /**
     * Fills a square matrix with random values within a specified range.
     *
     * @param matrix The square matrix to fill.
     * @param n      The order of the matrix (number of rows/columns).
     * @param min    The minimum value for random numbers.
     * @param max    The maximum value for random numbers.
     */
    private static void generateRandomValuesToMatrix(int[][] matrix, int n, int min, int max){
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = random.nextInt(max - min + 1) + min;

            }
        }
    }
    /**
     * Prints a square matrix to the console.
     *
     * @param matrix The square matrix to print.
     * @param n      The order of the matrix (number of rows/columns).
     */
    private static void printMatrix(int[][] matrix, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    /**
     * Calculates the sum of positive elements in the square matrix that are
     * above or on the main diagonal.
     *
     * @param matrix The square matrix.
     * @param n      The order of the matrix (number of rows/columns).
     * @return The sum of positive elements above or on the main diagonal.
     */
    public static int calculatePositiveSum(int[][] matrix, int n) {
        int sum = 0;

        // Iterate through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // Start from the diagonal (j >= i)
                if (matrix[i][j] > 0) { // Check if the element is positive
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}