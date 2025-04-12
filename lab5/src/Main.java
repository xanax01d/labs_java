/**
 * @author xanax01d
 * @LaboratoryWorkNumber 5
 * @Subject ToPMP
 */


import java.util.Random;
public class Main{
    public static void main(String[] args){
        Judges.main(args);
    }
}
/**
 * The Judges class helps simulate a competition where four judges rate participants.
 * Each participant receives a score from 0 to 100 (with one decimal place) from each judge.
 * The winner is determined based on the highest average score.
 */
class Judges {

    private static final int NUM_PARTICIPANTS = 30;
    private static final int NUM_JUDGES = 4;

    /**
     * Main method to simulate the competition and determine the winner.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        double[][] scores = new double[NUM_PARTICIPANTS][NUM_JUDGES];
        double[] averageScores = new double[NUM_PARTICIPANTS];

        generateScores(scores);
        countAverages(scores,averageScores);
        int winnerIndex = findWinner(averageScores);
        System.out.println("Результаты соревнований:");
        for (int i = 0; i < NUM_PARTICIPANTS; i++) {
            System.out.printf("Участник %d: Средняя оценка = %.1f\n", i + 1, averageScores[i]);
        }
        System.out.printf("\nПобедитель: Участник %d с средней оценкой: %.1f\n",
                winnerIndex + 1, averageScores[winnerIndex]);
    }

    /**
     * Generates random scores (0 to 100 with one decimal precision) for all participants.
     *
     * @param scores A 2D array to store the scores from judges for each participant
     */
    private static void generateScores(double[][] scores) {
        Random random = new Random();
        for (int i = 0; i < scores.length; i++) { // Iterate over participants
            for (int j = 0; j < scores[i].length; j++) { // Iterate over judges
                scores[i][j] = Math.round((random.nextDouble() * 100) * 10.0) / 10.0;
            }
        }
    }

    /**
     * Calculates the average scores for each participant based on the judges' scores.
     *
     * @param scores        A 2D array containing scores from judges for each participant
     * @param averageScores An array to store the calculated average scores
     */
    private static void countAverages(double[][] scores, double[] averageScores) {
        for (int i = 0; i < scores.length; i++) {
            double total = 0;
            for (int j = 0; j < scores[i].length; j++) {
                total += scores[i][j];
            }
            averageScores[i] = total / scores[i].length;
        }
    }
    /**
     * Finds the index of the participant with the highest average score.
     *
     * @param averageScores An array containing the average scores of participants
     * @return The index of the participant with the highest average score
     */
    private static int findWinner(double[] averageScores) {
        int winnerIndex = 0;
        double highestScore = averageScores[0];
        for (int i = 0; i < averageScores.length; i++) {
            if (averageScores[i] > highestScore) {
                highestScore = averageScores[i];
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
}
