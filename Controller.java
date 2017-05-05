package oving2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
	@FXML DatePicker dato;
	@FXML ComboBox<Integer> fraTime;
	@FXML ComboBox<Integer> fraMinutt;
	@FXML ComboBox<Integer> tilTime;
	@FXML ComboBox<Integer> tilMinutt;
	@FXML TextField RepetisjonsFrekvens;
	@FXML DatePicker sluttDato;
	@FXML TextField formaal;
	@FXML TextField Rom;
	@FXML TextField tilbakemelding;
	@FXML Button verifikasjonsKnapp;
	
	AppointmentModel model = new AppointmentModel();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    fraTime.getItems().removeAll(fraTime.getItems());
	    fraTime.getItems().addAll(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22);
	    fraTime.getSelectionModel().select(0);
	    tilTime.getItems().removeAll(tilTime.getItems());
	    tilTime.getItems().addAll(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22);
	    tilTime.getSelectionModel().select(0);
	    
	    fraMinutt.getItems().removeAll(fraMinutt.getItems());
	    fraMinutt.getItems().addAll(0, 15, 30, 45);
	    fraMinutt.getSelectionModel().select(0);
	    tilMinutt.getItems().removeAll(tilMinutt.getItems());
	    tilMinutt.getItems().addAll(0, 15, 30, 45);
	    tilMinutt.getSelectionModel().select(0);
//		System.out.println(tilMinutt);
	}
	
	
	public DatePicker getDato() {
		return dato;
	}
	public ComboBox<Integer> getFraTime() {
		return fraTime;
	}
	public ComboBox<Integer> getFraMinutt() {
		return fraMinutt;
	}
	public ComboBox<Integer> getTilTime() {
		return tilTime;
	}
	public ComboBox<Integer> getTilMinutt() {
		return tilMinutt;
	}
	public TextField getRepetisjonsFrekvens() {
		return RepetisjonsFrekvens;
	}
	public DatePicker getSluttDato() {
		return sluttDato;
	}
	public TextField getFormaal() {
		return formaal;
	}
	public TextField getRom() {
		return Rom;
	}
	
	public void setTimeCheck(boolean suksess){
		if (suksess==false){
			tilbakemelding.setText("Du har skrevet feil tidspunkt");
		}
	}
	
	public void setDateCheck(boolean suksess){
		tilbakemelding.setText("Du har feil dato.");
	}
	
	public void romCheck(boolean suksess){
		tilbakemelding.setText("Du har skrevet feil rom.");
	}
	
	public void repetisjonsFrekvensCheck(boolean sukses){
		tilbakemelding.setText("Repetisjonsfrekvensen er ugyldig.");
	}
	
	public void setTilbakemelding(boolean suksess){
		if (suksess==true){
			tilbakemelding.setText("Bestillingen er godkjent.");
		}
		if (suksess==false){
			tilbakemelding.setText("Bestillingen er ikke godkjent, du har skrevet noe feil.");
		}
	}
	public boolean stringCheck(String check){
		if (check.equals("Date")){
			setDateCheck(false);
			return false;
		}
		if (check.equals("tid")){
			setTimeCheck(false);
			return false;
		}
		if (check.equals("rom")){
			romCheck(false);
			return false;
		}
		if (check.equals("repetisjon")){
			repetisjonsFrekvensCheck(false);
			return false;
		}
		
		return true;
	}
	
	@FXML
	public void onConfirmation(){
		
		
			
			String check = model.verificationChecker(dato, sluttDato, fraTime, tilTime, fraMinutt, tilMinutt, Rom,  RepetisjonsFrekvens);
			
			boolean ting = stringCheck(check);
			if (ting==true){
				setTilbakemelding(true);
			}
			
			System.out.println("Suksess!");
			//setTilbakemelding(check);
			
//		if (!repetisjon.getText().matches("[1-9]") && repetisjon.getText.lengt() >0|| (!repetisjon.gettext().matches("[0-9*") && repetisjon.getText().length>0)){
//					errorMsg = errorMsg + "Repetisjon, ";
//				}
		
		
	}

}
