package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;
import java.util.List;

public class Ligne {
	List<Case> cases= new ArrayList<Case>();
	
	public String[] formatCSV() {
		List<String> liste= new ArrayList<String>();
		for (Case case1 : cases) {
			liste.add(case1.information);
			//System.out.println(case1.information);
		}
		String[] tab= liste.toArray(new String[liste.size()]);
		return tab; 
	}
}
