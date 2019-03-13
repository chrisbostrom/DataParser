public class County {
    private String name;
    private int fibs;
    private EducationData educ2016;
    private ElectionResult vote2016;
    private UnemploymentData employ2016;

    public County(Data[] data){
        name = data[1].getCountyName();
        fibs = data[0].getFips();
        vote2016 = (ElectionResult)data[0];
        educ2016 = (EducationData)data[1];
        employ2016 = (UnemploymentData)data[2];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFibs() {
        return fibs;
    }

    public void setFibs(int fibs) {
        this.fibs = fibs;
    }

    public EducationData getEduc2016() {
        return educ2016;
    }

    public void setEduc2016(EducationData educ2016) {
        this.educ2016 = educ2016;
    }

    public ElectionResult getVote2016() {
        return vote2016;
    }

    public void setVote2016(ElectionResult vote2016) {
        this.vote2016 = vote2016;
    }

    public UnemploymentData getEmploy2016() {
        return employ2016;
    }

    public void setEmploy2016(UnemploymentData employ2016) {
        this.employ2016 = employ2016;
    }
}
