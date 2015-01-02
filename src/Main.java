import java.io.*;
import java.util.ArrayList;

import element.Boite;
import algo.*;

public class Main {

	private static BufferedReader ficTexte;

	public static void main(String[] args) throws IOException {
		long start; 
		long duree;
		int[] tab;
		ArrayList<Boite> list = new ArrayList<Boite>();
		Boite b;
		try{
			tab = lectFichier();
			b = new Boite(tab[0], tab[1]);
			for (int i = 2; i < tab.length; i+=2){
				list.add(new Boite(tab[i], tab[i+1]));
			}
			Heuristique h = new Heuristique(b, list);
			System.out.println("Nombre de rectangle(s) : "+list.size());
			start = System.nanoTime();
			System.out.println("Nombre de boite(s) utilisée(s) pour ranger les rectangles : "+h.algo());
			duree = System.nanoTime() - start;
			System.out.println("temps d'execution : "+duree+"ns");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
//		Boite boite = new Boite (3,3);
//		
//		ArrayList<Boite> rec = new ArrayList<Boite>();
//		Boite rec1 = new Boite (1,1);
//		Boite rec2 = new Boite (3,3);
//		rec.add(rec1);
//		rec.add(rec2);
//			
//		Heuristique h = new Heuristique(boite, rec);
//		System.out.println(h.algo());		
	}
	
	private static int[] lectFichier() throws IOException{
		String ligne = "";
		String fichier = "";
		String sortie = "";
		int[] result = new int[0];
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Quel est le nom de votre fichier ?");
		fichier = clavier.readLine();
		try {
			ficTexte = new BufferedReader(new FileReader(new File(fichier)));
			do{
				ligne = ficTexte.readLine();
				if (ligne != null) {				
				sortie += ligne+",";
				}
			} while (ligne != null);
			ficTexte.close();
			String delims = "[x,]+";
			String[] tokens = sortie.split(delims);
			result = new int[tokens.length];
			for (int i = 0; i < tokens.length; i++){
				result[i] = Integer.parseInt(tokens[i]);
			}
		} catch (FileNotFoundException e) {			
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
