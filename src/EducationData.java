public class EducationData implements Data{
    private double percentNoHSDiploma2012_2016;
    private double percentOnlyHSDiploma2012_2016;
    private double percentSomeCollegeDegree2012_2016;
    private double percentBachelorDegree2012_2016;
    private int fips;
    private boolean dataExist;
    private String stateName;
    private String countyName;

    public EducationData(String[] data) {
        if (data.length < 46)
            dataExist = false;
        else {
            percentNoHSDiploma2012_2016 = Double.parseDouble(data[43]);
            percentOnlyHSDiploma2012_2016 = Double.parseDouble(data[43]);
            percentSomeCollegeDegree2012_2016 = Double.parseDouble(data[44]);
            percentBachelorDegree2012_2016 = Double.parseDouble(data[46]);
            fips = Integer.parseInt(data[0]);
            stateName = data[1];
            countyName = data[2];
            dataExist = true;
        }
    }

    public double getPercentNoHSDiploma2012_2016() {
        if (!dataExist) {
            System.out.println("no data");
            return -1;
        }
        return percentNoHSDiploma2012_2016;
    }

    public void setPercentNoHSDiploma2012_2016(double percentNoHSDiploma2012_2016) {
        this.percentNoHSDiploma2012_2016 = percentNoHSDiploma2012_2016;
    }

    public double getPercentOnlyHSDiploma2012_2016() {
        if (!dataExist) {
            System.out.println("no data");
            return -1;
        }
        return percentOnlyHSDiploma2012_2016;
    }

    public void setPercentOnlyHSDiploma2012_2016(double percentOnlyHSDiploma2012_2016) {
        this.percentOnlyHSDiploma2012_2016 = percentOnlyHSDiploma2012_2016;
    }

    public double getPercentSomeCollegeDegree2012_2016() {
        if (!dataExist) {
            System.out.println("no data");
            return -1;
        }
        return percentSomeCollegeDegree2012_2016;
    }

    public void setPercentSomeCollegeDegree2012_2016(double percentSomeCollegeDegree2012_2016) {
        this.percentSomeCollegeDegree2012_2016 = percentSomeCollegeDegree2012_2016;
    }

    public double getPercentBachelorDegree2012_2016() {
        if (!dataExist) {
            System.out.println("no data");
            return -1;
        }
        return percentBachelorDegree2012_2016;
    }

    public void setPercentBachelorDegree2012_2016(double percentBachelorDegree2012_2016) {
        this.percentBachelorDegree2012_2016 = percentBachelorDegree2012_2016;
    }

    public int getFips() {
        if (!dataExist) {
            System.out.println("no data");
            return -1;
        }
        return fips;
    }

    public String getStateName() {
        if (!dataExist) {
            System.out.println("no data");
            return null;
        }
        return stateName;
    }

    public String getCountyName() {
        if (!dataExist) {
            System.out.println("no data");
            return null;
        }
        return countyName;
    }

    @Override
    public String toString() {
        if (!dataExist)
            return "no data";
        return "EducationData{" +
                "percentNoHSDiploma2012_2016=" + percentNoHSDiploma2012_2016 +
                ", percentOnlyHSDiploma2012_2016=" + percentOnlyHSDiploma2012_2016 +
                ", percentSomeCollegeDegree2012_2016=" + percentSomeCollegeDegree2012_2016 +
                ", percentBachelorDegree2012_2016=" + percentBachelorDegree2012_2016 +
                '}';
    }
}