package maven.diplom;


import java.util.Random;
import java.util.concurrent.Semaphore;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import maven.diplom.Chooser;
import maven.diplom.Finish;
import maven.diplom.Horse3;

public class Main extends Application{

	private Stage primaryStage;
	private int result = 0;
	private Screen screen = Screen.getPrimary();
	private Rectangle2D bounds = screen.getVisualBounds();
	private ImageView iv;
	private ImageView enemy1 = new ImageView("/Andy.png");
	private ImageView enemy2 =  new ImageView("/Буч.png");
	private ImageView enemy3 = new ImageView("/клаудий.png");
	private ImageView enemy4 = new ImageView("/виктор.png");
	private Chooser chooser1 ;
	private Chooser chooser2 ;
	private Chooser chooser3 ;
	private Chooser chooser4 ;
	private Thread thr1;
	private Thread thr2;
	private Horse3 horse2;
	private ImageView resultWinner = new ImageView();
	private ImageView horseChoose;
	private String name;
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			this.primaryStage = primaryStage;
			
			primaryStage.setX(bounds.getMinX());
			primaryStage.setY(bounds.getMinY());
			primaryStage.setWidth(bounds.getWidth());
			primaryStage.setHeight(bounds.getHeight());
			GridPane root = new GridPane();
			root.setId("root1");
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Label label = new Label("Enter your name");
			label.setId("label1");
			Button button = new Button("OK");
			Button button2 = new Button("EXIT");
			TextField text = new TextField();
			root.setPadding(new Insets(25,25,25,25));
			root.setVgap(10);
			root.setHgap(10);
			root.setAlignment(Pos.CENTER);
			root.add(label, 0, 0);
			root.add(text, 1, 0);
			root.add(button,1 , 2);
			root.add(button2, 1, 3 );
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			this.primaryStage.setMaximized(true);
			primaryStage.show();
			
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					if(text.getText() != null) 
					{
						name = text.getText();
						faceStage();
					}
					
				}});
			button2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					Platform.exit();
					
				}});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void faceStage() 
	{
		
		GridPane root = new GridPane();
		root.setId("faceRoot");
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Label label = new Label("Hello " + name + " Choose your Character");
		label.setId("faceLabel");
		ImageView iv1 = new ImageView("/лиза.png");
		ImageView iv2 = new ImageView("/Марти.png");
		ImageView iv3 = new ImageView("/денис.png");
		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();
		button1.setGraphic(iv1);
		button2.setGraphic(iv2);
		button3.setGraphic(iv3);
		
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		root.add(label, 1, 0);
		root.add(button1, 0, 2);
		root.add(button2, 1, 2);
		root.add(button3, 2, 2);
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				iv = (ImageView) button1.getGraphic();
				horseChoosingStage();
				
			}});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				iv = (ImageView) button2.getGraphic();
				horseChoosingStage();
				
			}});
		button3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				iv = (ImageView) button3.getGraphic();
				horseChoosingStage();
				
			}});
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}	
	
	public void horseChoosingStage() 
	{
		GridPane root = new GridPane();
		Label label = new Label(name);
		Label label1 = new Label("Claudiy");
		Label label2 = new Label("Andy");
		Label label3 = new Label("Buch");
		Label label4 = new Label("Viktor");
		Label label5 = new Label("You need to choose your horse");
		
		
		label5.setId("faceLabel");
		Button button1 = new Button();
		Button buttonConfirm = new Button("Confirm");
		button1.setGraphic(new ImageView("/unnamed.png"));
		Button button2 = new Button();
		button2.setGraphic(new ImageView("/unnamed1.png"));
		Button button3 = new Button();
		button3.setGraphic(new ImageView("/unnamed2.png"));
		Button button4 = new Button();
		button4.setGraphic(new ImageView("/unnamed3.png"));
		Button button5 = new Button();
		button5.setGraphic(new ImageView("/unnamed4.png"));
		label.setId("name");
		label1.setId("name");
		label2.setId("name");
		label3.setId("name");
		label4.setId("name");
		root.setId("faceRoot");
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		root.add(label5, 1, 0);
		root.add(iv, 0, 1);
		root.add(label,0,2);
		root.add(button1, 0, 3);
		root.add(enemy1, 1, 1);
		root.add(label1,1,2);
		root.add(button2, 1, 3);
		root.add(enemy2, 2, 1);
		root.add(label2,2,2);
		root.add(button3, 2, 3);
		root.add(enemy3, 3, 1);
		root.add(label3,3,2);
		root.add(button4, 3, 3);
		root.add(enemy4, 4, 1);
		root.add(label4,4,2);
		root.add(button5, 4, 3);
		root.add(buttonConfirm, 0, 10);
		Button[] btn = {button1,button2,button3,button4,button5};
		Random rnd = new Random();
		Semaphore sem = new Semaphore(1,true);
	
		for(int i = 0; i < btn.length;i++) 
		{
			int j = rnd.nextInt(btn.length);
			Button tmp = btn[i];
			btn[i] = btn[j];
			btn[j] = tmp;
		}
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button1.setDisable(true);
				horseChoose = new ImageView("/unnamed.png");
				chooser1 = new Chooser(label1.getText(), btn, sem);
				chooser2 = new Chooser(label2.getText(), btn, sem);
				chooser3 = new Chooser(label3.getText(), btn, sem);
				chooser4 = new Chooser(label4.getText(), btn, sem);
				
				
				
			}});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button2.setDisable(true);
				horseChoose = new ImageView("/unnamed1.png");
				chooser1 = new Chooser(label1.getText(), btn, sem);
				chooser2 = new Chooser(label2.getText(), btn, sem);
				chooser3 = new Chooser(label3.getText(), btn, sem);
				chooser4 = new Chooser(label4.getText(), btn, sem);
				
				
				
			}});
		button3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button3.setDisable(true);
				horseChoose = new ImageView("/unnamed2.png");
				chooser1 = new Chooser(label1.getText(), btn, sem);
				chooser2 = new Chooser(label2.getText(), btn, sem);
				chooser3 = new Chooser(label3.getText(), btn, sem);
				chooser4 = new Chooser(label4.getText(), btn, sem);
				
				
			}});
		button4.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					button4.setDisable(true);
					horseChoose = new ImageView("/unnamed3.png");
					chooser1 = new Chooser(label1.getText(), btn, sem);
					chooser2 = new Chooser(label2.getText(), btn, sem);
					chooser3 = new Chooser(label3.getText(), btn, sem);
					chooser4 = new Chooser(label4.getText(), btn, sem);
					
					
				}});
			button5.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					button5.setDisable(true);
					horseChoose = new ImageView("/unnamed4.png");
					chooser1 = new Chooser(label1.getText(), btn, sem);
					chooser2 = new Chooser(label2.getText(), btn, sem);
					chooser3 = new Chooser(label3.getText(), btn, sem);
					chooser4 = new Chooser(label4.getText(), btn, sem);
					
				}});
			buttonConfirm.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					roundStage();
				}});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void roundStage() 
	{
		GridPane root = new GridPane();
		Button time = new Button("Start the game");
		time.setId("timeLabel");
		root.setId("faceRoot");
		Label label1 = new Label("Get ready");
		label1.setId("roundLabel");
		ImageView iv1 = new ImageView();
		iv.setImage(iv.getImage());
		ImageView iv2 = new ImageView();
		iv2.setImage(enemy1.getImage());
		ImageView iv3 = new ImageView();
		iv3.setImage(enemy2.getImage());
		ImageView iv4 = new ImageView();
		iv4.setImage(enemy3.getImage());
		ImageView iv5 = new ImageView();
		iv5.setImage(enemy4.getImage());
		label1.setId("faceLabel");
		root.setVgap(10);
		root.setHgap(10);
		root.setAlignment(Pos.CENTER);

		root.add(label1, 2, 0);
		root.add(iv, 0, 1);
		root.add(horseChoose,0,2);
		root.add(enemy1, 1, 1);
		root.add(chooser1.getHorse(),1,2);
		root.add(enemy2, 2, 1);
		root.add(chooser2.getHorse(), 2, 2);
		root.add(enemy3,3,1);
		root.add(chooser3.getHorse(), 3, 2);
		root.add(enemy4, 4, 1);
		root.add(chooser4.getHorse(),4,2);
		root.add(time, 2, 3);
		time.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				raceStage();
			}});
		
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public  void raceStage() 
	{
		ImageView selectedImage=new ImageView();
		selectedImage.setImage(horseChoose.getImage());
		Button button = new Button("Next");
		Random rnd = new Random();
		for(int i = 0;;i++) 
		{
			result = rnd.nextInt(4) + 1;
			break;
		}
		GridPane root = new GridPane();
		Finish flag = new Finish();
		root.setId("root3");
		root.setAlignment(Pos.BOTTOM_LEFT);
		root.add(selectedImage,0,10);
		if(result == 1) 
		{
			root.add(chooser1.getHorse(),0,0);
		}else
			if(result == 2) 
			{
				root.add(chooser2.getHorse(),0,0);
			}else
				if(result == 3) 
				{
					root.add(chooser3.getHorse(),0,0);
				}else
					if(result == 4) 
					{
						root.add(chooser4.getHorse(),0,0);
					}
		
		root.add(button, 0, 10);
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		final KeyCombination z=new KeyCodeCombination(KeyCode.Z);
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				resultStage();
				
			}});
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public synchronized void handle(KeyEvent event) {
				if(z.match(event)) {
					
					Horse3 horse1= new Horse3("Ptichcka",selectedImage,screen,flag, resultWinner );
					if(result == 1) 
					{
						horse2= new Horse3("Plotva",chooser1.getHorse(),screen,flag, resultWinner);
					}else
						if(result == 2) 
						{
							horse2= new Horse3("Plotva",chooser2.getHorse(),screen,flag, resultWinner);
						}else
							if(result == 3) 
							{
								horse2= new Horse3("Plotva",chooser3.getHorse(),screen,flag, resultWinner);
							}else
								if(result == 4) 
								{
									horse2= new Horse3("Plotva",chooser4.getHorse(),screen,flag, resultWinner);
								}
					thr1 = new Thread(horse1);
					thr1.setDaemon(true);
					thr1.start();
					thr2 = new Thread(horse2);
					thr2.setDaemon(true);
					thr2.start();
					
					
					
					
					
				}
				
			}
		});
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
			
		
	}
	
	

	
	public static void main(String[] args) {
		launch(args);
	}


	public void resultStage() {
		GridPane root = new GridPane();
		Label label = new Label("The Winner");
		Button button = new Button("New race");
		label.setId("roundLabel");
		root.setAlignment(Pos.CENTER);
		root.setVgap(10);
		root.setHgap(10);
		root.setId("faceRoot");
		root.add(label, 0, 0);
		root.add(resultWinner, 0, 1);
		root.add(button, 0, 2);
		button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				horseChoosingStage();
				
			}});
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
		
	}


