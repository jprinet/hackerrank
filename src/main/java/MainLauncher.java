import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainLauncher {

    private static final String PATH = "src/main/resources/";

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new File(PATH + "input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH + System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = LeaderBoard.climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();

        System.out.println("processed in " + (System.currentTimeMillis() - startTime) + "ms");

        assertEquals();
    }

    private static void assertEquals() throws FileNotFoundException {
        Scanner scannerOutput = new Scanner(new File(PATH + "output.txt"));
        Scanner scannerExpected = new Scanner(new File(PATH + "expected.txt"));
        String expectedLine;
        int line = 1;
        while ((expectedLine = scannerExpected.next()) != null) {
            String outputLine = scannerOutput.next();
            if (!outputLine.equals(expectedLine)) {
                throw new IllegalStateException("ERROR LINE " + line + " - was [" + outputLine + "] expected [" + expectedLine + "]");
            }
            if (!scannerExpected.hasNext()) {
                break;
            }

            line++;
        }
    }
}

