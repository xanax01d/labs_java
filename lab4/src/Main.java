/**
 * @author xanax01d
 * @LaboratoryWorkNumber 4
 * @Subject ToPMP
 * @Tasks Grades array, Caesar cypher, Sort
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Grades.main(args);
        //CaesarCypher.main(args);
        //Sort.main(args);
    }
}

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

class Grades{
    public static void main(String[] args){
        int[] array = InitializeArray();
        Passed(array,GetAverageMark(array));
    }
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

class CaesarCypher{
    public static void main(String[] args){
        char[] surname = {'k','l','i','m','k','o','v','i','c','h'};
        int shift = 3;
        System.out.println("Исходный массив: ");
        PrintArray(surname);
        System.out.println("Зашифрованный массив со сдвигом в 3: ");
        PrintArray(Encrypt(surname, shift));
        System.out.println("Расшифрованный массив: ");
        PrintArray(Encrypt(Encrypt(surname,shift),-shift));

    }
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
    private static void PrintArray(char[] array){
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}