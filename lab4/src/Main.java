/**
 * @author xanax01d
 * @LaboratoryWorkNumber 4
 * @Subject ToPMP
 * @Tasks Grades array, Caesar cypher, Sort
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Grades.main(args);
        //CaesarCypher.main(args);
    }
}

class Sort{
    public static void main(String[] args){}
    static int[] frequencySort(int[] arr){}
    
}

class Grades{
    public static void main(String[] args){
        int[] array = InitializeArray();
        Passed(array,GetAverageMark(array));
    }
    static int[] InitializeArray(){
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
    static double GetAverageMark(int[] array){
        double sum = 0;
        for(int grade: array){
            sum += grade;
        }
        double averageMark = sum/10;
        System.out.println("Средняя отметка (не округленная) = " + averageMark +
                "\nОкругленная средняя отметка = " + Math.round(averageMark));
        return Math.round(averageMark);
    }
    static void Passed(int[] array, double averageMark){
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
    static char[] Encrypt(char[] input, int shift){
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
    static void PrintArray(char[] array){
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}