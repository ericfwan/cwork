package personal.priingles;

public class Country {

    public String code;
    public String name;
    public String continent;
    public String region;
    public double surfaceArea;
    public int indepYear;
    public int population;
    public double lifeExpectancy;
    public double gnp;
    public double gnpOld;
    public String localName;
    public String governmentForm;
    public String headOfState;
    public int capital;
    public String code2;

    String[] coun;


    // Getter and Setter for code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for continent
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    // Getter and Setter for region
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    // Getter and Setter for surfaceArea
    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    // Getter and Setter for indepYear
    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    // Getter and Setter for population
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Getter and Setter for lifeExpectancy
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    // Getter and Setter for gnp
    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    // Getter and Setter for gnpOld
    public double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(double gnpOld) {
        this.gnpOld = gnpOld;
    }

    // Getter and Setter for localName
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    // Getter and Setter for governmentForm
    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    // Getter and Setter for headOfState
    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    // Getter and Setter for capital
    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    // Getter and Setter for code2
    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }



    public String[] displayCountry(){


        if(name != null) {
            String Population = Integer.toString(population);
            String[] coun = {code, name, continent, Population};
            this.coun = coun;
        }else {
            System.out.println("Country is null");
        }

        return coun;
    }

}
