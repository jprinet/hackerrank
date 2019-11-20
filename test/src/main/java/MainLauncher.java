import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainLauncher {

    private static final String PATH = "test/src/main/resources/";

    //    private static final Scanner scanner = new Scanner(System.in);
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

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = GridSearch.gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

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

