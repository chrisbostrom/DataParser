public class ElectionResult implements Data{
    private int demVotes;
    private int gopVotes;
    private int totalVotes;
    private String stateName;
    private String countyName;
    private int combinedFips;

    public ElectionResult(String[] data){
        this.demVotes = (int) Double.parseDouble(data[1]);
        this.gopVotes = (int) Double.parseDouble(data[2]);
        this.totalVotes = (int) Double.parseDouble(data[3]);
        this.stateName = data[8];
        this.countyName = data[9];
        this.combinedFips = (int) Double.parseDouble(data[10]);
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

    public String getStateName() {
        return stateName;
    }

    public String getCountyName() {
        return countyName;
    }

    public Object getDataType() {
        return this;
    }

    public int getFips() {
        return combinedFips;
    }

    public void setFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }

    @Override
    public String toString() {
        return "ElectionResult{" +
                "demVotes=" + demVotes +
                ", gopVotes=" + gopVotes +
                ", totalVotes=" + totalVotes +
//                ", percentDem=" + percentDem +
//                ", percentGop=" + percentGop +
//                ", percentDifference=" + percentDifference +
//                ", percentPointDifference=" + percentPointDifference + "%" +
//                ", stateAbbreviation='" + stateAbbreviation + '\'' +
//                ", countyName='" + countyName + '\'' +
//                ", combinedFips=" + combinedFips +
                '}';
    }
}
