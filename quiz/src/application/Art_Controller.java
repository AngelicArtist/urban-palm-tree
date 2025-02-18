package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Art_Controller {
	@FXML
	private Button Art_Home;
	@FXML
	private Button Option1;
	@FXML
	private Button Option2;
	@FXML
	private Button Option3;
	@FXML
	private Button Option4;
	@FXML
	private Label Question;
	//--------
	int count =0;
	static int Correct=0;
	static int wrong=0;
	//Art quiz objects

	//switch scenes for button
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
	        Stage stage = (Stage) Art_Home.getScene().getWindow();
	        switchScene(stage, "Home.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	@FXML
	private void LoadQuestion() {
		
		if(count == 0) {
			Question.setText("1. Who painted the famous work Starry Night?");
			Option1.setText("Claude Monet");
			Option2.setText("Vincent van Gogh");
			Option3.setText("Pablo Picasso");
			Option4.setText("Leonardo da Vinci");
		}
		else if(count == 1) {
			Question.setText("2. Which artistic movement is characterized by exaggerated expression, bold colors, and distorted figures?");
			Option1.setText("Surrealism");
			Option2.setText("Cubism");
			Option3.setText("Impressionism");
			Option4.setText("Expressionism");
		}
		else if(count == 2) {
			Question.setText("3. Who sculpted the famous statue David?");
			Option1.setText("Michelangelo");
			Option2.setText("Donatello");
			Option3.setText("Leonardo da Vinci");
			Option4.setText("Raphael");
		}
		else if(count == 3) {
			Question.setText("4.The Renaissance originated in which country?");
			Option1.setText("Italy");
			Option2.setText("France");
			Option3.setText("Spain");
			Option4.setText("Germany");
		}
		else if(count == 4) {
			Question.setText("5. Which art movement emphasized spontaneity, directness, and improvisation, often using unconventional materials?");
			Option1.setText("Dadaism");
			Option2.setText("Romanticism");
			Option3.setText("Fauvism");
			Option4.setText("Abstract Expressionism");
		}
		else if(count == 5) {
			Question.setText("6. Who is considered the father of modern sculpture?");
			Option1.setText("Alexander Calder");
			Option2.setText("Henry Moore");
			Option3.setText("Auguste Rodin");
			Option4.setText("Constantin Brancusi");
		}
		else if(count == 6) {
			Question.setText("7. The painting The Persistence of Memory features melting clocks and was painted by:");
			Option1.setText("Salvador Dalí");
			Option2.setText("René Magritte");
			Option3.setText("Pablo Picasso");
			Option4.setText("Henri Matisse");
		}
		else if(count == 7) {
			Question.setText("8. The architectural style characterized by its pointed arches, ribbed vaults, and flying buttresses is known as:");
			Option1.setText("Baroque");
			Option2.setText("Romanesque");
			Option3.setText("Gothic");
			Option4.setText("Renaissance");
		}
		else if(count == 8) {
			Question.setText("9. Who painted the ceiling of the Sistine Chapel?");
			Option1.setText("Leonardo da Vinci");
			Option2.setText("Michelangelo");
			Option3.setText("Raphael");
			Option4.setText("Titian");
		}
		else if(count == 9) {
			Question.setText("10. Which female artist is known for her iconic self-portraits, often depicting herself with a unibrow and wearing traditional Mexican attire?");
			Option1.setText("Frida Kahlo");
			Option2.setText("Georgia O'Keeffe");
			Option3.setText("Mary Cassatt");
			Option4.setText("Louise Bourgeois");
		}
	}
	


	@FXML
	public void Option1_Clicked(ActionEvent event) {
		checkAnswer(Option1.getText().toString());
		if(checkAnswer(Option1.getText().toString())) {
			Correct = Correct + 1 ;
		}else {
			wrong = wrong +1;
		}
		
		if(count == 9) {
		    try {
		    	 Stage stage = (Stage) Option1.getScene().getWindow();
		        switchScene(stage, "Results_Art.fxml");
		       
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}else {
			count++;
			LoadQuestion();
		}
	}
	
	@FXML
	public void Option2_Clicked(ActionEvent event) {
		checkAnswer(Option2.getText().toString());
		if(checkAnswer(Option2.getText().toString())) {
			Correct = Correct + 1 ;
		}else {
			wrong = wrong +1;
		}
		
		if(count == 9) {
		    try {
		    	 Stage stage = (Stage) Option1.getScene().getWindow();
		        switchScene(stage, "Results_Art.fxml");

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}else {
			count++;
			LoadQuestion();
		}
	}
	
	@FXML
	public void Option3_Clicked(ActionEvent event) {
		checkAnswer(Option3.getText().toString());
		if(checkAnswer(Option3.getText().toString())) {
			Correct = Correct + 1 ;
		}else {
			wrong = wrong +1;
		}
		
		if(count == 9) {
		    try {
		    	 Stage stage = (Stage) Option1.getScene().getWindow();
		        switchScene(stage, "Results_Art.fxml");

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}else {
			count++;
			LoadQuestion();
		}
	}
	
	@FXML
	public void Option4_Clicked(ActionEvent event) {
		checkAnswer(Option4.getText().toString());
		if(checkAnswer(Option4.getText().toString())) {
			Correct = Correct + 1 ;
		}else {
			wrong = wrong +1;
		}
		
		if(count == 9) {
		    try {
		    	 Stage stage = (Stage) Option1.getScene().getWindow();
		        switchScene(stage, "Results_Art.fxml");

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}else {
			count++;
			LoadQuestion();
		}
	}
	
	boolean checkAnswer(String answer) {
		
		if(count == 0) {
			if(answer.equals("Vincent van Gogh")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 1) {
			if(answer.equals("Expressionism")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 2) {
			if(answer.equals("Michelangelo")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 3) {
			if(answer.equals("Italy")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 4) {
			if(answer.equals("Abstract Expressionism")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 5) {
			if(answer.equals("Constantin Brancusi")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 6) {
			if(answer.equals("Salvador Dalí")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 7) {
			if(answer.equals("Gothic")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 8) {
			if(answer.equals("Michelangelo")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 9) {
			if(answer.equals("Frida Kahlo")) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
	



