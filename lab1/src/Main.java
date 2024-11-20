/**
 * @author xanax01d
 * @laboratoryWorkNumber 1
 * @subject ToPMP
 */
import java.util.Scanner;
public class Main {

    /**
     * @task Ввести с клавиатуры 2 числа (a и b).
     * Выполнить над ними:
     *    @operation Сложение,
     *    @operation Вычитание,
     *    @operation Умножение,
     *    @operation Деление.
     * @task Посчитать выражение: √a + b³ * π.
     * @task Вывести результаты на экран.
     */
    public static void MainTask(){
        Scanner in = new Scanner(System.in);
        System.out.print("a = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();
        double result = Math.sqrt(a) + Math.pow(b,3) * Math.PI;
        System.out.println(
                "a+b = " + (a+b) +
                        "\na-b = " + (a-b) +
                        "\nb-a = " + (b-a) +
                        "\na*b = " + (a*b) +
                        "\na/b = " + (a/b) +
                        "\nb/a = " + (b/a) +
                        "\nsqrt(a)+b^3*pi = " + result
        );
    }

    /**
     * @problemSetting Масса динозавра задаётся в граммах.
     * @task Разработайте программу, которая вычисляет, сколько это килограммов, центнеров и т.д.
     */
    public static void Dinosaur(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите массу динозавра (в граммах): ");
        int massOfDinosaur = in.nextInt();
        double massOfDinosaurInKilograms = (double) massOfDinosaur / 1000;
        double massOfDinosaurInCenters = massOfDinosaurInKilograms / 100;
        double massOfDinosaurInTons = massOfDinosaurInCenters /10;
        System.out.println(
                "Масса динозавра в килограммах: " + massOfDinosaurInKilograms +
                        "\nМасса динозавра в центнерах: "+ massOfDinosaurInCenters +
                        "\nМасса динозавра в тоннах: " + massOfDinosaurInTons
        );
    }

    /**
     * @problemSetting Дан общий размер файла в байтах (размер задаётся в виде целого числа).
     * @task Разработайте программу, которая вычисляет, сколько это килобайтов, мегабайтов и т.д.
     */
    public static void File(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер файла в килобайтах: ");
        int sizeOfFileInBytes = in.nextInt();
        double sizeOfFileInKilobytes = (double) sizeOfFileInBytes / 1024;
        double sizeOfFileInMegabytes = sizeOfFileInKilobytes / 1024;
        double sizeOfFileInGigabytes = sizeOfFileInMegabytes / 1024;
        double sizeOfFileInTerabytes = sizeOfFileInGigabytes / 1024;
        System.out.println(
                "Размер файла в килобайтах: " + sizeOfFileInKilobytes +
                        "\nРазмер файла в мегабайтах: " + sizeOfFileInMegabytes +
                        "\nРазмер файла в гигабайтах: " + sizeOfFileInGigabytes +
                        "\nРазмер файла в терабайтах:"+ sizeOfFileInTerabytes
        );
    }

    /**
     * @problemSetting Значение расстояния между двумя городами задаётся в сантиметрах.
     * @task Разработайте программу, которая вычисляет, сколько это километров и метров.
     */
    public static void Distance(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите расстояние между двумя городами в сантиметрах: ");
        double distance = in.nextDouble();
        double distanceInMeters = distance / 100;
        double distanceInKilometers = distanceInMeters / 1000;
        System.out.println(
                "Расстояние между двумя городами в метрах = " + distanceInMeters +
                        "\nРасстояние между двумя городами в километрах: " + distanceInKilometers);
    }

    /**
     * @problemSetting Даны две переменные A и B
     * @task Попробуйте разработать программу, которая меняет местами
     * содержимое двух переменных a и b, не используя для этого дополнительные
     * переменные
     */
    public static void ChangeVariables(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите переменную A: ");
        int a = in.nextInt();
        System.out.print("Введите переменную B: ");
        int b = in.nextInt();
        System.out.println("До смены значений переменных: ");
        System.out.println("A = "+a+"\nB = "+b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("После смены значений переменных: ");
        System.out.println("A = "+a+"\nB = "+b);
    }

    /**
     * @problemSetting Дано: Вес шоколадных конфет, стоимость данных конфет по заданному весу,
     * Вес желатиновых конфет, стоимость данных конфет по заданному весу
     * @task Разработать программу вычисления того, сколько стоит один кг
     * шоколадных конфет и 1 один кг желатиновых конфет, а также во сколько раз
     * шоколадные конфеты дороже (дешевле) желатиновых конфет
     */
    public static void Candies(){
        Scanner in = new Scanner(System.in);
        double massOfChocolateCandies, massOfGelatinCandies,
                priceOfChocolateCandiesPerOneKilo,priceOfGelatinCandiesPerOneKilo,
                priceOfChocolateCandiesPerXKilos,priceOfGelatinCandiesPerYKilo;

        System.out.print("Введите массу шоколадных конфет (в килограммах): ");
        massOfChocolateCandies = in.nextDouble();
        System.out.print("Введите стоимость шоколадных конфет массой " + massOfChocolateCandies + " кг.: ");
        priceOfChocolateCandiesPerXKilos = in.nextDouble();
        priceOfChocolateCandiesPerOneKilo = priceOfChocolateCandiesPerXKilos / massOfChocolateCandies;

        System.out.print("Введите массу желатиновых конфет (в килограммах): ");
        massOfGelatinCandies = in.nextDouble();
        System.out.print("Введите стоимость желатиновых конфет массой "+ massOfGelatinCandies + "кг.: ");
        priceOfGelatinCandiesPerYKilo = in.nextDouble();
        priceOfGelatinCandiesPerOneKilo = priceOfGelatinCandiesPerYKilo / massOfGelatinCandies;
        System.out.print("Стоимость шоколадных конфет за 1 кг.: "+ priceOfChocolateCandiesPerOneKilo + "бел. руб." +
                "\nСтоимость желатиновых конфет за 1 кг.:" + priceOfGelatinCandiesPerOneKilo + "бел. руб.\n");
        if (priceOfChocolateCandiesPerOneKilo > priceOfGelatinCandiesPerOneKilo){
            System.out.println("Шоколадные конфеты дороже желатиновых в "+ priceOfChocolateCandiesPerOneKilo/priceOfGelatinCandiesPerOneKilo + " раз");
        }
        else if (priceOfChocolateCandiesPerOneKilo < priceOfGelatinCandiesPerOneKilo){
            System.out.println("Шоколадные конфеты дешевле желатиновых в "+ priceOfGelatinCandiesPerOneKilo/priceOfChocolateCandiesPerOneKilo + " раз");
        }
        else{
            System.out.println("Шоколадные и желатиновые конфеты стоят одинаково.");
        }
    }

    /**
     * Главный / основной метод, служащий точкой входа в программу.
     * Предоставляет меню для выбора задания пользователем.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int select;
        do{
            System.out.println("--------------Меню--------------");
            System.out.print("1.Основное задание\n2.Масса динозавра\n3.Размер файла\n4.Дистанция\n5.Смена значений переменных\n6.Конфеты\n0.Выход\nВыберите задание: ");
            select = in.nextInt();
            System.out.println("--------------------------------");
            switch (select) {
                case (1):
                    MainTask();
                    break;
                case (2):
                    Dinosaur();
                    break;
                case (3):
                    File();
                    break;
                case (4):
                    Distance();
                    break;
                case (5):
                    ChangeVariables();
                    break;
                case (6):
                    Candies();
                    break;
            }
        } while (select != 0);
    }
}