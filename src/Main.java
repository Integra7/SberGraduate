import Model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("static/Cities.csv"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                    // Пропускаем первый столбец (порядковый номер)
                    int startIndex = 1;

                    // Предполагаем, что порядок колонок в CSV соответствует порядку полей в классе City
                    String name = data[startIndex++];
                    String region = data[startIndex++];
                    String district = data[startIndex++];
                    int population = Integer.parseInt(data[startIndex++]);

                    String foundation = (startIndex + 1 <= data.length) ? data[startIndex] : "";


                    City city = new City(name, region, district, population, foundation);
                    cities.add(city);


            }

            scanner.close();

            // Выводим информацию о городах
            for (City city : cities) {
                System.out.println(city);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
