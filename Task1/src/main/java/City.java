import java.util.Arrays;
import java.util.Comparator;

public class City implements Comparable<City> {
    int id;
    String name; // наименование города
    String region;  // регион
    String district;// федеральный округ
    int population; // количество жителей города
    int foundation; // дата основания или первое упоминание

    public City(int id, String name, String region, String district, int population, int foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public City(String str){
        String[] s = str.split(";");
        this.id = Integer.parseInt(s[0]);
        this.name = s[1];
        this.region = s[2];
        this.district = s[3];
        this.population = Integer.parseInt(s[4]);
        this.foundation = Integer.parseInt(s[5]);
    }

    @Override
    public String toString() {
        return "City{name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public int compareTo(City city) {
        return 0;
    }
}

class CityNameComparator implements Comparator<City> {
    public int compare(City a, City b){
        return a.getName().compareTo(b.getName());
    }
}
class CityDistrictComparator implements Comparator<City>{
    public int compare(City a, City b){
        return a.getDistrict().compareTo(b.getDistrict());
    }
}


