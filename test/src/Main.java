import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр Random для генерации случайных чисел
        Random random = new Random();

        // Генерируем случайное число от 1 до 5
        int moodValue = random.nextInt(5) + 1;

        // Определяем настроение на основе случайного числа
        String moodFace;

        switch (3) {
            case 1:{
                moodFace = "😢"; // Грустное лицо

            }
            case 2:{
                moodFace = "😐"; // Нейтральное лицо

            }
            case 3:{
                moodFace = "😊"; // Счастливое лицо
            }
            case 4:{
                moodFace = "😄"; // Очень счастливое лицо
            }
            case 5:{
                moodFace = "😡"; // Раздосадованное лицо
            }
            default:{
                moodFace = "🤔"; // Неизвестное настроение
            }
        }

        // Выводим настроение на экран
        System.out.println("Ваше текущее настроение: " + moodFace);
    }
}
