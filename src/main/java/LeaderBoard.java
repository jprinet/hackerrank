class LeaderBoard {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] leaderboardProgression = new int[alice.length];

        java.util.List<Integer> orderedScores = java.util.Arrays.stream(scores)
                                                                .boxed()
                                                                .distinct()
                                                                .sorted(java.util.Comparator.reverseOrder())
                                                                .collect(java.util.stream.Collectors.toList());

        for (int i = 0; i < alice.length; i++) {
            int currentRank = 1;
            for (Integer highScore : orderedScores) {
                if (alice[i] >= highScore) {
                    break;
                } else {
                    currentRank++;
                }
            }
            leaderboardProgression[i] = currentRank;
        }

        return leaderboardProgression;
    }
}
