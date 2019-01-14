package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
public class BenchTest {
	

	@Test
	public void testBenchExtractors() throws Exception {
		
		String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";
		// directory where CSV files are exported (HTML extractor) 
		String outputDirHtml = "output" + File.separator + "html" + File.separator;
		assertTrue(new File(outputDirHtml).isDirectory());
		
		File file = new File("inputdata" + File.separator + "wikiurls.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String url;
	    int nurl = 0;
	    List<String> titresListe= new ArrayList<String>();
	    List<Integer> nombreLignes= new ArrayList<Integer>();
	    List<Integer> nombreColonnes= new ArrayList<Integer>();
	    while ((url = br.readLine()) != null) {
	       String wurl = BASE_WIKIPEDIA_URL + url; 
	       //System.out.println("Wikipedia url: " + wurl);
	       JSoupTest jsouptest = new JSoupTest();
	       String csvFileName = mkCSVFileName(url, 1);
	       System.out.println("CSV file name: " + csvFileName);
	       Informations informations = jsouptest.testUrlCanon(wurl, url);
	       titresListe.addAll(informations.getTitresListe());
		int i = 0;
	        for(String s : titresListe) {
	        	if (s.equals("")) {
	                i++;
	               // System.out.println(i);
	        	}

	        }
	       nombreLignes.add(informations.getNbreLignes());
	       nombreColonnes.add(informations.getNbreColonnes());
	       nurl++;      
	    }
	    
	    br.close();	 
	    String stock="C:\\Users\\HP-ZBOOK-05\\git\\wikipediamatrix-bench\\wikimatrix\\output\\html\\resultatsColonnesLignes.csv";
	    BufferedWriter writer = Files.newBufferedWriter(Paths.get(stock));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        csvPrinter.printRecord(nombreLignes);
        csvPrinter.printRecord(nombreColonnes); 
        csvPrinter.flush();  
        stock="C:\\Users\\HP-ZBOOK-05\\git\\wikipediamatrix-bench\\wikimatrix\\output\\html\\resultatsTitre.csv";
        BufferedWriter writer2 = Files.newBufferedWriter(Paths.get(stock));
        CSVPrinter csvPrinter2 = new CSVPrinter(writer2, CSVFormat.DEFAULT);
        for (int i = 1; i < titresListe.size(); i++) {
            csvPrinter2.printRecord(titresListe.get(i));
        	}
        csvPrinter2.flush();
	    assertEquals(nurl, 336);
	    



	}

	private String mkCSVFileName(String url, int n) {
		return url.trim() + "-" + n + ".csv";
	}

}
