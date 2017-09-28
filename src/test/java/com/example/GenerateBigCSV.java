package com.example;

import com.example.data.DataGenerator;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateBigCSV {

    private final static int GENERATE_ROWS = 500000;


    //@Test
    public void generateBigCSV() throws IOException {
        FileWriter fileWriter = new FileWriter("big.csv");
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(fileWriter).build();
        DataGenerator.generate(GENERATE_ROWS, object -> {
            try {
                beanToCsv.write(object);
            } catch (CsvDataTypeMismatchException e) {
                e.printStackTrace();
            } catch (CsvRequiredFieldEmptyException e) {
                e.printStackTrace();
            }
        });
        fileWriter.close();
    }
}
