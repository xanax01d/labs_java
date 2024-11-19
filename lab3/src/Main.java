import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //IsPrime.main(args);
        //Factorial.main(args);
        //FibonacciSequence.main(args);
        //GuessTheNumber.main(args);
    }
}
class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        printResult(number,isPrime(number));
    }

    private static boolean isPrime(int number){
        if(number < 2) return false;
        for(int i = 2; i <= number/2; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    private static void printResult(int number,boolean isPrime){
        if(isPrime) System.out.print("Число " + number + " является простым.");
        else System.out.print("Число " + number + " не является простым.");
    }
}
class Factorial{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        System.out.print(number + "! = " + factorial(number));
    }

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
class FibonacciSequence{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов последовательности Фибоначчи (Ебаначчи, блять.): ");
        int number = scanner.nextInt();
        fibonacciSequence(number);
    }
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
class GuessTheNumber{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random  random = new Random();

        int numberToGuess = random.nextInt(100)+1;
        int userGuess = 0;
        int attempts = 0;
        System.out.print(numberToGuess);
        System.out.print("Я загадал число от 0 до дохуя, попробуй угадай, чумба.\n");

        while (userGuess != numberToGuess){
            System.out.print("Давай угадывай, чумба: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) System.out.println("\nСлишком нихуя, чумба.");
            else if (userGuess > numberToGuess) System.out.println("\nСлишком дохуя, чумба.");
            else System.out.print("\nХуя, чумба, ты угадал. \nЧисло: " + numberToGuess +"\nКоличество попыток: "+attempts);
            if (userGuess == 52) System.out.print("Это второй! 52 (Алло) Да здравствует Санкт-Петербург!\n");
        }
    }
}