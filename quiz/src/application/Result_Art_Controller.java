package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.Controller;
public class Result_Art_Controller {
	  @FXML
	  private String username = Controller.getUsername();
	  @FXML
	  private Button Art_Result_Home;
	  @FXML
	  public Label score, Remark, Grade_text;
	  @FXML
	  public ProgressIndicator Correct;
	  @FXML
	  private int correct = Art_Controller.Correct;

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
	      System.out.println("Error loading FXML file: " + ex.getMessage());
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
	  private void initialize() {
		    DatabaseConnection ConnectNow = new DatabaseConnection();
		    Connection connectDB = ConnectNow.getconnection();
		    
		    String updateSql = "UPDATE useraccount SET Art_score = ? WHERE Username = ?;";
		    
		    try(PreparedStatement preparedStatement = connectDB.prepareStatement(updateSql)){
		    	preparedStatement.setInt(1, correct);
			    preparedStatement.setString(2, username);
			    preparedStatement.execute();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
	    Grade_text.setText(String.valueOf(Art_Controller.Correct) + "/10");
	    score.setText("      " + String.valueOf(Art_Controller.Correct) + "/10");

	    float correctf = (float) Art_Controller.Correct / 10;
	    Correct.setProgress(correctf);

	    int correct = Art_Controller.Correct;
	    if (correct <= 7) {
	      Remark.setText("Try Again!");
	    } else {
	      Remark.setText("Good Job!!");
	    }
	  }
	}

