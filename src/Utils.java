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

    public static  ArrayList<UnemploymentData> parse2016UnemploymentData(String filepath){
        ArrayList<UnemploymentData> results = new ArrayList<>();
        int startingLine = 8;
        String[] cleanedLines = getCleanedData(filepath);

        for (int i = startingLine; i < cleanedLines.length; i++) {
            UnemploymentData result = new UnemploymentData(cleanedLines[i].split(","));
            results.add(result);
        }

        return results;
    }

    public static ArrayList<ElectionResult> parse2016PresidentialResults(String filepath){
        ArrayList<ElectionResult> results = new ArrayList<>();
        int startingLine = 1;
        String[] cleanedLines = getCleanedData(filepath);

        for (int i = startingLine; i < cleanedLines.length; i++) {
            ElectionResult result = new ElectionResult(cleanedLines[i].split(","));
            results.add(result);
        }

        return results;
    }

    public static ArrayList<EducationData> parse2016EducationData(String filepath){
        ArrayList<EducationData> results = new ArrayList<>();
        int startingLine = 5;
        String[] cleanedLines = getCleanedData(filepath);

        for (int i = startingLine; i < cleanedLines.length; i++) {
            EducationData result = new EducationData(cleanedLines[i].split(","));
            results.add(result);
        }

        return results;

    }

    private static String[] getCleanedData(String filepath) {
        String uncleanedData = readFileAsString(filepath);

        String[] uncleanedLines = uncleanedData.split("\n");

        return cleanLines(uncleanedLines);
    }

    private static String[] cleanLines(String[] uncleanedLines) {
        for(int i = 0; i < uncleanedLines.length; i++){
            String uncleanedLine = uncleanedLines[i];
            uncleanedLine = uncleanedLine.trim();
            uncleanedLine = removeUnnecessaryCommas(uncleanedLine);
            uncleanedLine = uncleanedLine.replaceAll("%", "");
            uncleanedLines[i] = uncleanedLine;
        }
        return uncleanedLines;
    }

    private static String removeUnnecessaryCommas(String uncleanedLine) {
        boolean isInQuotes = false;
        String[] separatedQuotedValues = uncleanedLine.split("\"");

        for(int i = 0; i < separatedQuotedValues.length; i++){
            if(isInQuotes){
                separatedQuotedValues[i] = separatedQuotedValues[i].replaceAll(",", "");

                isInQuotes = false;
            }

            else isInQuotes = true;
        }
        String cleanedLine = "";

        for(int i = 0; i < separatedQuotedValues.length; i++){
            cleanedLine += separatedQuotedValues[i];
        }

        return cleanedLine;
    }

}