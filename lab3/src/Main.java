/**
 * @author xanax01d
 * @laboratoryWorkNumber 3
 * @subject ToPMP
 * @Tasks Check for Prime, Factorial of number, Fibonacci Sequence, "Guess the number" game
 */
import java.util.Scanner;
import java.util.Random;

/**
 * Main class, contains methods for print menu and select the task.
 */
public class Main {
    /**
     * Main function on this class, responsible for displaying menu and selecting tasks.
     *
     * @param args an array of command line string arguments (not used)
     */
    public static void main(String[] args) {
        /* for test
        IsPrime.main(args);
        Factorial.main(args);
        FibonacciSequence.main(args);
        GuessTheNumber.main(args);*/
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            executeChoice(choice, args);
        } while (choice != 0);

        scanner.close();
    }

    /**
     * Function, used to display the menu.
     */
    private static void displayMenu() {
        System.out.println("\nВыберите программу для запуска:");
        System.out.println("1. Проверка на простое число");
        System.out.println("2. Вычисление факториала");
        System.out.println("3. Последовательность Фибоначчи");
        System.out.println("4. Угадай число");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Function, used to execute the selected task.
     *
     * @param choice number of task, that a user selected
     * @param args an array of command line string arguments (not used)
     */
    private static void executeChoice(int choice, String[] args) {
        switch (choice) {
            case 1:
                IsPrime.main(args);
                break;
            case 2:
                Factorial.main(args);
                break;
            case 3:
                FibonacciSequence.main(args);
                break;
            case 4:
                GuessTheNumber.main(args);
                break;
            case 0:
                System.out.println("Выход из программы.");
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}

/**
 * Сlass,used to determine whether a number is prime or not.
 */
class IsPrime {
    /**
     * Entry point to the program.
     *
     * @param args an array of command line string arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        printResult(number,isPrime(number));
    }

    /**
     * Function, used to determine whether a number is prime or not
     *
     * @param number number, that user is entered
     * @return number is prime (true) or not (false)
     */
    private static boolean isPrime(int number){
        if(number < 2) return false;
        for(int i = 2; i <= number/2; i++){ //The divisor of a number cannot be greater than half of it (except for the number itself).
            if(number % i == 0) return false;
        }
        return true;
    }
    /*for check by square root
    public static boolean isPrime(int number) {
        if (number <= 1) return false; // Отрицательные числа, 0 и 1 не являются простыми
        if (number <= 3) return true; // 2 и 3 - простые числа

        // Убираем четные числа и числа, делящиеся на 3
        if (number % 2 == 0 || number % 3 == 0) return false;

        // Проверяем делители только до квадратного корня числа
        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false; // Если делится, не простое
            }
        }
        return true; // Если не нашли делителей, число простое
    }
    */
    /**
     * Function, that displays the result of checking for primality of a number.
     *
     * @param number number that was checked
     * @param isPrime check result: true if the number is prime, otherwise false
     */
    private static void printResult(int number,boolean isPrime){
        if(isPrime) System.out.print("Число " + number + " является простым.");
        else System.out.print("Число " + number + " не является простым.");
    }
}

/**
 * A class that calculates the factorial of a given number.
 */
class Factorial{
    /**
     * The main method that serves as the entry point for the program.
     * It prompts the user to input a number and displays its factorial.
     *
     * @param args an array of command-line arguments (not used)
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        System.out.print(number + "! = " + factorial(number));
    }
    /**
     * Calculates the factorial of a given non-negative integer.
     *
     * @param number the non-negative integer for which the factorial is to be calculated
     * @return the factorial of the number, or -1 if the number is negative
     */
    private static int factorial(int number){
        if(number < 0) return -1;
        int result = 1;
        while(number > 1){
            result *= number;
            number--;
        }
        return result;
    }
}

/**
 * A class that generates and displays the Fibonacci sequence up to a specified number of elements.
 */
class FibonacciSequence{
    /**
     * The main method serves as the entry point for the program.
     * It prompts the user to input the number of elements in the Fibonacci sequence to display.
     *
     * @param args an array of command-line arguments (not used)
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов последовательности Фибоначчи: ");
        int number = scanner.nextInt();
        fibonacciSequence(number);
    }
    /**
     * Generates and prints the Fibonacci sequence up to the specified number of elements.
     *
     * @param number the number of elements in the Fibonacci sequence to generate
     */
    private static void fibonacciSequence(int number){
        if(number == 0) return;
        int a = 0,b = 1;
        int count = 0;
        System.out.print("Последовательность Фибоначчи: ");
        while (count < number){
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
            count++;
        }
    }
}

/**
 * A class that implements a number guessing game where the user has to guess a randomly generated number.
 */
class GuessTheNumber {

    /**
     * The main method serves as the entry point for the program.
     * It initializes the game and starts the guessing process.
     *
     * @param args an array of command-line arguments (not used)
     */
    public static void main(String[] args) {
        int numberToGuess = generateRandomNumber();
        playGame(numberToGuess);
    }

    /**
     * Generates a random number between 1 and 100.
     *
     * @return the generated random number
     */
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Random number between 1 and 100
    }

    /**
     * Starts the guessing game where the user tries to guess the number.
     *
     * @param numberToGuess the number that the user needs to guess
     */
    private static void playGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;
        int attempts = 0;

        System.out.print("Я загадал число от 1 до 100.\n");

        while (userGuess != numberToGuess) {
            userGuess = getUserGuess(scanner);
            attempts++;
            provideFeedback(userGuess, numberToGuess, attempts);
        }
    }

    /**
     * Prompts the user to enter a guess and returns the guessed number.
     *
     * @param scanner the Scanner object for reading user input
     * @return the user's guessed number
     */
    private static int getUserGuess(Scanner scanner) {
        System.out.print("Давай угадывай: ");
        return scanner.nextInt();
    }

    /**
     * Provides feedback based on the user's guess compared to the number to guess.
     *
     * @param userGuess    the number guessed by the user
     * @param numberToGuess the actual number that needs to be guessed
     * @param attempts      the number of attempts made by the user
     */
    private static void provideFeedback(int userGuess, int numberToGuess, int attempts) {
        if (userGuess < numberToGuess) {
            System.out.println("\nМало.");
        } else if (userGuess > numberToGuess) {
            System.out.println("\nМного.");
        } else {
            System.out.print("\nТы угадал.\nЧисло: " + numberToGuess + "\nКоличество попыток: " + attempts);
        }
        if (userGuess == 52) {
            System.out.print("Это второй! 52 (Алло) Да здравствует Санкт-Петербург!\n");
        }
    }
}