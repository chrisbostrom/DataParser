import java.util.ArrayList;

/***
 * Main class for data parsers
 * @author chrisbostrom
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<ElectionResult> results = Utils.parse2016PresidentialResults("data/2016_Presidential_Results.csv");
        for (ElectionResult result: results) {
            System.out.println(result);
        }

    }
}

