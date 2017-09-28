package com.example.data;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.Consumer;

public class DataGenerator {

    public static void generate(int amount, Consumer<DataObject> consumer) {
        Random random = new Random(0xDEADBEEF);
        List<String> firstNames = getFirstNames();
        int firstNameCount = firstNames.size() - 1;
        List<String> lastNames = getLastNames();
        int lastNameCount = lastNames.size() - 1;
        List<String> cities = getCities();
        int cityCount = cities.size() - 1;

        for(int i = 0; i < amount; ++i) {
            DataObject object = new DataObject()
                    .setIndex(i + 1)
                    .setName(firstNames.get(1 + random.nextInt(firstNameCount)) + " " + lastNames.get(1 + random.nextInt(lastNameCount)))
                    .setCity(cities.get(1 + random.nextInt(cityCount)))
                    .setPhone(getPhoneNumber(random));
            consumer.accept(object);
        }
    }

    private static List<String> getFirstNames() {
        return getValues("firstname.csv");
    }

    private static List<String> getLastNames() {
        return getValues("lastname.csv");
    }

    private static List<String> getCities() {
        return getValues("city.csv");
    }

    private static NumberFormat THREE_FORMAT = new DecimalFormat("000");
    private static NumberFormat FOUR_FORMAT = new DecimalFormat("0000");

    private static String getPhoneNumber(Random random) {

        return "(555)-"
                + THREE_FORMAT.format(random.nextInt(1000))
                + "-"
                + FOUR_FORMAT.format(random.nextInt(10000));
    }

    private static List<String> getValues(String resource) {
        List<String> names = new ArrayList<>();

        InputStreamReader isReader = new InputStreamReader(DataGenerator.class.getClassLoader().getResourceAsStream(resource));
        CSVReader reader = new CSVReader(isReader);
        Iterator<String[]> iter = reader.iterator();
        while(iter.hasNext()) {
            names.add(iter.next()[0]);
        }
        return names;
    }
}
