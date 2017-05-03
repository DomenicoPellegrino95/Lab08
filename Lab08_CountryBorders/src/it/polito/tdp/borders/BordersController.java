/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;
	public void setModel(Model model){
		this.model = model ;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		model.createGraph(Integer.parseInt(txtAnno.getText()));
		List<Country> paesi= new ArrayList<Country>(model.createGraph(Integer.parseInt(txtAnno.getText())));
		String result="";
		int c=0;
		for (Country s: paesi){
			if(s.getConfinanti()!=0){
				result+="Il paese "+ s.getName()+" ha "+ s.getConfinanti()+ " paesi con cui confina \n" ;}
			else{
				result+="Il paese "+ s.getName()+" e' una splendida isola \n";
				c++;}
		}
		result+="La mappa ha "+(model.getComponentiConnesse()-c)+" componenti connesse \n";
		txtResult.appendText(result);		
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";	
		
	}
	
	


}
