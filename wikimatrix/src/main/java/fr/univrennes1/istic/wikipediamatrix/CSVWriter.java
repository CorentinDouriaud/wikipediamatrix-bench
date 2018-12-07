package fr.univrennes1.istic.wikipediamatrix;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVWriter {
    public static String SAMPLE_CSV_FILE = "C:\\Users\\HP-ZBOOK-05\\git\\wikipediamatrix-bench\\wikimatrix\\output\\html\\";
    

    public static void writeCSV(Tableau tableau, String stockage) throws IOException {
    	String stock=SAMPLE_CSV_FILE+stockage;
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(stock));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader(tableau.titre.formatCSV()));
        ) {
        	for (int i = 1; i < tableau.lignes.size(); i++) {
            csvPrinter.printRecord(tableau.lignes.get(i).formatCSV());
        	}

            csvPrinter.flush();     
        }
    }
}

