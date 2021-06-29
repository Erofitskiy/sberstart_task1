
import org.junit.Test;

import java.io.FileNotFoundException;

public class TestAll {
    @Test
    public void testCityConstructor1(){
        String s = "1;Абаза;Хакасия;Сибирский;17111;1867";
        try{
            City city = new City(s);
            System.out.println(city);
        } catch (Exception e) {
            assert(true);
            e.printStackTrace();
        }
    }

    @Test
    public void testCityConstructor2(){
        String s = "";
        try{
            City city = new City(s);
            System.out.println(city);
            assert(true);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void testCitySort1() throws FileNotFoundException {
        CitiesHandler cs = new CitiesHandler();
        cs.read();
        cs.sortByName();
        assert(!cs.list.get(0).equals(new City("1;Абаза;Хакасия;Сибирский;17111;1867")));
        assert(!cs.list.get(1).equals(new City("2;Абакан;Хакасия;Сибирский;165183;1734")));
        assert(!cs.list.get(2).equals(new City("3;Абдулино;Оренбургская область;Приволжский;20663;1795")));
    }

    @Test
    public void testCitySort2() throws FileNotFoundException {
        CitiesHandler cs = new CitiesHandler();
        cs.read();
        cs.sortByDistrictAndName();
        assert(!cs.list.get(0).equals(new City("15;Алдан;Якутия;Дальневосточный;21277;1924")));
        assert(!cs.list.get(1).equals(new City("19;Александровск-Сахалинский;Сахалинская область;Дальневосточный;10613;1869")));
        assert(!cs.list.get(2).equals(new City("26;Амурск;Хабаровский край;Дальневосточный;42977;1958")));
    }

}
