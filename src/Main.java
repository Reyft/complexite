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
				if (tab[i]>0 && tab[i]<=tab[0] && tab[i+1]>0 && tab[i+1]<=tab[1]){
					list.add(new Boite(tab[i], tab[i+1]));
				} else {
					System.err.println("Ce rectangle n'entre pas dans la boite");
				}
			}
			Heuristique h = new Heuristique(b, list);
			System.out.println("\nNombre de rectangle(s) : "+list.size()+"\n");
			start = System.currentTimeMillis();
			System.out.println("Nombre de boite(s) utilisée(s) pour ranger les rectangles : "+h.algo());
			duree = System.currentTimeMillis() - start;
			System.out.println("Temps d'execution : "+duree+"ms");
		} catch (Exception e) {
			e.printStackTrace();
		}	
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
