package oving2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage primaryStage){
	try{
		
        FXMLLoader loader = new FXMLLoader(getClass().getResource("finalView.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);//(scene);
		primaryStage.show();
		
		//final Controller controller = loader.getController();
		
		//scene.getStylesheets().add(getClass.getResource("Application.css").toExternalForm());
		//Scene.getStylesheets().add(getClass.getResource("Aplication.css").toExternalForm();
		//Stage newStage = new Stage()
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}

}
