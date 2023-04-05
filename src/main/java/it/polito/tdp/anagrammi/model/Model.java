package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDAO;

	public Model() {
		this.anagrammaDAO = new AnagrammaDAO();
	}
	
	public List<Anagramma> listaAnagrammi (String parola) {
		List<String> lista = anagrammi(parola);
		List<Anagramma> listaAnagrammi = new LinkedList<Anagramma>();
		for (String p : lista) {
			boolean s = anagrammaDAO.isCorrect(p);
			Anagramma a = new Anagramma(p, s);
			listaAnagrammi.add(a);
		}
		return listaAnagrammi;

	}
	
	public List<String> anagrammi(String parola) {
				
		if (parola.length() == 1) {
			List<String> risultato = new LinkedList<String>();
			risultato.add(parola);
			return risultato;
		}
		else {
			
			List<String> risultato = new LinkedList<String>();
			
			for (int pos = 0; pos < parola.length() ; pos++) {
				char lettera = parola.charAt(pos);
				String restanti = parola.substring(0, pos) + parola.substring(pos + 1);
				
				List<String> anagrammiRestanti = anagrammi(restanti);
				for (String sol : anagrammiRestanti) {
					risultato.add(lettera + sol);
				}				
			}
			return risultato;
		}		
	}

}
