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

    public double findSlope(double[] allXValues, double[] allYValues){//TODO
        double slope = 0;
        double b1 = findB1(allXValues, allYValues);
        double b0 = findB0(b1, allXValues, allYValues);
        double xMean = findXzMean(allXValues);
        System.out.println(b0 + "     " + b1);

        slope = b0 + (b1 * xMean);

        return slope;
    }

    private double findXzMean(double[] allXValues) {
        double sumAllX = 0;

        for (double x: allXValues) {
            sumAllX += x;
        }
        return sumAllX / allXValues.length;
    }

    private double findB0(double b1, double[] allXValues, double[] allYValues) {
        double sumAllX = 0;
        double sumAllY = 0;

        for (double x: allXValues) {
            sumAllX += x;
        }
        for (double y: allYValues) {
            sumAllY += y;
        }
        return (sumAllY - (sumAllX * b1)) / allXValues.length;
    }

    private double findB1(double[] allXValues, double[] allYValues) {
        double sumXSquared = 0;
        double sumAllX = 0;
        double sumAllXY = 0;
        double sumAllY = 0;

        for (double x: allXValues) {
            sumXSquared += x * x;
            sumAllX  += x;
            //System.out.println(sumAllX);
        }
        //System.out.println("done_________________________________________________");
        for (int i = 0; i < allYValues.length; i++){
            sumAllXY += allYValues[i];
            sumAllXY += allXValues[i] * allYValues[i];
        }

        double ssxx = sumXSquared - ((sumAllX * sumAllX) / allXValues.length);
        double ssxy = sumAllXY - ((sumAllX * sumAllY) / allXValues.length);


        return ssxy / ssxx;
    }

    public String getDataAsString(){
        String data = "State,Unemployed,Unemployment rate,Employed,HS diploma,Education Rate,Delinquency rate,Average household income,Slope education rate vs debt,Slope unemployment rate vs debt" + System.getProperty("line.separator");
        boolean isFirstLine = true;
        double[] unemploymentData = new double[states.size()];
        double[] educationData = new double[states.size()];
        double[] debtData = new double[states.size()];
        for (int i = 0; i < states.size(); i++){
            unemploymentData[i] = states.get(i).getUnemploymentRate();
            educationData[i] = states.get(i).getEducationRate();
            debtData[i] = states.get(i).getPercentDelinquency();
        }

        for (State state: states) {
            if(isFirstLine){
                data += state.getStateAsString() + "," + findSlope(unemploymentData, debtData) + "," + findSlope(educationData,debtData) + System.getProperty("line.separator");
                isFirstLine = false;
            }
            else{
                data += state.getStateAsString() + System.getProperty("line.separator");
            }

        }
        return data;
    }

    public void writeFileAsCSV(String data){
        Utils.writeDataToFile("data/deliverable.csv", data);
    }
}