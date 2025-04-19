/**
 * @author xanax01d
 * @LaboratoryWorkNumber 6
 * @Subject ToPMP
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        final int SIZE = 3000;

        int[] bubbleArray = new int[SIZE];
        int[] selectionArray = new int[SIZE];

        // Заполнение массивов случайными числами от 0 до 9999
        for (int i = 0; i < SIZE; i++) {
            bubbleArray[i] = random.nextInt(10000);
            selectionArray[i] = random.nextInt(10000);
        }

        while (running) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Сортировка пузырьком (первый массив)");
            System.out.println("2. Сортировка выбором (второй массив)");
            System.out.println("3. Линейный поиск (в первом массиве)");
            System.out.println("4. Бинарный поиск (во втором массиве)");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n➡ Сортировка пузырьком:");
                    printArray(bubbleArray, "До сортировки");
                    long startTime = System.nanoTime();
                    bubbleSort(bubbleArray);
                    long endTime = System.nanoTime();
                    printArray(bubbleArray, "После сортировки");
                    printElapsedTime(startTime, endTime);
                }
                case 2 -> {
                    System.out.println("\n➡ Сортировка выбором:");
                    printArray(selectionArray, "До сортировки");
                    long startTime = System.nanoTime();
                    selectionSort(selectionArray);
                    long endTime = System.nanoTime();
                    printArray(selectionArray, "После сортировки");
                    printElapsedTime(startTime, endTime);
                }
                case 3 -> {
                    System.out.print("Введите число для поиска: ");
                    int target = scanner.nextInt();
                    long startTime = System.nanoTime();
                    int index = linearSearch(bubbleArray, target);
                    long endTime = System.nanoTime();
                    printArray(bubbleArray, "Массив");
                    if (index != -1) {
                        System.out.println("Число найдено на позиции: " + index);
                    } else {
                        System.out.println("Число не найдено.");
                    }
                    printElapsedTime(startTime, endTime);
                }
                case 4 -> {
                    System.out.print("Введите число для поиска: ");
                    int target = scanner.nextInt();

                    // сортируем перед бинарным поиском
                    int[] sortedArray = Arrays.copyOf(selectionArray, selectionArray.length);
                    Arrays.sort(sortedArray);

                    long startTime = System.nanoTime();
                    int index = binarySearch(sortedArray, target);
                    long endTime = System.nanoTime();
                    printArray(sortedArray, "Отсортированный массив");
                    if (index != -1) {
                        System.out.println("Число найдено на позиции: " + index);
                    } else {
                        System.out.println("Число не найдено.");
                    }
                    printElapsedTime(startTime, endTime);
                }
                case 0 -> {
                    running = false;
                    System.out.println("Выход из программы...");
                }
                default -> System.out.println("Неверный пункт. Повторите ввод.");
            }
        }

        scanner.close();
    }

    /**
     * Сортировка пузырьком массива.
     */
    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /**
     * Сортировка выбором массива.
     */
    private static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Поиск минимального
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Обмен
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Линейный поиск элемента.
     *
     * @return индекс элемента или -1
     */
    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Бинарный поиск (на отсортированном массиве).
     *
     * @return индекс элемента или -1
     */
    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    /**
     * Печатает весь массив с меткой.
     */
    private static void printArray(int[] array, String label) {
        System.out.println(label + ":");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5d ", array[i]);
            if ((i + 1) % 20 == 0) System.out.println();
        }
        System.out.println();
    }

    /**
     * Печатает время выполнения в миллисекундах.
     */
    private static void printElapsedTime(long start, long end) {
        long duration = (end - start) / 1_000_000;
        System.out.println("Время выполнения: " + duration + " мс\n");
    }
}
