package csc2a.ui;

import java.io.File;
import java.util.ArrayList;

import csc2a.designpatterns.RenderGameObjectVisitor;
import csc2a.file.GameFileHandler;
import csc2a.model.GameObject;
import csc2a.model.GameObjectContainer;
import csc2a.model.Maze;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 * 
 * Canvas used to render all of your GameObjects using the Visitor
 * This is the Client in the Visitor Design Pattern
 * @author  <YOUR DETAILS HERE>
 *
 */
public class GameCanvas extends Canvas{
	
	//Attributes
	RenderGameObjectVisitor visitor = null;
	GraphicsContext gc = null;
	private GameFileHandler gfh = new GameFileHandler();
	private Maze maze = null;
	
	private GameObjectContainer<GameObject> G = new GameObjectContainer<GameObject>();
	/**
	 * Default Constructor
	 */
	public GameCanvas() {

		maze = new Maze();
		visitor = new RenderGameObjectVisitor();
		setHeight(10000);
		setWidth(10000);
	
	}
	
	/* TODO: Set your GameObjects and redrawCanvas() */
	public void setItems(ArrayList<GameObject> items)
	{
	}	
	/**
	 * Method used to redraw the canvas whenever called
	 */
	public void redrawCanvas(){
		/* TODO: get GraphicsContext */
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, 10*50, 10*50);

		File file = new File("Maze1.txt");
		gfh.readMap(file);
		maze = gfh.getMap();
		for(int rows = 0; rows < 20; rows++) {
			for(int cols = 0; cols < 40; cols++) {
			 if(maze.getMap(cols, rows).contentEquals(".")){
				 	 gc.drawImage(maze.getPath(),cols,rows);
					/* gc.setFill(Color.BLACK);
					 gc.fillRect(cols*30,rows*30,50,50);*/
			 }else if(maze.getMap(cols, rows).contentEquals("#")) {
				 gc.drawImage(maze.getWall(),cols,rows);
				 /*gc.setFill(Color.RED);
				 gc.fillRect(cols*30,rows*30,50,50);*/
			 }else if(maze.getMap(cols, rows).contentEquals("*")) {
				 gc.drawImage(maze.getGoal(),cols,rows);
				 /*gc.setFill(Color.DARKSLATEGRAY);
				 gc.fillRect(cols*30,rows*30,50,50);*/
			 }else if(maze.getMap(cols, rows).contentEquals("*")) {
				 gc.drawImage(maze.getGoal(),cols,rows);
				 /*gc.setFill(Color.DARKSLATEGRAY);
				 gc.fillRect(cols*30,rows*30,50,50);*/
			 }

				
			}
		}
		/* TODO: set Visitor GraphicsContext */
		visitor.setGraphicsContext(gc);
		/* TODO: Iterate through ALL GameObjects (Using GameObjectContainers) */
		for(GameObject z : G) {
		/* TODO: Get EACH GameObject to accept() the Visitor */
			z.accept(visitor);
			System.out.println("Created");
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		G.addGameObject(gfh.getPlayer());
		redrawCanvas();
	}


}