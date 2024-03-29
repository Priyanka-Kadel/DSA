package Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a_MedianScoreCalculator {
    private List<Double> scores;

    public a_MedianScoreCalculator() {
        scores = new ArrayList<>();
    }

    public void addScore(double newScore) {
        scores.add(newScore);
    }

    public double getMedianScore() {
        List<Double> sortedScores = new ArrayList<>(scores);
        Collections.sort(sortedScores);
        int count = sortedScores.size();
        if (count == 0) {
            return 0;
        } else if (count % 2 == 0) {
            int mid = count / 2;
            return (sortedScores.get(mid - 1) + sortedScores.get(mid)) / 2.0;
        } else {
            return sortedScores.get(count / 2);
        }
    }

    public static void main(String[] args) {
        a_MedianScoreCalculator scoreTracker = new a_MedianScoreCalculator();
        scoreTracker.addScore(85.5); // Stream: [85.5]
        scoreTracker.addScore(92.3); // Stream: [85.5, 92.3]
        scoreTracker.addScore(77.8); // Stream: [85.5, 92.3, 77.8]
        scoreTracker.addScore(90.1); // Stream: [85.5, 92.3, 77.8, 90.1]
        double median1 = scoreTracker.getMedianScore(); // Output: 87.8
        System.out.println("Median 1: " + median1);

        scoreTracker.addScore(81.2); // Stream: [85.5, 92.3, 77.8, 90.1, 81.2]
        scoreTracker.addScore(88.7); // Stream: [85.5, 92.3, 77.8, 90.1, 81.2, 88.7]
        double median2 = scoreTracker.getMedianScore(); // Output: 87.1
        System.out.println("Median 2: " + median2);
    }
}
