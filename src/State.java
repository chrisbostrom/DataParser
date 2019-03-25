public class State {
    private String name;
    private int numUnemployed;
    private int numEmployed;
    private int numHSDiploma;
    private double percentDelinquency;
    private int householdIncome;

    public State(String[] data){
         name = data[0];
         numUnemployed = Integer.parseInt(data[1]);
         numEmployed = Integer.parseInt(data[2]);
         numHSDiploma = Integer.parseInt(data[3]);
         percentDelinquency = Double.parseDouble(data[4]);
         householdIncome = Integer.parseInt(data[5]);
        System.out.println("constructing state");
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
}
