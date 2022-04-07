package it.polito.tdp.ricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	
	List<Integer> soluzione;
	
	public List<Integer> cercaRegine(int N) {
		this.soluzione = null;
		List<Integer> parziale = new ArrayList<Integer>();
		regine_ricorsive(parziale, 0, N);
		return this.soluzione;
	}
	
	private boolean regine_ricorsive(List<Integer> parziale, int livello, int N) {
		if(livello==0) {
			System.out.println(parziale);
			this.soluzione = new ArrayList<Integer> (parziale);
			return false;
		} else {
			for(int col=0; col<N; col++) {
				if(compatibile(livello, col, parziale)) {
					parziale.add(col);
					boolean continua = regine_ricorsive(parziale, livello+1, N);
					if(!continua) {
						return false;
					}
					parziale.remove(parziale.size()-1); //backtracking
				}
			}
			return true;
		}
		
	}
	
	public boolean compatibile(int livello, Integer col, List<Integer> parziale) {
		if(parziale.indexOf(col)!= -1) {
			return false;
		}
		for(int riga=0; riga<parziale.size(); riga++) {
			if(riga + parziale.get(riga)== livello +col) {
				return false;
			}
			if(riga - parziale.get(riga)== livello - col) {
				return false;
			}
		}
		return true;
	}
}
