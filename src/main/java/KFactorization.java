class KFactorization {

    static class ResultHolder {
        java.util.List<Integer> bestCandidate = java.util.Collections.emptyList();

        void setBestCandidate(java.util.List<Integer> bestCandidate) {
            this.bestCandidate = bestCandidate;
        }

        int[] getBestCandidateExpression() {
            if (bestCandidate.isEmpty()) {
                return new int[]{-1};
            }
            int[] expression = new int[bestCandidate.size() + 1];
            expression[0] = 1;
            for (int i = 0; i < bestCandidate.size(); i++) {
                expression[i + 1] = expression[i] * bestCandidate.get(i);
            }
            return expression;
        }

        boolean isBetter(java.util.List<Integer> candidate) {
            if (bestCandidate.isEmpty() || candidate.size() < bestCandidate.size()) {
                return true;
            }

            if (candidate.size() == bestCandidate.size()) {
                for (int i = 0; i < candidate.size(); i++) {
                    if (candidate.get(i) > bestCandidate.get(i)) {
                        return false;
                    } else if (candidate.get(i) < bestCandidate.get(i)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    static int[] kFactorization(int n, int[] A) {
        ResultHolder resultHolder = new ResultHolder();

        java.util.List<Integer> input = java.util.Arrays.stream(A).sorted().boxed().collect(java.util.stream.Collectors.toList());

        java.util.List<Integer> currentCandidate = new java.util.ArrayList<>();
        getCandidates(input, 0, 0, n, currentCandidate, resultHolder);

        return resultHolder.getBestCandidateExpression();
    }

    static void getCandidates(java.util.List<Integer> input, int currentIndex, long currentTotal, long expectedTotal, java.util.List<Integer> currentCandidate, ResultHolder resultHolder) {
        long currentTry = currentTotal > 0 ? currentTotal * input.get(currentIndex) : input.get(currentIndex);

        if (currentTry == expectedTotal) {
            // candidate found!
            currentCandidate.add(input.get(currentIndex));
            if (resultHolder.isBetter(currentCandidate)) {
                resultHolder.setBestCandidate(currentCandidate);
            }
        } else if (currentTry < expectedTotal) {
            if (currentIndex + 1 < input.size()) {
                if (resultHolder.isBetter(currentCandidate)) {
                    // try with next item
                    getCandidates(input, currentIndex + 1, currentTotal, expectedTotal, new java.util.ArrayList<>(currentCandidate), resultHolder);

                    // add current item
                    currentCandidate.add(input.get(currentIndex));

                    // try with current item again
                    getCandidates(input, currentIndex, currentTry, expectedTotal, new java.util.ArrayList<>(currentCandidate), resultHolder);

                    // try with remaining elements
                    for (int i = currentIndex + 1; i < input.size(); i++) {
                        getCandidates(input, i, currentTry, expectedTotal, new java.util.ArrayList<>(currentCandidate), resultHolder);
                    }
                }
            }
        }
    }

}


