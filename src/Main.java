/***
 * Main class for data parsers
 * @author chrisbostrom
 */
public class Main {
    public static void main(String[] args) {

        DataManager US = new DataManager("data/statesData.csv");
        US.writeFileAsCSV(US.getDataAsString());

    }
}

