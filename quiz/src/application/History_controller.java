package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class History_controller {
	@FXML
	private Button History_Home;
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
		public void History_Home(ActionEvent e) {
		    try {
		        Stage stage = (Stage) History_Home.getScene().getWindow();
		        switchScene(stage, "Home.fxml");

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
	//------------------------------------------------------
		@FXML
		private void LoadQuestion() {
			
			if(count == 0) {
				Question.setText("1. Who was the first President of the United States?");
				Option1.setText("Thomas Jefferson");
				Option2.setText("George Washington");
				Option3.setText("Abraham Lincoln");
				Option4.setText("John Adams");
			}
			else if(count == 1) {
				Question.setText("2. What event marked the beginning of World War I?");
				Option1.setText("Assassination of Archduke Franz Ferdinand");
				Option2.setText("Signing of the Treaty of Versailles");
				Option3.setText("Bombing of Pearl Harbor");
				Option4.setText("Invasion of Poland");
			}
			else if(count == 2) {
				Question.setText("3. Who wrote The Communist Manifesto?");
				Option1.setText("Karl Marx");
				Option2.setText("Friedrich Engels");
				Option3.setText("Vladimir Lenin");
				Option4.setText("Leon Trotsky");
			}
			else if(count == 3) {
				Question.setText("4. Which ancient civilization built the Great Pyramid of Giza?");
				Option1.setText("Ancient Greece");
				Option2.setText("Ancient Rome");
				Option3.setText("Ancient Egypt");
				Option4.setText("Ancient Mesopotamia");
			}
			else if(count == 4) {
				Question.setText("5. What year did the Berlin Wall fall?");
				Option1.setText("1961");
				Option2.setText("1989");
				Option3.setText("1991");
				Option4.setText("1975");
			}
			else if(count == 5) {
				Question.setText("6. Who was the first female Prime Minister of the United Kingdom?");
				Option1.setText("Margaret Thatcher");
				Option2.setText("Angela Merkel");
				Option3.setText("Theresa May");
				Option4.setText("Indira Gandhi");
			}
			else if(count == 6) {
				Question.setText("7. What was the name of the ship that carried the Pilgrims to America in 1620?");
				Option1.setText("Santa Maria");
				Option2.setText("Mayflower");
				Option3.setText("Nina");
				Option4.setText("Pinta");
			}
			else if(count == 7) {
				Question.setText("8.Who was the leader of the Soviet Union during the Cuban Missile Crisis?");
				Option1.setText("Joseph Stalin");
				Option2.setText("Nikita Khrushchev");
				Option3.setText("Vladimir Lenin");
				Option4.setText("Mikhail Gorbachev");
			}
			else if(count == 8) {
				Question.setText("9. In what year did Christopher Columbus first voyage to the Americas?");
				Option1.setText("1492");
				Option2.setText("1588");
				Option3.setText("1607");
				Option4.setText("1519");
			}
			else if(count == 9) {
				Question.setText("10. Who was the Egyptian queen known for her relationships with Julius Caesar and Mark Antony?");
				Option1.setText("Cleopatra");
				Option2.setText("Nefertiti");
				Option3.setText("Hatshepsut");
				Option4.setText("Ramses II");
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
			        switchScene(stage, "Result_History.fxml");
			       
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
			        switchScene(stage, "Result_History.fxml");

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
			        switchScene(stage, "Result_History.fxml");

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
			        switchScene(stage, "Result_History.fxml");

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
					if(answer.equals("George Washington")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 1) {
					if(answer.equals("Assassination of Archduke Franz Ferdinand")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 2) {
					if(answer.equals("Karl Marx")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 3) {
					if(answer.equals("Ancient Egypt")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 4) {
					if(answer.equals("1989")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 5) {
					if(answer.equals("Margaret Thatcher")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 6) {
					if(answer.equals("Mayflower")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 7) {
					if(answer.equals("Nikita Khrushchev")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 8) {
					if(answer.equals("1492")) {
						return true;
					}else {
						return false;
					}
				}
				if(count == 9) {
					if(answer.equals("Cleopatra")) {
						return true;
					}else {
						return false;
					}
				}
				return false;
			}
}
