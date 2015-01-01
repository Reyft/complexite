import java.util.ArrayList;

import element.Boite;
import algo.Heuristique;

public class Main {

	public static void main(String[] args) {
		Boite boite = new Boite (3,3);
		
		ArrayList<Boite> rec = new ArrayList<Boite>();
		Boite rec1 = new Boite (1,1);
		Boite rec2 = new Boite (3,3);
		rec.add(rec1);
		rec.add(rec2);
			
		Heuristique h = new Heuristique(boite, rec);
		System.out.println(h.algo());
		
	}

}
