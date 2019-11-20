import java.util.ArrayList;
import java.util.List;

public class GridSearch {

    static String gridSearch(String[] G, String[] P) {
        int tokenLength = P[0].length();
        for (int i = 0; i < G.length - P.length; i++) {
//            int currentIndexStart = 0;
//            while((currentIndexStart = G[i].indexOf(P[0], currentIndexStart)) != -1){
//
//            }
            List<Integer> patternIndexStarts = getPatternIndexStarts(G[i], P[0]);
            for (int currentPatternIndexStart : patternIndexStarts) {
                boolean found = false;
                for (int j = 1; j < P.length; j++) {
                    String currentLine = G[i + j];
//                    if (currentLine.indexOf(P[j], currentPatternIndexStart) != currentPatternIndexStart) {
                    if (!P[j].equals(currentLine.substring(currentPatternIndexStart, currentPatternIndexStart + tokenLength))) {
                        break;
                    }
                    if (j == P.length - 1) {
                        found = true;
                    }
                }
                if (found) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static List<Integer> getPatternIndexStarts(String currentLine, String patternLine) {
        List<Integer> patternIndexStarts = new ArrayList<>();
        int currentIndexStart = 0;
        while (true) {
            currentIndexStart = currentLine.indexOf(patternLine, currentIndexStart);
            if (currentIndexStart == -1) {
                break;
            }
            patternIndexStarts.add(currentIndexStart);
            currentIndexStart++;
        }

        return patternIndexStarts;
    }
}
