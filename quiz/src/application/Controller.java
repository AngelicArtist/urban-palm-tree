package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Controller {
	public static String useraccount;
//login / create account / home page 
	//buttons for login
	@FXML
	private Button quit;
	@FXML
	private Label error;
	@FXML
	private Button Login;
	@FXML
	private PasswordField password;
	@FXML
	private TextField username;
	@FXML
	private Button createaccount;
	//-----------------------------------------------
	//Create account objects
	@FXML
	private Button CreateAccountlogin;
	@FXML
	private TextField CA_Firstname;
	@FXML
	private TextField CA_Lastname;
	@FXML
	private TextField CA_Password;
	@FXML
	private TextField CA_Username;
	@FXML
	private Button CA_Create;
	@FXML
	private Label CA_Error;
	//--------------------------------------------------------------
	//Home Objects
	@FXML
	private Button H_Login;
	@FXML
	private Button H_Art;
	@FXML
	private Button H_Math;
	@FXML
	private Button H_History;
	@FXML
	private Button H_Sciance;
	@FXML
	private Button Leaderboard;
	//----------------------------------------------------------------
	//Art Objects
	@FXML
	private Button Art_Home;
	
	
	

	//IMPORTANT
	//This is used to switch between scenes
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
//----------------------------------
    public static String getUsername() {
    	try {
			return useraccount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
//--------------------------------------------------------
	public void LoginButtonOnAction(ActionEvent e) {
		
		if(username.getText().isBlank() == false && password.getText().isBlank() == false) {
			ValidateLogin();
		}else {
			error.setText("Enter Username and Password.");
		}
		
	}
	
	//The Quit Button
	public void QuitOnAction(ActionEvent e) {
		Stage stage = (Stage) quit.getScene().getWindow();
		stage.close();
	}
	//login verifacation
	public void ValidateLogin() {
		DatabaseConnection ConnectNow = new DatabaseConnection();
		Connection connectDB = ConnectNow.getconnection();
		
		String verifyLogin = "SELECT count(1) FROM useraccount WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";
		try {
			
			Statement statemant = connectDB.createStatement(); 
			ResultSet queryResult = statemant.executeQuery(verifyLogin);
			
			
			while(queryResult.next()) {
				if(queryResult.getInt(1) == 1) {
					error.setText("Sucess");
					try {
						useraccount = username.getText();
				        Stage stage = (Stage) createaccount.getScene().getWindow();
				        switchScene(stage, "Home.fxml");

				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
				}else {
					error.setText("Invalin. Please Try Again.");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connectDB.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	//creating an account
	
	//button on login screen to bring to createte scene
	public void Create_Account_Button(ActionEvent e) {
	    try {
	        Stage stage = (Stage) createaccount.getScene().getWindow();
	        switchScene(stage, "CreateUserAccount.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//--------------------------------------------------------
	
	//create account scene
	//button to send back to login
	public void Back_To_Login(ActionEvent e) {
	    try {
	        Stage stage = (Stage) CreateAccountlogin.getScene().getWindow();
	        switchScene(stage, "Login.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
 
	public void Create_Account(ActionEvent a) {
	    DatabaseConnection ConnectNow = new DatabaseConnection();
	    Connection connectDB = ConnectNow.getconnection();

	    String verifyAccount = "SELECT count(1) FROM useraccount WHERE Username =(?)";
	    String CreateAccount = "INSERT INTO useraccount (Firstname, Lastname, Username, Password, History_Score, Math_Score, Sci_score, Art_score) VALUES (?,?,?,?,?,?,?,?)";

	    try {
	        PreparedStatement verifyStatement = connectDB.prepareStatement(verifyAccount);
	        verifyStatement.setString(1, CA_Username.getText());
	        ResultSet queryResult = verifyStatement.executeQuery();

	        while (queryResult.next()) {
	            if (queryResult.getInt(1) == 1) {
	                CA_Error.setText("Try a Different Username.");
	            } else {
	                PreparedStatement createStatement = connectDB.prepareStatement(CreateAccount);
	                createStatement.setString(1, CA_Firstname.getText());
	                createStatement.setString(2, CA_Lastname.getText());
	                createStatement.setString(3, CA_Username.getText());
	                createStatement.setString(4, CA_Password.getText());
	                createStatement.setInt(5, 0); // Set History_Score to 0
	                createStatement.setInt(6, 0); // Set Math_Score to 0
	                createStatement.setInt(7, 0); // Set Sci_score to 0
	                createStatement.setInt(8, 0); // Set Art_score to 0
	                createStatement.executeUpdate();
	                CA_Error.setText("Account Created.");
	                
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        CA_Error.setText("Try a Different Username.");
	    }finally {
	    	try {
				connectDB.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	//------------------------------------------------------------
	//home page
	//homepage back to login
	public void Home_Back_To_Login(ActionEvent e) {
	    try {
	        Stage stage = (Stage) H_Login.getScene().getWindow();
	        switchScene(stage, "Login.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//home page to art
	public void Home_to_Art(ActionEvent e) {
	    try {
	        Stage stage = (Stage) H_Art.getScene().getWindow();
	        switchScene(stage, "Art.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//home to Math
	public void Home_to_Math(ActionEvent e) {
	    try {
	        Stage stage = (Stage) H_Math.getScene().getWindow();
	        switchScene(stage, "Math.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//Home to History
	public void Home_to_History(ActionEvent e) {
	    try {
	        Stage stage = (Stage) H_History.getScene().getWindow();
	        switchScene(stage, "History.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//home to sciance
	public void Home_to_Sciance(ActionEvent e) {
	    try {
	        Stage stage = (Stage) H_Sciance.getScene().getWindow();
	        switchScene(stage, "Sciance.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//---------------------------------------------------------
	//Art page
	public void Art_to_Home(ActionEvent e) {
	    try {
	        Stage stage = (Stage) Art_Home.getScene().getWindow();
	        switchScene(stage, "Home.fxml");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	//hoem to scoreboard
	public void Home_To_scorebord(ActionEvent e) {
	    try {
	        Stage stage = (Stage) Leaderboard.getScene().getWindow();
	        switchScene(stage, "Scoreboard.fxml");
	        
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
}


