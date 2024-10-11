/**
 * @author xanax01d
 * @laboratoryWorkNumber 2
 * @subject ToPMP
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static void print_divider(){
        System.out.print("---------------------------------\n");
    }
    public static void main(String[] args) throws InterruptedException {
        Dragon.main(args);
        print_divider();
        TheGreatest.main(args);
        print_divider();
        MoodSensor.main(args);
        print_divider();
        Dice.main(args);
        print_divider();
        Letter.main(args);
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
        int max = max(numbers);
        int min = min(numbers);
        display_results(max,min);
    }
    private static int[] get_numbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа (через запятую): ");
        String input = scanner.nextLine();
        String[] stringNums = input.split(",");
        return(Arrays.stream(stringNums)
                .map(String::trim) //RIP пробелы
                .mapToInt(Integer::parseInt)//Конвертим в инт
                .toArray());
    }
    private static int max(int[] numbers){
        return Arrays.stream(numbers).max().orElseThrow();
    }
    private static int min(int[] numbers){
        return Arrays.stream(numbers).min().orElseThrow();
    }
    private static void display_results(int max, int min){
        if (min != max){
            System.out.print("Наибольшее число: " + max + "\nНаименьшее число :" + min + "\n");
        } else {
            System.out.print("Все числа равны.\n");
        }
    }
}

/** @task Напишите программу «Mood Sensor» (эмулировать датчика настроения),
 * которая «залазит» в душу пользователя и определяет его настроение в
 * текущий момент времени. Приложение будет генерировать случайное
 * число, в зависимости от значения которого на экран выводится одно из
 * псевдографических «лиц», которое и будет отображать настроение
 * пользователя.
 */
class MoodSensor{
    public static void main(String[] args) throws InterruptedException {
        display_evangelion_reference();
        compare_mood(get_mood(generate_random_number()));
    }
    private static void display_ellipsis () throws InterruptedException{
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.print("\n");
    }
    private static int generate_random_number(){
        return (int) ((Math.random() * 5) +1);
    }
    private static void display_evangelion_reference() throws InterruptedException{
        //Из-за того, что ты ненавидишь себя, никто тебя не уважает.
        //Rei Ayanami, Episode №26: Take Care of Yourself
        System.out.print("Поднимаем набор суперкомпьютеров Magi - 01");
        display_ellipsis();
        System.out.print("Поднимаем Magi - 1 (Мельхиор)");
        display_ellipsis();
        System.out.print("Поднимаем Magi - 2 (Бальтазар)");
        display_ellipsis();
        System.out.print("Поднимаем Magi - 3 (Каспер / -ар)");
        display_ellipsis();
        System.out.print("Компьютеры системы Magi дискутируют между собой");
        display_ellipsis();
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
                System.out.print("Система Маги не смогли определиться с вашим настроением, что вы за человек такой?");
            } else {
                System.out.print("Ваше настроение по решению системы Маги: " + mood + "\n");
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
    public static void main(String[] args) throws InterruptedException{
        int[] dices = new int[2];
        System.out.print("Бросаем кости");
        display_ellipsis();
        for(int i = 0; i < 2; i++){
            dices[i] = generate_random_number();
        }
        display_dropped_dices(dices);
        display_sum(sum(dices));
    }
    private static int generate_random_number(){
        return (int) ((Math.random() * 6) +1);
    }
    private static void display_ellipsis () throws InterruptedException{
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.print("\n");
    }
    private static int sum(int[] dices){
        return Arrays.stream(dices).sum();
    }
    private static void display_dropped_dices(int[] dices ) {
        System.out.print("Выпавшие кости: \n");
        for (int i = 0; i < 2; i++) {
            System.out.print(dices[i]);
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