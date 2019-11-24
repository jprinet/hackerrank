import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class LeaderBoard {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] leaderboardProgression = new int[alice.length];

        Object[] orderedScores = Arrays.stream(scores)
                                       .boxed()
                                       .distinct()
                                       .sorted(Comparator.reverseOrder())
                                       .toArray();

        for (int i = 0; i < alice.length; i++) {
            int index = Arrays.binarySearch(orderedScores, alice[i], Collections.reverseOrder());
            if (index < 0) {
                leaderboardProgression[i] = Math.abs(index);
            } else {
                leaderboardProgression[i] = index + 1;
            }
        }

        return leaderboardProgression;
    }
}
