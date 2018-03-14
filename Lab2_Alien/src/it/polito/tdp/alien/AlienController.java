package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	
	AlienDictionary dizionario = new AlienDictionary();

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	
    	String word = txtWord.getText();
    	
    	if(word.length()==0) {
    		txtResult.appendText("Aggiungi le parole!\n");
    		return; // esce dall evento
    	}
    	
    	String[] words = word.split(" ");
    	if(words.length==2) {
    		// allora ci sono 2 parole e aggiungo al dizionario la parola
    		dizionario.addWord(words[0], words[1]);
    		txtResult.appendText("Aggiunta al dizionario la parola "+words[0]+" che significa "+words[1]+"\n");
    	} else if(words.length==1){
    		// c'è solo la parola aliena
    		/* in esercizio 1:
    		String s = dizionario.translateWord(words[0]);
    		**/
    	  	/*	
    		if(s=="") {
    			// la parola non esiste nel dizionario
    			txtResult.appendText("La parola inserita non è presente nel dizionario.\n");
    		} else {
    			txtResult.appendText("La parola inserita significa: "+s+"\n");
    		}*/
    		
    		// in esercizio 2:
    		String result = "";
    		List<String> lista = dizionario.translateWord(words[0]);

    		if(lista==null) {
    			txtResult.appendText("La parola inserita non è presente nel dizionario.\n");
    		} else {
    			for(String s : lista) {
    				result += s+" ";
    			}
    			txtResult.appendText("La parola inserita significa: "+result+"\n");

    		}
    	} else {
			txtResult.appendText("Hai inserito troppe parole.\n");
    	}
    	
    	txtWord.clear();

    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	dizionario = new AlienDictionary();
    	txtResult.clear();
    	txtWord.clear();
    }

    
    
    
}
