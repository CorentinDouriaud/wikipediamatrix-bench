package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;
import java.util.List;
/*Les informations d'une feuille excel*/
public class Informations {
	private int nbreLignes;
	private int nbreColonnes;
	private List<String> titresListe= new ArrayList<String>();
	public int getNbreLignes() {
		return nbreLignes;
	}
	public void setNbreLignes(int nbreLignes) {
		this.nbreLignes = nbreLignes;
	}
	public int getNbreColonnes() {
		return nbreColonnes;
	}
	public void setNbreColonnes(int nbreColonnes) {
		this.nbreColonnes = nbreColonnes;
	}
	public List<String> getTitresListe() {
		return titresListe;
	}
	public void setTitresListe(List<String> titresListe) {
		this.titresListe = titresListe;
	}

	
}
