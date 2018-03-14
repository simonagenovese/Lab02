package it.polito.tdp.alien;

public class Word {
	
	// ESERCIZIO 2 ---> Refactor --> Rename Word in WordEnhanced
	// invece di creare una nuova classe modifico Word commentandola 
	
	// ESERCIZIO 1: CLASSE WORD
	// definisce l oggetto della singola parola
	
	private String alienWord;
	private String translation;
	
	
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getTranslation() {
		return translation;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Word))return false;
		Word wtemp = (Word) obj;
		if(alienWord.equals(wtemp.alienWord)) {
			// è gia presente nel dizionario 
			return true;
		}
		return false;
	}
	
}
