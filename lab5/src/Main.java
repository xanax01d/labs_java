import java.util.Random;
/**
 * The Judges class helps simulate a competition where four judges rate participants.
 * Each participant receives a score from 0 to 100 (with one decimal place) from each judge.
 * The winner is determined based on the highest average score.
 */
class Judges{

    private static final int NUM_PARTICIPANTS = 30;
    private static final int NUM_JUDGES = 4;

    /**
     * Main method to simulate the competition and determine the winner.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args){
        double[][] scores = new double[NUM_PARTICIPANTS][NUM_JUDGES];
        double[] averageScores = new double[NUM_PARTICIPANTS];

        generateScores(scores);

    }
    /**
     * Generates random scores (0 to 100 with one decimal precision) for all participants.
     *
     * @param scores A 2D array to store the scores from judges for each participant
     */
    private static void generateScores(double[][] scores){
        Random random = new Random();
        for(int i = 0; i < scores.length; i++){
            for(int j = 0; j < scores[i].length; i++){
                scores[i][j] =  Math.round((random.nextDouble()*100)*10.0)/10.0;
            }
        }
    }

    private static void countAverages(double[][] scores, double[] averageScores){

    }
}

public class Main {
    public static void main(String[] args) {
    }
}
}