package oving2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AppointmentModel {
	
	
	public boolean dateChecker(LocalDate startDate, LocalDate endDate){
		
		
		Instant instant = Instant.from(startDate.atStartOfDay(ZoneId.systemDefault()));
		Date firstDate = Date.from(instant);
		
		Instant endInstant = Instant.from(endDate.atStartOfDay(ZoneId.systemDefault()));
		Date secondDate = Date.from(endInstant);
		
		
		if (firstDate.after(secondDate)){
			return false;
		}
		
		else return true;
	}
	
	public boolean timeChecker(Integer startTime, Integer sluttTime, Integer startMinutt, Integer sluttMinutt){
		if (startTime<sluttTime){
			return true;
		}
		if (sluttTime>startTime){
			return false;
		}
		if (startMinutt>=sluttMinutt){
			return false;
		}
		
		return true;
		
	}
	
	public String verificationChecker(DatePicker dato, DatePicker sluttDato, ComboBox<Integer> fraTime, ComboBox<Integer> tilTime, 
			ComboBox<Integer> fraMinutt, ComboBox<Integer> tilMinutt, TextField Rom, TextField RepetisjonsFrekvens){
		
		boolean dateCheck = dateChecker(dato.getValue(), sluttDato.getValue());
		
		if (dateCheck==false){
			//Gi output til bruker om at dette ikke går.
			return "Date";
			
			//return false;
			
		}
		
		boolean timeOfDayCheck = timeChecker(fraTime.getValue(), tilTime.getValue(), fraMinutt.getValue(), tilMinutt.getValue());
		if (timeOfDayCheck==false){
			//gi output til bruker
			//controller.setTimeCheck(timeOfDayCheck);
			return "tid";
			//return false;

		}
		
		if(Rom.getText().length() == 0 || !Rom.getText().matches("[A-Za-z0-9\\-\\s]+ \\d+")){
				//Gi output
			//controller.romCheck(false);
			return "rom";
			//return false;
			}
		
		if ( RepetisjonsFrekvens.toString().matches("[0-9]+")==false && RepetisjonsFrekvens.getLength() > 1) {
			// gi output
			//controller.repetisjonsFrekvensCheck(false);
			return "repetisjon";
			//return false;
		}
		
		return "suksess";
	}

}
