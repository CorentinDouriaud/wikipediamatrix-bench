package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Titre {
	List<Case> cases= new ArrayList<Case>();
	
	public String[] formatCSV() {
		List<String> liste= new ArrayList<String>();
		for (Case case1 : cases) {
			liste.add(case1.information);
			//System.out.println(case1.information);
			
		}
		LinkedHashSet set = new LinkedHashSet(); //Permet d'éliminer les titres doublons et de conserver l'ordre
		set.addAll(liste);
		String[] tab= (String[]) set.toArray(new String[liste.size()]);
		return tab; 
	}
}
