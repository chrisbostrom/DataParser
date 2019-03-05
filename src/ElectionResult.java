public class ElectionResult {
    private int demVotes;
    private int gopVotes;
    private int totalVotes;
    private double percentDem;
    private double percentGop;
    private double percentDifference;
    private int percentPointDifference;
    private String stateAbbreviation;
    private String countyName;
    private int combinedFips;

    public ElectionResult(String[] data){
        this.demVotes = Integer.parseInt(data[0]);
        this.gopVotes = Integer.parseInt(data[1]);
        this.totalVotes = Integer.parseInt(data[2]);
        this.percentDem = Double.parseDouble(data[3]);
        this.percentGop = Double.parseDouble(data[4]);
        this.percentDifference = Double.parseDouble(data[5]);
        this.percentPointDifference = Integer.parseInt(data[6]);
        this.stateAbbreviation = data[7];
        this.countyName = data[8];
        this.combinedFips = Integer.parseInt(data[9]);
    }

    public int getDemVotes() {
        return demVotes;
    }

    public void setDemVotes(int demVotes) {
        this.demVotes = demVotes;
    }

    public int getGopVotes() {
        return gopVotes;
    }

    public void setGopVotes(int gopVotes) {
        this.gopVotes = gopVotes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public double getPercentDem() {
        return percentDem;
    }

    public void setPercentDem(double percentDem) {
        this.percentDem = percentDem;
    }

    public double getPercentGop() {
        return percentGop;
    }

    public void setPercentGop(double percentGop) {
        this.percentGop = percentGop;
    }

    public double getPercentDifference() {
        return percentDifference;
    }

    public void setPercentDifference(double percentDifference) {
        this.percentDifference = percentDifference;
    }

    public int getPercentPointDifference() {
        return percentPointDifference;
    }

    public void setPercentPointDifference(int percentPointDifference) {
        this.percentPointDifference = percentPointDifference;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCombinedFips() {
        return combinedFips;
    }

    public void setCombinedFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }

    @Override
    public String toString() {
        return "ElectionResult{" +
                "demVotes=" + demVotes +
                ", gopVotes=" + gopVotes +
                ", totalVotes=" + totalVotes +
                ", percentDem=" + percentDem +
                ", percentGop=" + percentGop +
                ", percentDifference=" + percentDifference +
                ", percentPointDifference=" + percentPointDifference +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                ", countyName='" + countyName + '\'' +
                ", combinedFips=" + combinedFips +
                '}';
    }
}
