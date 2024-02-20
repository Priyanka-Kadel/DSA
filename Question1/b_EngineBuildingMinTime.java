package Question1;
import java.util.PriorityQueue;

public class b_EngineBuildingMinTime {
    public static int findMinBuildTime(int[] engines, int splitTime) {
        PriorityQueue<Integer> constructionQueue = new PriorityQueue<>();

        for (int engine : engines) {
            constructionQueue.offer(engine);
        }

        while (constructionQueue.size() > 1) {
            int fastestEngine = constructionQueue.poll();
            int secondFastestEngine = constructionQueue.poll();
            int newEngineTime = secondFastestEngine + splitTime;
            constructionQueue.offer(newEngineTime);
        }
        return constructionQueue.poll();
    }

    public static void main(String[] args) {
        int[] engines = {5, 3, 7, 2, 8};
        int splitTime = 4;

        int totalTime = findMinBuildTime(engines, splitTime);

        System.out.println("Minimum time needed to build all engines: " + totalTime);
    }
}




