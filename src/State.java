public class State {
    private String name;
    private int numUnemployed;
    private double unemploymentRate;
    private int numEmployed;
    private int numHSDiploma;
    private double educationRate;
    private double percentDelinquency;
    private int householdIncome;

    public State(String[] data){
         name = data[0];
         numUnemployed = Integer.parseInt(data[1]);
         unemploymentRate = Double.parseDouble(data[2]);
         numEmployed = Integer.parseInt(data[3]);
         numHSDiploma = Integer.parseInt(data[4]);
         educationRate = Double.parseDouble(data[5]);
         percentDelinquency = Double.parseDouble(data[6]);
         householdIncome = Integer.parseInt(data[7]);
    }

    public double getUnemploymentRate() {
        return unemploymentRate;
    }

    public double getEducationRate() {
        return educationRate;
    }

    public String getName(){
        return name;
    }

    public int getNumUnemployed() {
        return numUnemployed;
    }

    public int getNumEmployed() {
        return numEmployed;
    }

    public int getNumHSDiploma() {
        return numHSDiploma;
    }

    public double getPercentDelinquency() {
        return percentDelinquency;
    }

    public int getHouseholdIncome() {
        return householdIncome;
    }

    public String getStateAsString(){
        return name + "," + numUnemployed + "," + unemploymentRate + "," + numUnemployed + "," + numHSDiploma + "," + educationRate + "," + percentDelinquency + "," + householdIncome;
    }
}
