package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
//Test de mise à jour
public class BenchTest {
	
	/*
	*  the challenge is to extract as many relevant tables as possible
	*  and save them into CSV files  
	*  from the 300+ Wikipedia URLs given
	*  see below for more details
	**/
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
	    while ((url = br.readLine()) != null) {
	       String wurl = BASE_WIKIPEDIA_URL + url; 
	       System.out.println("Wikipedia url: " + wurl);
	       JSoupTest jsouptest = new JSoupTest();
	       String csvFileName = mkCSVFileName(url, 1);
	       System.out.println("CSV file name: " + csvFileName);
	       jsouptest.testUrlCanon(wurl, csvFileName);
	       // the *second* (if any) will be exported to a CSV file called
	       // "Comparison_of_operating_system_kernels-2.csv"

	       
	       // TODO: the HTML extractor should save CSV files into output/HTML
	       // see outputDirHtml 
	       
	       
	       nurl++;	       
	    }
	    
	    br.close();	    
	    assertEquals(nurl, 336);
	    



	}

	private String mkCSVFileName(String url, int n) {
		return url.trim() + "-" + n + ".csv";
	}

}
