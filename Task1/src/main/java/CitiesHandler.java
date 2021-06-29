import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CitiesHandler {
    public List<City> list;

    public CitiesHandler(){
        list = new ArrayList<>(1118);
    }

    public void read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/main/resources/data.txt"));
        while(scanner.hasNextLine()){
            list.add(new City(scanner.nextLine()));
        }
        scanner.close();
        Collections.shuffle(list);
    }

    public void printFirstThree(){
        if (list.size() == 0){
            System.out.println("List is empty");
            return;
        }
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }

    public void sortByName(){
        list.sort(new CityNameComparator());
    }

    public void sortByDistrictAndName() {
        list.sort(new CityDistrictComparator().thenComparing(new CityNameComparator()));
    }

    public void printMap(){
        HashMap<String, Integer> map = new HashMap<>();
        for(City c : list){
            if (map.containsKey(c.region))
                map.replace(c.region, map.get(c.region), map.get(c.region) + 1);
            else
                map.put(c.region, 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }


}
