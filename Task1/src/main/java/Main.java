import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        CitiesHandler citiesHandler = new CitiesHandler();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("===============");
            System.out.println("0 - exit");
            System.out.println("1 - read file");
            System.out.println("2 - sort by name");
            System.out.println("3 - sort by district and name");
            System.out.println("4 - print full list");
            System.out.println("5 - find city with the most population");
            System.out.println("6 - print statistics for regions");
            int s = sc.nextInt();
            if (s == 0)
                break;
            else if (s == 1){
                citiesHandler.read();
                citiesHandler.printFirstThree();
            } else if (s == 2) {
                citiesHandler.sortByName();
                citiesHandler.printFirstThree();
            } else if (s == 3) {
                citiesHandler.sortByDistrictAndName();
                citiesHandler.printFirstThree();
            } else if (s == 4) {
                for (City c : citiesHandler.list)
                    System.out.println(c);
            } else if (s == 5) {
                int max = 0;
                int id = -1;
                for (City c : citiesHandler.list)
                    if (c.population > max){
                        max = c.population;
                        id = c.id;
                    }
                System.out.println("[" + id + "] = " + max);
            } else if (s == 6) {
                citiesHandler.printMap();
            }
        }


    }

}
