import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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

        int t = Integer.parseInt(scanner.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());

                List<String> passwords = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                                               .collect(toList());

                String loginAttempt = scanner.nextLine();

                String result = PasswordCracker.passwordCracker(passwords, loginAttempt);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

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

