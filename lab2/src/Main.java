/**
 * @author xanax01d
 * @laboratoryWorkNumber 2
 * @subject ToPMP
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static void print_divider(){
        System.out.print("---------------------------------\n");
    }
    public static void main(String[] args) {
        menu(args);
    }
    private static void menu(String[] args){
        Scanner scanner = new Scanner(System.in);
        print_divider();
        int choice;
        do{
            choice = -1;
            while (choice < 0 || choice > 5){
                System.out.print("""
                        1. Дракон
                        2. The Greatest
                        3. Mood Sensor
                        4. Кости
                        5. Буквы
                        0. Выход
                        Выберите задание:""");
                try{
                    choice = scanner.nextInt();
                    if (choice < 0 || choice > 5){
                        System.out.println("Ошибка: Пожалуйста, введите число от 1 до 5.");
                    } else {
                        print_divider();
                        switch (choice){
                            case 1 -> {Dragon.main(args); print_divider();}
                            case 2 -> {TheGreatest.main(args);print_divider();}
                            case 3 -> {MoodSensor.main(args);print_divider();}
                            case 4 -> {Dice.main(args);print_divider();}
                            case 5 -> {Letter.main(args); print_divider();}
                        }
                    }
                    }catch (InputMismatchException e){
                    System.out.print("Ошибка: Пожалуйста, введите корректное число.");
                    scanner.next();
                }
            }
        }while (choice!=0);
    }
}
/**
 * @problemSetting В молодом возрасте дракон каждый год отращивает по три головы, но
 * после того, как ему исполнится 200 лет – только по две, а после 300 лет –
 * лишь по одной.
 * @task Разработайте программу, которая высчитывала бы,
 * сколько голов и глаз у дракона, которому N лет. Считать, что при рождении
 * у дракона имеется уже три головы.
 */
class Dragon{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите возраст дракона: ");
        int age = scanner.nextInt();
        int[] result =  calculate_heads(age);
        System.out.printf("Y дракона %s голов и %s глаз. \n",result[0],result[1]);
    }
    private static int[] calculate_heads(int age){
        int heads = 3;
        if (age < 200) {
            heads += age * 3;
        }else if (age < 300) {
            heads += (200 * 3) + ((age - 200)*2);
        }else {
            heads += (200*3) + (100*2) + (age - 300);
        }
        int eyes = heads * 2;
        return new int[]{heads, eyes};
    }
}

/**
 * @task Напишите программу «The Greatest», которая определяет какое из трёх
 * (или четырёх, или пяти и т.д.) введённых пользователем значений
 * наибольшее (наименьшее). Предусмотреть возможность равенства всех
 * значений.
 */
class TheGreatest{
    public static void main(String[] args){
        int[] numbers = get_numbers();
        display_results(max(numbers),min(numbers));
    }
    private static int[] get_numbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int number_of_numbers = scanner.nextInt();
        if (number_of_numbers == 0){System.out.print("ладно...");System.exit(0);}
        int[] buffer = new int[number_of_numbers];
        //for i in range(0,num_of_numbers-1)
        for(int i = 0; i < number_of_numbers; i++){
            System.out.print("Введите " + (i+1) + "-ое число: ");
            buffer[i] = scanner.nextInt();
        }
        return(buffer);
    }
    private static int max(int[] numbers){
        int maxValue = numbers[0];
        for (int number : numbers) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
        return maxValue;
    }
    private static int min(int[] numbers){
        int minValue = numbers[0];
        for (int number : numbers) {
            if (number < minValue) {
                minValue = number;
            }
        }
        return minValue; // Возвращаем минимальное значение
    }
    private static void display_results(int max, int min){
        if (min != max){
            System.out.print("Наибольшее число: " + max + "\nНаименьшее число: " + min + "\n");
        } else {
            System.out.print("Все числа равны.\n");
        }
    }
}

/** @task Напишите программу «Mood Sensor» (эмулировать датчик настроения),
 * которая «залазит» в душу пользователя и определяет его настроение в
 * текущий момент времени. Приложение будет генерировать случайное
 * число, в зависимости от значения которого на экран выводится одно из
 * псевдографических «лиц», которое и будет отображать настроение
 * пользователя.
 */
class MoodSensor{
    public static void main(String[] args) {
        compare_mood(get_mood(generate_random_number()));
    }
    private static int generate_random_number(){
        return (int) ((Math.random() * 5) +1);
    }
    private static String get_mood(int random_number){
        return (switch (random_number) {
            case 1 -> "(⌒▽⌒)☆";
            case 2 -> "( ◡‿◡ *)";
            case 3 -> "(＞ｍ＜)";
            case 4 -> "(°ㅂ°╬)";
            case 5 -> "(╥﹏╥)";
            default -> "-";
        });
    }
    private static void compare_mood(String mood){
            if (mood.equals("-")){
                System.out.print("Такого настроения нет в моей базе");
            } else {
                System.out.print("Ваше настроение: " + mood + "\n");
            }
    }
}

/**
 * @task Напишите программу, которая бы эмулировала (не эмулировала, а симулировала)
 * игру «Dice» (игра в кости).
 * Суть игры заключается в броске двух шестигранных кубиков (костей) и
 * подсчёта общей суммы очков, которые выпали на первой и второй костей.
 */
class Dice{
    public static void main(String[] args){
        int[] dices = new int[2];
        System.out.print("Бросаем кости");
        for(int i = 0; i < 2; i++){
            dices[i] = generate_random_number();
        }
        display_dropped_dices(dices);
        display_sum(sum(dices));
    }
    private static int generate_random_number(){
        return (int) ((Math.random() * 6) +1);
    }
    private static int sum(int[] dices){
        int sum = 0;
        for(int dice: dices){
            sum += dice;
        }
        return sum;
    }
    private static void display_dropped_dices(int[] dices ) {
        System.out.print("Выпавшие кости: \n");
        for (int dice:dices) {
            System.out.print(dice);
        }
    }
    private static void display_sum(int sum){
        System.out.print("Сумма выпавших очков на костях: " + sum);
    }
}

/**
 * @task Напишите программу, которая бы определяла, является ли введённая
 * буква гласной или согласной. Постарайтесь сделать данное задание
 * несколькими способами (чем больше, тем лучше). К примеру: с
 * использованием базовых операций, конструкции if-else, конструкции
 * switch и т.д.
 */
class Letter{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        char letter = scanner.next().toLowerCase().charAt(0);//нижний регистр
        if (!(Character.isLetter(letter))) {
            System.out.println("Ошибка: Введите только одну букву.");
            return;
        }
        System.out.println("IF-ELSE");
        if_else(letter);
        System.out.println("SWITCH-CASE");
        switch_case(letter);
        System.out.println("ARRAYS");
        arrays(letter);
        System.out.println("BOOL");
        bool(letter);
    }
    private static void if_else(char letter){
            if ("аеёиоуыэюя".indexOf(letter) != -1) {
                System.out.println(letter + " - это гласная буква (русский).");
            } else if ("aeiou".indexOf(letter) != -1) {
                System.out.println(letter + " - это гласная буква (английский).");
            } else {
                System.out.println(letter + " - это согласная буква.");
            }
    }
    private static void switch_case(char letter){
        switch (letter) {
            case 'а':
            case 'е':
            case 'ё':
            case 'и':
            case 'о':
            case 'у':
            case 'ы':
            case 'э':
            case 'ю':
            case 'я':
                System.out.println(letter + " - это гласная буква (русский).");
                break;
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(letter + " - это гласная буква (английский).");
                break;
            default:
                System.out.println(letter + " - это согласная буква.");
                break;
        }
}
    private static void arrays(char letter){
        char[] russianVowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        char[] englishVowels = {'a', 'e', 'i', 'o', 'u'};
        boolean isVowel = false;
        for (char vowel : russianVowels) {
            if (letter == vowel) {
                isVowel = true;
                break;
            }
        }
        for (char vowel : englishVowels) {
            if (letter == vowel) {
                isVowel = true;
                break;
            }
    }
        if (isVowel) {
            System.out.println(letter + " - это гласная буква.");
        } else {
            System.out.println(letter + " - это согласная буква.");
        }
    }
    private static void bool(char letter){
        boolean isVowel = "аеёиоуыэюя".indexOf(letter) != -1 || "aeiou".indexOf(letter) != -1;
        String result = isVowel ? "гласная" : "согласная";
        System.out.println(letter + " - это " + result + " буква.");
    }
}