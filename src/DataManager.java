import java.util.ArrayList;

public class DataManager {
    private ArrayList<State> states;

    public DataManager(String filepath){
        this.states = Utils.parseData(filepath);
    }

    public ArrayList<State> getStates(){
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public State getState(String stateName){
        for (State state: states) {
            if(state.getName().equals(stateName)) {
                return state;
            }
        }
        System.out.println("state not found");
        return null;
    }

    public double[] getChiSquared(ArrayList<State> states){//TODO
        double[] chiSquared = new double[0];

        return chiSquared;
    }

    public String getDataAsString(ArrayList<State> states, double[] chiSquared){//TODO
        String data = "";
        return data;
    }

    public void writeFileAsCSV(String data){
        Utils.writeDataToFile("data/deliverable.csv", data);
    }
}