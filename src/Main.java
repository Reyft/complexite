import java.util.ArrayList;

import element.Boite;
import algo.Heuristique;

public class Main {

	public static void main(String[] args) {
		Boite boite = new Boite (3,3);
		
		System.out.println(boite.caseVide().size());
		
		ArrayList<Boite> rec = new ArrayList<Boite>();
		Boite rec1 = new Boite (1,1);
		rec.add(rec1);
			
		Heuristique h = new Heuristique(boite, rec);
		System.out.println(h.algo());
		System.out.println(boite.caseVide().size());
	}

}
