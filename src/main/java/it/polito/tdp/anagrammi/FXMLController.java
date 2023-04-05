package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClacola;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResultCorrect;

    @FXML
    private TextArea txtResultWrong;
    
    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	String parola = this.txtParola.getText();
    	List<Anagramma> lista = this.model.listaAnagrammi(parola);
    	for (Anagramma a : lista) {
    		if (a.isCorrect() == true) {
    			this.txtResultCorrect.appendText(a.getParola() + "\n");
    		}
    		else {
    			this.txtResultWrong.appendText(a.getParola() + "\n");
    		}
    	}
    	
    }
    
    @FXML
    void handleReset(ActionEvent event) {
    	this.txtResultCorrect.clear();
    	this.txtResultWrong.clear();
    	this.txtParola.clear();
    	
    }

    @FXML
    void initialize() {
        assert btnClacola != null : "fx:id=\"btnClacola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorrect != null : "fx:id=\"txtResultCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultWrong != null : "fx:id=\"txtResultWrong\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
