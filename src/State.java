import java.util.ArrayList;

public class State {
    private String name;
    private ArrayList<County> counties;

    public State( ArrayList<Data[]> countyInfo, String name){
         this.name = name;
         counties = addAllCounties(countyInfo);
    }

    public String getName(){
        return this.name;
    }

    private ArrayList<County> addAllCounties(ArrayList<Data[]> data) {
        ArrayList<County> counties = new ArrayList<>();
        for(Data[] countyData: data){
            counties.add(new County(countyData));
        }
        return counties;
    }

    public void printState(){
        for (County county: counties) {
            System.out.println(county.getName());
            county.printCounty();
        }
    }
}
