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
        String currentStateName = allCountyInfo.get(0)[0].getStateName();

        for(Data[] countyInfo: allCountyInfo){
            if(!lastStateName.equals(currentStateName)){
                State state = new State(countiesInState, lastStateName);
                states.add(state);
                countiesInState.clear();
                countiesInState.add(countyInfo);
                lastStateName = currentStateName;
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

            Data[] countyInfo = new Data[3];
            countyInfo[0] = countyElection;
            countyInfo[1] = countyEducation;
            countyInfo[2] = countyEmployment;

            allCountyInfo.add(countyInfo);
        }
        return allCountyInfo;
    }

    private EducationData findEucationForCounty(int fips, ArrayList<EducationData> educ2016) {
        for(EducationData countyEduc: educ2016){
            if(countyEduc.getFips() == fips) return countyEduc;
        }
        return null;
    }

    private UnemploymentData findEmploymentForCounty(int fips, ArrayList<UnemploymentData> employ2016) {
        for(UnemploymentData countyEmploy: employ2016){
            if(countyEmploy.getFips() == fips) return countyEmploy;
        }
        return null;
    }
}