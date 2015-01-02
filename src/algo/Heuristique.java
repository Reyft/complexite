package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import element.*;

public class Heuristique {
	int x;
	int y;
	private ArrayList<Boite> listeBoite = new ArrayList<Boite>();
	private ArrayList<Boite> listeRectangle;
	
	
	public Heuristique(Boite b, ArrayList<Boite> list){
		listeBoite.add(b);
		listeRectangle = list;
		x = b.getLong();
		y = b.getHaut();
		Collections.sort(listeRectangle);
	}
	
	public Heuristique(){
		this(new Boite(), new ArrayList<Boite>());
	}
	
	private boolean ranger(Boite b1, Boite b2){
		int longu = b2.getLong();
		int haut = b2.getHaut();
		Position p = chercher(b1, b2);
		if (p.getX() == -1){
			return false;
		} else {
			for (int i = p.getX(); i < p.getX()+longu; i++){
				for (int j = p.getY(); j < p.getY()+haut; j++){
					b1.getMat()[i][j].setUtilise(true);
					//ajouter pos du rectangle b2
				}
			}	
		return true;
		}
	}
	
	private Position chercher(Boite b1, Boite b2){
		int longu = b2.getLong();
		int haut = b2.getHaut();
		Position p = new Position(-1,0);
		Case[][] mat = b1.getMat();
		for (int i = 0; i < b1.getLong(); i++){
			for (int j = 0; j < b1.getHaut(); j++){
				if (!mat[i][j].utilise()){
					boolean acc = true;		
					int k=0,l=0;
					for ( k = i; k < i+longu && k< b1.getLong(); k++){
						for ( l = j; l < j+haut && l < b1.getHaut();  l++){
							if (mat[k][l].utilise()){
								acc = false;
							}
						}
					}
					if (acc && k-i == longu && l-j ==haut){
						p = new Position(i, j);
						return p;
					}
				}
			}
		}
		return p;
	}
	
	public int algo(){
		for (Boite b: listeRectangle){
			int i = 0;
			while(!ranger(listeBoite.get(i), b)){
				i = i+1;
				if (i > listeBoite.size()-1){
					listeBoite.add(new Boite(x, y));
				}
			}
		}
		return listeBoite.size();
	}
	
	public ArrayList<Boite> getBoite(){
		return listeBoite;
	}
}