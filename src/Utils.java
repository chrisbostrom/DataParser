import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    public static void writeDataToFile(String filePath, String data) {
        File outFile = new File(filePath);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))){
            writer.write(data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<State> parseData(String filepath){
        ArrayList<State> states = new ArrayList<>();
        int startingLine = 1;
        String[] cleanedLines = getCleanedData(filepath);

        for (int i = startingLine; i < cleanedLines.length; i++) {
            State state = new State(cleanedLines[i].split(","));
            states.add(state);
        }

        return states;
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