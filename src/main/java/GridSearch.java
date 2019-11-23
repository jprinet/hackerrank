public class GridSearch {

    static String gridSearch(String[] G, String[] P) {
        int tokenLength = P[0].length();
        for (int i = 0; i <= G.length - P.length; i++) {
            int currentIndexStart = 0;
            while ((currentIndexStart = G[i].indexOf(P[0], currentIndexStart)) != -1) {
                boolean found = false;
                for (int j = 1; j < P.length; j++) {
                    String currentLine = G[i + j];
                    if (!P[j].equals(currentLine.substring(currentIndexStart, currentIndexStart + tokenLength))) {
                        break;
                    }
                    if (j == P.length - 1) {
                        found = true;
                    }
                }
                if (found) {
                    return "YES";
                }
                currentIndexStart++;
            }
        }
        return "NO";
    }

}
