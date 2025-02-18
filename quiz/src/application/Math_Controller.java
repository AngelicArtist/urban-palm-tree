package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Math_Controller {
@FXML
private Button Math_Home;
@FXML
private Label Question;
@FXML
private Button Option1;
@FXML
private Button Option2;
@FXML
private Button Option3;
@FXML
private Button Option4;
	
	
	
//------------------------------------------------------------------	
	int count =0;
	static int Correct=0;
	static int wrong=0;
//------------------------------------------------------------------
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
//--------------------------------------------------------------------
	public void Math_Home(ActionEvent e) {
	    try {
	        Stage stage = (Stage) Math_Home.getScene().getWindow();
	        switchScene(stage, "Home.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
//---------------------------------------------------------------------------
	@FXML
	private void LoadQuestion() {
		
		if(count == 0) {
			Question.setText("1. Solve for 3x+5=17.");
			Option1.setText("X = 4");
			Option2.setText("X = 6");
			Option3.setText("X = 8");
			Option4.setText("X = 12");
		}
		else if(count == 1) {
			Question.setText("2. Calculate the area of a rectangle with length 12 meters and width 8 meters.?");
			Option1.setText("90");
			Option2.setText("94");
			Option3.setText("96");
			Option4.setText("99");
		}
		else if(count == 2) {
			Question.setText("3. If a triangle has a base of 10 inches and a height of 6 inches, what is its area?");
			Option1.setText("64");
			Option2.setText("74");
			Option3.setText("25");
			Option4.setText("30");
		}
		else if(count == 3) {
			Question.setText("4. Evaluate the expression 4^3+2x5?");
			Option1.setText("64");
			Option2.setText("74");
			Option3.setText("98");
			Option4.setText("104");
		}
		else if(count == 4) {
			Question.setText("5. A car travels at a speed of 60 miles per hour. How far will it travel in 3 hours?");
			Option1.setText("60");
			Option2.setText("120");
			Option3.setText("240");
			Option4.setText("180");
		}
		else if(count == 5) {
			Question.setText("6. What is the volume of a cube with edges measuring 4 inches each?");
			Option1.setText("24");
			Option2.setText("64");
			Option3.setText("98");
			Option4.setText("12");
		}
		else if(count == 6) {
			Question.setText("7. If a pizza has a diameter of 16 inches, what is its circumference?");
			Option1.setText("53.26");
			Option2.setText("31.45");
			Option3.setText("78.45");
			Option4.setText("50.27");
		}
		else if(count == 7) {
			Question.setText("8. Simplify the expression 3/5 + 2/3");
			Option1.setText("19/15");
			Option2.setText("15/19");
			Option3.setText("30/20");
			Option4.setText("36/30");
		}
		else if(count == 8) {
			Question.setText("9. A box contains 24 marbles. If 8 of them are red, what percentage of the marbles are red?");
			Option1.setText("24.26");
			Option2.setText("30.33");
			Option3.setText("33.33");
			Option4.setText("29.95");
		}
		else if(count == 9) {
			Question.setText("10. Solve for y in the equation 2y-7=11");
			Option1.setText("9");
			Option2.setText("6");
			Option3.setText("12");
			Option4.setText("15");
		}
	}
//--------------------------------------------------------------------
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
		        switchScene(stage, "Result_Math.fxml");
		       
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
		        switchScene(stage, "Result_Math.fxml");

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
		        switchScene(stage, "Result_Math.fxml");

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
		        switchScene(stage, "Result_Math.fxml");

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}else {
			count++;
			LoadQuestion();
		}
	}
//------------------------------------------------------------------------------------
boolean checkAnswer(String answer) {
		
		if(count == 0) {
			if(answer.equals("X = 4")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 1) {
			if(answer.equals("96")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 2) {
			if(answer.equals("30")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 3) {
			if(answer.equals("74")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 4) {
			if(answer.equals("180")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 5) {
			if(answer.equals("64")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 6) {
			if(answer.equals("50.27")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 7) {
			if(answer.equals("19/15")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 8) {
			if(answer.equals("33.33")) {
				return true;
			}else {
				return false;
			}
		}
		if(count == 9) {
			if(answer.equals("9")) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
