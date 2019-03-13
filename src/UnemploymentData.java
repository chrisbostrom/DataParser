import java.util.ArrayList;

public class UnemploymentData implements Data{
   private int civilianLaborForce2016;
   private int employed2016;
   private int unemployed2016;
   private int fips;
   private double unemploymentRate2016;
   private boolean dataExists;
   private String stateName;
   private String countyName;

   public UnemploymentData(String[] data) {
       if(data.length < 49)
           dataExists = false;
       else{
           civilianLaborForce2016 = Integer.parseInt(data[46]);
           employed2016 = Integer.parseInt(data[47]);
           unemployed2016 = Integer.parseInt(data[48]);
           unemploymentRate2016 = Double.parseDouble(data[49]);
           fips = Integer.parseInt(data[0]);
           stateName = data[1];
           countyName = data[2];
           dataExists = true;
       }
   }

    public int getCivilianLaborForce2016() {
        if (!dataExists) {
            System.out.println("no data");
            return -1;
        }
        return civilianLaborForce2016;
    }

    public void setCivilianLaborForce2016(int civilianLaborForce2016) {
        this.civilianLaborForce2016 = civilianLaborForce2016;
    }

    public int getEmployed2016() {
        if (!dataExists) {
            System.out.println("no data");
            return -1;
        }
        return employed2016;
    }

    public void setEmployed2016(int employed2016) {
        this.employed2016 = employed2016;
    }

    public int getUnemployed2016() {
        if (!dataExists) {
            System.out.println("no data");
            return -1;
        }
        return unemployed2016;
    }

    public void setUnemployed2016(int unemployed2016) {
        this.unemployed2016 = unemployed2016;
    }

    public double getUnemploymentRate2016() {
        if (!dataExists) {
            System.out.println("no data");
            return -1;
        }
        return unemploymentRate2016;
    }

    public void setUnemploymentRate2016(double unemploymentRate2016) {
        this.unemploymentRate2016 = unemploymentRate2016;
    }

    public void setDataExists(boolean dataExists) {
        this.dataExists = dataExists;
    }

    @Override
    public int getFips() {
        if (!dataExists) {
            System.out.println("no data");
            return -1;
        }
        return fips;
    }

    @Override
    public String getStateName() {
        if (!dataExists) {
            System.out.println("no data");
            return null;
        }
        return stateName;
    }

    @Override
    public String getCountyName() {
        if (!dataExists) {
            System.out.println("no data");
            return null;
        }
        return countyName;
    }

    @Override
    public String toString() {
        if(!dataExists)
            return "no data";
        return "UnemploymentData{" +
                "civilianLaborForce2016=" + civilianLaborForce2016 +
                ", employed2016=" + employed2016 +
                ", unemployed2016=" + unemployed2016 +
                ", unemploymentRate2016=" + unemploymentRate2016 +
                '}';
    }
}
