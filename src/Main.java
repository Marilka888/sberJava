import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<City> cityList = new ArrayList<>(1000);
        try {
            Scanner scanner = new Scanner(new File("src/res/Задача ВС Java Сбер.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] row = line.split(";");
                City city = new City(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5]);
                cityList.add(city);
            }
            scanner.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Main.countCityInRegion(cityList); //print list
    }

    /*Печать листа с городами */
    public static void printList (ArrayList<City> cities) {
        cities.forEach(System.out::println);
    }

    /*Сортировка по наименованию города в алфавитном порядке */
    public static ArrayList<City> sortByName(ArrayList<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return cities;
    }

    /*Сортировка по федеральному округу и наименованию города
    внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра */
    public static ArrayList<City> sortByNameAndDistrict(ArrayList<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        return cities;
    }

    /*Метод для нахождения индекса самого многочисленного по населению города */
    public static void findMaxPopular(ArrayList<City> cities) {
        int maxPopulation = 0;
        int index = 0;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getPopulation() > maxPopulation) {
                maxPopulation = cities.get(i).getPopulation();
                index = i;
            }
        }
        System.out.println("[" + index + "] = " + maxPopulation);
    }

    /*Метод для нахождения количества городов в каждом регионе */
    public static void countCityInRegion(ArrayList<City> cities) {
        Map<String, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < cities.size(); i++) {
            if (!mapCount.containsKey(cities.get(i).getRegion())){
                mapCount.put(cities.get(i).getRegion(), 1);
            }
            else {
                mapCount.computeIfPresent(cities.get(i).getRegion(), (k, v) -> v + 1);
            }
        }
        for (Map.Entry<String, Integer> e : mapCount.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
