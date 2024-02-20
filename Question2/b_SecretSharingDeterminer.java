package Question2;

import java.util.ArrayList;
import java.util.List;

public class b_SecretSharingDeterminer {
    public static void main(String[] args) {
        int totalPeople = 5;
        int[][] sharingIntervals = {{0, 2}, {1, 3}, {2, 4}};
        int startingPerson = 0;

        List<Integer> finalPeople = getPeopleWhoKnowSecret(totalPeople, sharingIntervals, startingPerson);
        System.out.println(finalPeople);
    }

    public static List<Integer> getPeopleWhoKnowSecret(int totalPeople, int[][] sharingIntervals, int startingPerson) {
        boolean[] knowsSecret = new boolean[totalPeople];
        knowsSecret[startingPerson] = true;

        for (int[] interval : sharingIntervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                if (knowsSecret[i]) {
                    for (int j = interval[0]; j <= interval[1]; j++) {
                        knowsSecret[j] = true;
                    }
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < totalPeople; i++) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
