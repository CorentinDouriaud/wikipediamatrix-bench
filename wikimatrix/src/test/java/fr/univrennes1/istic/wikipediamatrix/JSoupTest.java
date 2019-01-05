package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JSoupTest {
	
	@Test
	public Informations testUrlCanon(String url, String stockage) throws IOException {
		CSVWriter csvwriter= new CSVWriter();
		int nbreColonnes = 0;
		int nbreLignes =0;
		List<String> titresListe= new ArrayList<String>();
		Informations informations = new Informations();
		//String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras"; Mettre cette ligne pour tester le cas Canon ,et enlever la boucle for
		if (isUrlFausse(url)) { 
			System.out.println("L'adresse" + url + " n \' est pas accessible ");
		} else {
		Document doc = Jsoup.connect(url).get();
		Elements newsHeadlines = doc.getElementsByClass("wikitable sortable");
		int n=1; // Compteur qui numérotera les différents tableaux
		for (Element headline : newsHeadlines) {
			Tableau tableau=new Tableau();
			Elements newsHeadlines2 = headline.select("tr");
			Element titres = newsHeadlines2.get(0); // On suppose que la première de tous les tableaux sera une ligne de titre
			Elements titresL = titres.select("th");
			Titre titreObj = new Titre(); 
			for (Element titreEle : titresL) {
				nbreColonnes = nbreColonnes +1;
				Case case2= new Case();
				case2.information=titreEle.text();
				titreObj.cases.add(case2);
				titresListe.add(titreEle.text());
			}
			tableau.titre=titreObj;
			for (Element headline2 : newsHeadlines2) {
				nbreLignes = nbreLignes +1;
				Ligne ligne=new Ligne();
				Elements newsHeadLines3 = headline2.select("td"); // On récupère nos données grâce à cette ligne
				for (Element headline3 : newsHeadLines3) {
					Case case1=new Case();
					case1.information=headline3.text();
					ligne.cases.add(case1);
				}
				tableau.lignes.add(ligne);
			}
			String titre = mkCSVFileName(stockage, n); // On définit le nom de notre fichier CSV
			n++;
			csvwriter.writeCSV(tableau,titre); // On écrit notre fichier CSV 
		}
		}
		informations.setNbreColonnes(nbreColonnes);
		informations.setNbreLignes(nbreLignes);
		informations.setTitresListe(titresListe);
		return informations;
	}
	
	public boolean isUrlFausse(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			return true;
		}
		return false;
	}
	
	private String mkCSVFileName(String url, int n) {
		return url.trim() + "-" + n + ".csv";
	}
}
