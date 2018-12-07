package fr.univrennes1.istic.wikipediamatrix;
import org.junit.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFonctionnalites {
	
	@Test
	public void testCSVCanonColonnes(){
		JSoupTest Jsouptest = new JSoupTest();
		try {
			Jsouptest.testUrlCanon("https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras", "Comparison_of_Canon_EOS_digital_cameras-1.csv");
			Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\HP-ZBOOK-05\\git\\wikipediamatrix-bench\\wikimatrix\\output\\html\\Comparison_of_Canon_EOS_digital_cameras-1.csv"));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			assertEquals(csvParser.getHeaderMap().size(),18);
			
		} catch (Exception e) {
			System.out.println("Erreur");
			e.printStackTrace();
		}
	}
	@Test
	public void testCSVCanonLignes () {
		JSoupTest Jsouptest = new JSoupTest();
		try {
			Jsouptest.testUrlCanon("https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras", "Comparison_of_Canon_EOS_digital_cameras-1.csv");
			Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\HP-ZBOOK-05\\git\\wikipediamatrix-bench\\wikimatrix\\output\\html\\Comparison_of_Canon_EOS_digital_cameras-1.csv"));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			assertEquals(csvParser.getRecords().size(),62);
			
		} catch (Exception e) {
			System.out.println("Erreur");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTitre() {
		Titre titre = new Titre();
		Case case1 = new Case();
		Case case2 = new Case();
		Case case3 = new Case();
		case1.information="titre1";
		case2.information="titre2";
		case3.information="titre1";
		titre.cases.add(case1);
		titre.cases.add(case2);
		titre.cases.add(case3);
		String[] str= {"titre1","titre2"};
		titre.formatCSV().equals(str);
	}
	
	@Test
	public void testUrlFausse() {
		JSoupTest jsouptest = new JSoupTest();
		jsouptest.isUrlFausse("https://en.wikipedia.org/wiki/Comparison_of_Norwegian_Bokmål_and_Standard_Danish");
	}

	

}
