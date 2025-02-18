package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Sciance_controller {
	@FXML
	private Button Sciance_Home;
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
		public void Sciance_Home(ActionEvent e) {
		    try {
		        Stage stage = (Stage) Sciance_Home.getScene().getWindow();
		        switchScene(stage, "Home.fxml");

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
	//-------------------------------------------------------------------------
		@FXML
		private void LoadQuestion() {
			
			if(count == 0) {
				Question.setText("1. What is the chemical symbol for water?");
				Option1.setText("H2O");
				Option2.setText("CO2");
				Option3.setText("NaCl");
				Option4.setText("O2");
			}
			else if(count == 1) {
				Question.setText("2. Which planet is known as the Red Planet?");
				Option1.setText("Earth");
				Option2.setText("Jupiter");
				Option3.setText("Mars");
				Option4.setText("Venus");
			}
			else if(count == 2) {
				Question.setText("3. What is the smallest unit of matter?");
				Option1.setText("Atom");
				Option2.setText("Molecule");
				Option3.setText("Cell");
				Option4.setText("Proton");
			}
			else if(count == 3) {
				Question.setText("4. Which of the following is NOT a type of rock?");
				Option1.setText("Igneous");
				Option2.setText("Sedimentary");
				Option3.setText("Metamorphic");
				Option4.setText("Magnetic");
			}
			else if(count == 4) {
				Question.setText("5. What process converts sunlight into chemical energy in plants?");
				Option1.setText("Photosynthesis");
				Option2.setText("Respiration");
				Option3.setText("Transpiration");
				Option4.setText("Germination");
			}
			else if(count == 5) {
				Question.setText("6. What is the force that pulls objects towards the center of the Earth?");
				Option1.setText("Magnetism");
				Option2.setText("Gravity");
				Option3.setText("Friction");
				Option4.setText("Inertia");
			}
			else if(count == 6) {
				Question.setText("7. What is the function of the mitochondria in a cell?");
				Option1.setText("Storage of genetic material");
				Option2.setText("Synthesis of proteins");
				Option3.setText("Cellular respiration");
				Option4.setText("Photosynthesis");
			}
			else if(count == 7) {
				Question.setText("8. What is the pH scale used to measure?");
				Option1.setText("Temperature");
				Option2.setText("Acidity or alkalinity");
				Option3.setText("Pressure");
				Option4.setText("Density");
			}
			else if(count == 8) {
				Question.setText("9. What is the hardest natural substance on Earth?");
				Option1.setText("Gold");
				Option2.setText("Diamond");
				Option3.setText("Quartz");
				Option4.setText("Graphite");
			}
			else if(count == 9) {
				Question.setText("10. Which scientist formulated the theory of relativity?");
				Option1.setText("Isaac Newton");
				Option2.setText("Albert Einstein");
				Option3.setText("Galileo Galilei");
				Option4.setText("Stephen Hawking");
			}
		}
	//---------------------------------------------------------------
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
			        switchScene(stage, "Result_Sciance.fxml");
			       
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
			        switchScene(stage, "Result_Sciance.fxml");

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
			        switchScene(stage, "Result_Sciance.fxml");

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
			        switchScene(stage, "Result_Sciance.fxml");

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
					if(answer.equals("H2O")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 1) {
					if(answer.equals("Mars")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 2) {
					if(answer.equals("Atom")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 3) {
					if(answer.equals("Magnetic")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 4) {
					if(answer.equals("Photosynthesis")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 5) {
					if(answer.equals("Gravity")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 6) {
					if(answer.equals("Cellular respiration")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 7) {
					if(answer.equals("Acidity or alkalinity")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 8) {
					if(answer.equals("Diamond")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 9) {
					if(answer.equals("Albert Einstein")) {
						return true;
					}else {
						return false;
					}
				}
				return false;
			}
}
