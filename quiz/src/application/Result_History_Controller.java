package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class Result_History_Controller {

	@FXML
	private Button Art_Result_Home;
	@FXML 
	public Label score, Remark, Grade_text;
	@FXML
	public ProgressIndicator Correct;
	@FXML
	private String username = Controller.getUsername();
	
	

	public static void switchScene(Stage stage, String fxmlFileName) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(Controller.class.getResource(fxmlFileName));

            // Create a new scene with the loaded FXML content
            Scene scene = new Scene(root);

            // Set the scene to the stage
            stage.setScene(scene);

        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle exception if FXMLLoader fails to load the FXML file
        }
    }
    
	public void Art_Home(ActionEvent e) {
	    try {
	        Stage stage = (Stage) Art_Result_Home.getScene().getWindow();
	        switchScene(stage, "Home.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	@FXML
	private void initialize(){
	    DatabaseConnection ConnectNow = new DatabaseConnection();
	    Connection connectDB = ConnectNow.getconnection();
	    
	    String updateSql = "UPDATE useraccount SET History_Score = ? WHERE Username = ?;";
	    
	    try(PreparedStatement preparedStatement = connectDB.prepareStatement(updateSql)){
	    	preparedStatement.setInt(1, History_controller.Correct);
		    preparedStatement.setString(2, username);
		    preparedStatement.execute();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		
		Grade_text.setText(String.valueOf(History_controller.Correct) + "/10");
		score.setText("      " +String.valueOf(History_controller.Correct)+ "/10");
		
		float correctf = (float)History_controller.Correct/10;
		Correct.setProgress(correctf);
		
		int correct = History_controller.Correct;
		if (correct <= 7) {
			Remark.setText("Try Again!");
		}else {
			Remark.setText("Good Job!!");
		}
	}

}
