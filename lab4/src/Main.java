/**
 * @author xanax01d
 * @LaboratoryWorkNumber 4
 * @Subject ToPMP
 * @Tasks Grades array, Caesar cypher, Sort (not working now, and I don't want to fix it.)
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Запустить Grades");
                System.out.println("2. Запустить CaesarCypher");
                System.out.println("3. Выйти");
                System.out.print(">> ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("\n>>> Запускаем Grades...");
                        Grades.main(args);
                        break;
                    case "2":
                        System.out.println("\n>>> Запускаем CaesarCypher...");
                        CaesarCypher.main(args);
                        break;
                    case "3":
                        System.out.println("\n>>> Выход из программы");
                        return;
                    default:
                        System.out.println("\n[Ошибка] Неверный ввод! Пожалуйста, выберите 1, 2 или 3.");
                        break;
                }
            }
        }
    }
/**
 * The Grades class calculates and evaluates student grades for laboratory work.
 * It initializes an array of grades, calculates the average grade, and determines
 * if the student has passed based on the grades and average mark.
 */
class Grades{
    /**
     * The main method serves as the entry point for the Grades program.
     * It initializes the grades array, calculates the average grade,
     * and checks if the student has passed.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args){
        int[] array = InitializeArray();
        Passed(array,GetAverageMark(array));
    }
    /**
     * Initializes an array of 10 random grades between 1 and 10.
     * Prints the grades to the console.
     *
     * @return An array of 10 random integer grades.
     */
    private static int[] InitializeArray(){
        System.out.println("Оценки по лабораторным работам:");
        Random rand = new Random();
        int[] array = new int[10];
        for(int i = 0; i < 10; i++){
            array[i] = rand.nextInt(10) + 1;
            System.out.print(array[i]+ " ");
        }
        System.out.print("\n");
        return array;
    }
    /**
     * Calculates the average mark from the array of grades.
     * Prints the non-rounded and rounded average mark.
     *
     * @param array The array of grades.
     * @return The rounded average mark as a double.
     */
    private static double GetAverageMark(int[] array){
        double sum = 0;
        for(int grade: array){
            sum += grade;
        }
        double averageMark = sum/10;
        System.out.println("Средняя отметка (не округленная) = " + averageMark +
                "\nОкругленная средняя отметка = " + Math.round(averageMark));
        return Math.round(averageMark);
    }
    /**
     * Checks if the student has passed based on the average mark and grades.
     * A student passes if the average mark is 4 or higher and there are no grades of 0.
     * Prints the result to the console.
     *
     * @param array       The array of grades.
     * @param averageMark The rounded average mark.
     */
    private static void Passed(int[] array, double averageMark){
        if(averageMark >= 4){
            for(int grade: array){
                if (grade == 0){
                    System.out.println("У студента незачет");
                    break;
                }
            }
        }else{
            System.out.print("У студента незачет");
        }
    }
}
/**
 * The CaesarCypher class implements a simple Caesar cipher for encrypting
 * and decrypting a character array using a specified shift value.
 */
class CaesarCypher{
    /**
     * The main method serves as the entry point for the CaesarCypher program.
     * It defines a character array (surname), encrypts it using a Caesar cipher,
     * and decrypts it to verify the results.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args){
        char[] surname = {'k','l','i','m','k','o','v','i','c','h'};
        //char[] surname = {'a','h','a','h','a','h'};
        if (surname.length < 7) {
            System.out.println("Длина массива должна быть не меньше 7 символов.");
            return;
        }
        int shift = 3;
        System.out.println("Исходный массив: ");
        PrintArray(surname);
        System.out.println("Зашифрованный массив со сдвигом в 3: ");
        PrintArray(Encrypt(surname, shift));
        System.out.println("Расшифрованный массив: ");
        PrintArray(Encrypt(Encrypt(surname,shift),-shift));
    }
    /**
     * Encrypts or decrypts a character array using a Caesar cipher with the specified shift.
     * If the shift is positive, the method encrypts the array. If the shift is negative,
     * the method decrypts the array.
     *
     * @param input The character array to encrypt or decrypt.
     * @param shift The shift value for the Caesar cipher (positive for encryption, negative for decryption).
     * @return The resulting encrypted or decrypted character array.
     */
    private static char[] Encrypt(char[] input, int shift){
        char[] result = new char[input.length];
        int alphabetSize = 26;
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (c >= 'a' && c <= 'z') {
                int newChar = (c - 'a' + shift + alphabetSize) % alphabetSize + 'a';
                result[i] = (char) newChar;
            } else {
                result[i] = c;
            }
        }
        return result;
    }
    /**
     * Prints the contents of a character array to the console.
     *
     * @param array The character array to print.
     */
    private static void PrintArray(char[] array){
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

//NOT WORKING, DON'T CHECK.
class Sort{
    public static void main(String[] args){
        int size = 20; // Размер массива
        int maxValue = 10; // Максимальное значение элементов
        int[] arr = GenerateRandomArray(size, maxValue);

        System.out.print("Исходный массив: ");
        printArray(arr);

        int[] sortedArr = FrequencySort(arr);

        System.out.print("Отсортированный массив по частоте: ");
        printArray(sortedArr);
    }
    private static int[] FrequencySort(int[] arr){
        int maxValue = FindMaxValue(arr, 0, 0);
        int[] frequency = new int[maxValue + 1];
        CountFrequencies(arr, frequency, 0);
        return SortByFrequency( frequency, 0, new int[arr.length], 0);
    }
    private static int FindMaxValue(int[] arr, int index, int maxValue) {
        if (index >= arr.length) {
            return maxValue;
        }
        return FindMaxValue(arr, index + 1, Math.max(maxValue, arr[index]));
    }

    private static void CountFrequencies(int[] arr, int[] frequency, int index) {
        if (index >= arr.length) {
            return;
        }
        frequency[arr[index]]++;
        CountFrequencies(arr, frequency, index + 1);
    }

    private static int[] SortByFrequency( int[] frequency, int index, int[] result, int resultIndex) {
        if (index >= frequency.length) {
            return result;
        }
        if (frequency[index] > 0) {
            for (int i = 0; i < frequency[index]; i++) {
                result[resultIndex++] = index;
            }
        }
        return SortByFrequency(frequency, index + 1, result, resultIndex);
    }

    private static int[] GenerateRandomArray(int size, int maxValue){
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(maxValue + 1); // Генерация чисел от 0 до maxValue
        }
        return array;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}