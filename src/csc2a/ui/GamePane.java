package csc2a.ui;

import java.io.File;
import java.util.ArrayList;

import csc2a.file.GameFileHandler;
import csc2a.model.GameObject;
import csc2a.model.Maze;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * 
 * GamePane provides a custom container to manage all game interactions
 * and host the GameCanvas
 * @author <YOUR DETAILS HERE>
 *
 */
public class GamePane extends StackPane {
	
	//Attributes
	private GameCanvas canvas; //You need the canvas so the visitor can draw on it
	private GameFileHandler gfh = new GameFileHandler();
	private Maze m = new Maze();
	/**
	 * Default constructor
	 */
	public GamePane() {
		super();
		//Create the canvas to draw on
		canvas = new GameCanvas();	
		//Bind the width and height so the canvas resizes with window		
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		/* TODO: Construct your GamePane as you see fit */
		/* TODO: Create MenuBar with Menu and MenuItem */
		MenuBar mBar = new MenuBar();
		Menu menu1 = new Menu("File");
		mBar.getMenus().add(menu1);

		MenuItem mi1 = new MenuItem("Open");
		menu1.getItems().add(mi1);
		/* TODO: Create File Chooser pointing to data folder*/
		final FileChooser fChooser = new FileChooser();
		/* TODO: Create Event Listener, read from file and setItems (see below) */
		
		mi1.setOnAction(e -> {
			
			fChooser.setTitle("Select File");
			File file = fChooser.showOpenDialog(null);
			
			if(file != null) {
				//set canvas data after reading
				ArrayList<GameObject> i = GameFileHandler.readPlayer(file);
				//TO DO do something with i
				setItems(i);
				
			}			
		});


		/* TODO: Add children to GamePane */
		VBox root = new VBox();
		root.getChildren().addAll(mBar,canvas);
		this.getChildren().add(root);
		
	}

	/* TODO: JavaDoc */
	public void setItems(ArrayList<GameObject> items)
	{
		update();   
		/* TODO: Do you game logic using Event Handlers*/
		//For example
		this.setOnKeyPressed((event) -> {

			String code = event.getCode().toString();
			if(code == "UP") {
				up();
			}else if(code == "DOWN") {
				down();
			}else if(code == "LEFT") {
				left();
			}else if(code == "RIGHT") {
				right();
			}
			
		});	
		canvas.setItems(items);		
	}
	
	private void up() {
		// TODO Auto-generated method stub
		m = gfh.getMap();
		int x = gfh.getPX();
		int y = gfh.getPY()- 5;
		String near = m.getMap(Math.round(x/30), Math.round(y/30));
		if(near.contentEquals(".")) {gfh.setPlayer(1, ".");update();}
		else if(near.contentEquals("#")) {}
		else if(near.contentEquals("*")) {Platform.exit();}
	}
	private void down() {
		// TODO Auto-generated method stub
		m = gfh.getMap();
		int x = gfh.getPX();
		int y = gfh.getPY() - 5;
		String near = m.getMap(Math.round(x/30), Math.round(y/29));
		if(near.contentEquals(".")) {gfh.setPlayer(2, ".");update();}
		else if(near.contentEquals("#")) {}
		else if(near.contentEquals("*")) {Platform.exit();}
	}		
	private void right() {
		// TODO Auto-generated method stub
		m = gfh.getMap();
		int x = gfh.getPX()+ 5;
		int y = gfh.getPY();
		String near = m.getMap(Math.round(x/30), Math.round(y/30));
		if(near.contentEquals(".")) {gfh.setPlayer(3, ".");update();}
		else if(near.contentEquals("#")) {}
		else if(near.contentEquals("*")) {Platform.exit();}
	}
	private void left() {
		// TODO Auto-generated method stub
		m = gfh.getMap();
		int x = gfh.getPX()- 5;
		int y = gfh.getPY();
		String near = m.getMap(Math.round(x/30), Math.round(y/30));
		if(near.contentEquals(".")) {gfh.setPlayer(4, ".");update();}
		else if(near.contentEquals("#")) {}
		else if(near.contentEquals("*")) {Platform.exit();}
	}
	private void update() {
		// TODO Auto-generated method stub
		canvas.update();
	}
}	
	
	

