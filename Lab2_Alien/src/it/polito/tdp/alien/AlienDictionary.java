package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	/*
	// lista di word
	
	List<Word> listaWord;
	
	public AlienDictionary() {
		listaWord = new LinkedList<Word>();
	}
	
	
	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation);
		for(Word wtemp : listaWord) {
			if(wtemp.equals(w)) {
				// ho trovato la parola e devo aggiornarla
				wtemp.setTranslation(translation);
				listaWord.remove(wtemp);
			}
		}
		listaWord.add(w);
	} 
	
	public String translateWord(String alienWord) {
		// traduce la parola passata come parametro
		// restituisce null se alienWord non è presente nel dizionario
		for(Word w : listaWord) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.getTranslation();
			}
		}
		
		return null;
		
	}
	
	*/
	
	
	List<WordEnhanced> listaWord;
	
	public AlienDictionary() {
		listaWord = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation) {
		WordEnhanced w = new WordEnhanced(alienWord);
		for(WordEnhanced wtemp : listaWord) {
			if(wtemp.equals(w)) { // se hai trovato la parola,
				for(String s : wtemp.getTranslation()) {
					if(s.equals(translation)) {
						// se ho gia la traduzione non la aggiungo alla lista
						return;
					}
				}
				// se arrivo fino a qui allora non ho trovato la traduzione all interno della lista e la aggiungo
				wtemp.addTranslation(translation);
				return;
			}
		}
		listaWord.add(w);
		w.addTranslation(translation);
	} 
	
	public List<String> translateWord(String alienWord) {
		for(WordEnhanced w : listaWord) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.getTranslation();
			}
		}
		
		return null;
		
	}
	
	
}
