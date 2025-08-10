package creating_a_User_Interface_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

import java.util.Random;




public class UI_Home extends Application {
	
	TextField centerDisplay;
	String text;
	String message;
	BorderPane root;
	Scene scene1;
	
	@Override
    public void start(Stage stage) {
		stage.setTitle("Custom User Interface");
		
		//menu Items
		MenuItem one = new MenuItem("Print DateTime to TextBox");
		MenuItem two = new MenuItem("Save to 'log.txt'");
		MenuItem three = new MenuItem("Generate Random Hue of Green");
		MenuItem four = new MenuItem("Exit");
		
		//menus
		Menu menu = new Menu("Click Here");
		menu.getItems().addAll(one, two, three, four);
		
		//create Scene
		root = new BorderPane();
		MenuBar menuBar = new MenuBar(menu);
		root.setTop(menuBar);
		
		//TextField.centerDisplay = new TextField("Info will be displayed here");
		centerDisplay = new TextField("Info will be displayed here");
		root.setCenter(centerDisplay);
		
		one.setOnAction(e -> setCurrentDateTime());
		two.setOnAction(e -> createLogFile());
		three.setOnAction(e -> changeHue());
		four.setOnAction(e -> System.exit(0));
		
		scene1 = new Scene(root, 400, 200);
		stage.setScene(scene1);
		stage.show();
		
	}
	
	private void setCurrentDateTime() {
		LocalDateTime time = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    
	    centerDisplay.setText(formatter.format(time));
	};
	
	private String createLogFile() {
		message = "Unknown issue.  Contact supervisor.";
		
		text = centerDisplay.getText();
		if (text == null) {
			text = "No text found";
			//message = text;
		}
		
		message = text;
		
		try {
			Files.writeString(Paths.get("log.txt"), text + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
					
		} catch(IOException e) {
			message = e.toString();
			
		}
		
		
		centerDisplay.setText(message + " saved to log.txt");
		return message;
	};
	
	private void changeHue() {
		
		Random rnd = new Random();
		
		double hue = rnd.nextDouble() * 0.23 + 0.28;  
		Color randomGreen = Color.hsb(hue * 360, 0.5 + rnd.nextDouble() * 0.4, 0.6 + rnd.nextDouble() * 0.3);

		
		scene1.setFill(randomGreen);
		root.setBackground(new Background(
		        new BackgroundFill(randomGreen, null, null)));
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
