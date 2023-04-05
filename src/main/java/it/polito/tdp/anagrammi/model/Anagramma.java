package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	private String parola;
	private boolean isCorrect;

	public Anagramma(String parola, boolean isCorrect) {
		super();
		this.parola = parola;
		this.isCorrect = isCorrect;
	}

	public String getParola() {
		return parola;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

}
