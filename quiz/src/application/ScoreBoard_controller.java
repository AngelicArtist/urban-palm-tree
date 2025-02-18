package application;

import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ScoreBoard_controller {
	@FXML
	public String scoreText;
	@FXML
	private Button S_Home;
	@FXML 
	private Button Get_score;
	@FXML
	public Label User_Score;
	@FXML
	private String username = Controller.getUsername();
	
	//switchscene
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
	//score-home
	public void scorebord_Home(ActionEvent e) {
	    try {
	        Stage stage = (Stage) S_Home.getScene().getWindow();
	        switchScene(stage, "Home.fxml");
	        
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	@FXML
	public void SetText(ActionEvent b) throws SQLException {
	    DatabaseConnection connectNow = new DatabaseConnection();
	    Connection connectDB = connectNow.getconnection();
	    
	    String getText = "SELECT Username, Art_score, History_Score, Math_Score, Sci_score FROM useraccount WHERE Username = ?";
	    
	    try (PreparedStatement preparedStatement = connectDB.prepareStatement(getText)) {
	        preparedStatement.setString(1, username);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) { // Check if result set is not empty
	                String name = resultSet.getString("Username");
	                int artScore = resultSet.getInt("Art_score");
	                int historyScore = resultSet.getInt("History_Score");
	                int mathScore = resultSet.getInt("Math_Score");
	                int sciScore = resultSet.getInt("Sci_score");
	                
	                scoreText = name + " Your Scores are: \n" +
	                            " Art: " + artScore + "\n" +
	                            " History: " + historyScore + "\n" +
	                            " Math: " + mathScore + "\n" +
	                            " Science: " + sciScore;
	            } else {
	                scoreText = "No scores found for user: " + username;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (connectDB != null) {
	            connectDB.close(); // Close connection
	        }
	    }
	    User_Score.setText(scoreText);
	}


}
