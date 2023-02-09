public class LiteracyStat {

    private String gender;
    private String country;
    private int year;
    private String literacyRate;

    public LiteracyStat(String gender, String country, int year, String part) {
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyRate = part;
    }

    public double getLiteracyRate() {
        return Double.valueOf(this.literacyRate);
    }

    public String getGender() {
        return this.gender;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyRate;
    }
}
