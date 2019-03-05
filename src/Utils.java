import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parse2016PresidentialResults(String filepath){
        ArrayList<ElectionResult> results = new ArrayList<>();
        String uncleanedData = readFileAsString(filepath);

        String[] uncleanedLines = uncleanedData.split("\n");


        String[] cleanedLines = cleanLines(uncleanedLines);

        for (int i = 1; i < cleanedLines.length; i++) {
            ElectionResult result = new ElectionResult(cleanedLines[i].split(","));
            results.add(result);
        }
        return results;
    }

    private static String[] cleanLines(String[] uncleanedLines) {
        for(int i = 0; i < uncleanedLines.length; i++){
            String uncleanedLine = uncleanedLines[i];
            uncleanedLine = removeNestedCommas(uncleanedLine);
            uncleanedLine = uncleanedLine.replaceAll("%", "");
            uncleanedLines[i] = uncleanedLine;
        }
        return uncleanedLines;
    }

    private static String removeNestedCommas(String uncleanedLine) {
        boolean isNested = false;
        String[] seperatedcommas = uncleanedLine.split("\"");

        for(int i = 0; i < seperatedcommas.length; i++){
            if(isNested){
                seperatedcommas[i] = seperatedcommas[i].replaceAll(",", "");

                isNested = false;
            }

            else isNested = true;
        }
        String cleanedLine = seperatedcommas[0];

        for(int i = 1; i < seperatedcommas.length; i++){
            cleanedLine += seperatedcommas[i];
        }

        return cleanedLine;
    }

}