import java.util.ArrayList;

public class DataManager {
    private ArrayList<State> states;

    public DataManager(String electionFilepath, String educationFilepath, String unemploymentFilepath){
        ArrayList<ElectionResult> votes2016 = Utils.parse2016PresidentialResults(electionFilepath);
        ArrayList<EducationData> educ2016 = Utils.parse2016EducationData(educationFilepath);
        ArrayList<UnemploymentData> employ2016 = Utils.parse2016UnemploymentData(unemploymentFilepath);
        ArrayList<Data[]> allCountyInfo = getCorrespondingCountyInfo(votes2016, educ2016, employ2016);
        this.states = splitAllCountiesByState(allCountyInfo);

    }

    private ArrayList<State> splitAllCountiesByState(ArrayList<Data[]> allCountyInfo) {
        ArrayList<State> states = new ArrayList<>();
        ArrayList<Data[]> countiesInState = new ArrayList<>();
        String lastStateName = allCountyInfo.get(0)[0].getStateName();
        String currentStateName;

        for(Data[] countyInfo: allCountyInfo){
            currentStateName = countyInfo[0].getStateName();
            if(!lastStateName.equals(currentStateName)){
                State state = new State(countiesInState, countyInfo[2].getStateName());
                states.add(state);
                countiesInState.clear();
                countiesInState.add(countyInfo);
                lastStateName = currentStateName;
                System.out.println("storing states");
            }
            else{
                countiesInState.add(countyInfo);
            }
        }
        return states;
    }

    private ArrayList<Data[]> getCorrespondingCountyInfo(ArrayList<ElectionResult> votes2016, ArrayList<EducationData> educ2016, ArrayList<UnemploymentData> employ2016) {
        ArrayList<Data[]> allCountyInfo = new ArrayList<>();

        for (ElectionResult countyElection: votes2016) {
            int fips = countyElection.getFips();
            EducationData countyEducation = findEucationForCounty(fips, educ2016);
            UnemploymentData countyEmployment = findEmploymentForCounty(fips, employ2016);

            if(!(countyEducation == null) && !(countyEmployment == null) && countyEducation.dataExists() && countyEmployment.dataExists()) {
                Data[] countyInfo = new Data[3];
                countyInfo[0] = countyElection;
                countyInfo[1] = countyEducation;
                countyInfo[2] = countyEmployment;

                allCountyInfo.add(countyInfo);
            }
        }
        System.out.println(allCountyInfo.size());
        return allCountyInfo;
    }

    private EducationData findEucationForCounty(int fips, ArrayList<EducationData> educ2016) {
        for(EducationData countyEduc: educ2016){
            if(countyEduc.getFips() == fips) return countyEduc;
        }
        System.out.println(fips);
        return null;
    }

    private UnemploymentData findEmploymentForCounty(int fips, ArrayList<UnemploymentData> employ2016) {
        for(UnemploymentData countyEmploy: employ2016){
            if(countyEmploy.getFips() == fips) return countyEmploy;
        }
        return null;
    }

    public void printAll(){
        System.out.println(states.size());
        for(State state: states){
            System.out.println(state.getName());
            state.printState();
        }
    }
}