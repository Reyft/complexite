package element;

import java.util.ArrayList;

public class Boite implements Comparable<Boite>{
	private int hauteur;
	private int longueur;			
	private Case[][] mat;
	
	
	public Boite(int i, int j){
		hauteur = i;
		longueur = j;
		mat = new Case [hauteur][longueur];
		initPos();
	}
	
	public Boite(){
		this(0,0);
	}
	
	private void initPos(){
		for (int i = 0; i < hauteur; i++){
			for (int j = 0; j < longueur; j++){
				mat[i][j] = new Case(i, j);
			}
		}
	}
	
	public void setLong(int i){
		longueur = i;
	}
	
	public void setHaut(int i){
		hauteur = i;
	}
	
	public int getLong(){
		return longueur;
	}
	
	public int getHaut(){
		return hauteur;
	}
	
	public Case[][] getMat(){
		return mat;
	}
	
	public void utiliseCase(int i, int j){
		mat[i][j].setUtilise(true);
	}
	
	public ArrayList<Case> caseVide(){
		ArrayList<Case> list = new ArrayList<Case>();
		for (int i = 0; i < hauteur; i++){
			for (int j = 0; j < longueur; j++){
				if (!mat[i][j].utilise()){
					list.add(mat[i][j]);
				}
			}		
		}
		return list;
	}
	
	public boolean pleine(){
		return caseVide().isEmpty();
	}

	@Override
	public int compareTo(Boite b) {
		if (this.longueur > b.getLong()){
			return -1;
		} else if (this.longueur < b.getLong()){
			return 1;
		} else {
			if (this.hauteur > b.getHaut()){
				return -1;
			} else if (this.hauteur < b.getHaut()){
				return 1;
			} else {
				return 0;
			}
		}
	}

}