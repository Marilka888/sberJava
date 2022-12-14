public class City {
//name – наименование города
//region – регион
//district – федеральный округ
//population – количество жителей города
//foundation – дата основания или первое упоминание
    String name;
    String region;
    String district;
    int population;
    String foundation;

    public City() {}

    public City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getDistrict() { return district;}
    public void setDistrict(String district) { this.district = district; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public String getFoundation() { return foundation; }
    public void setFoundation(String foundation) { this.foundation = foundation; }
}
