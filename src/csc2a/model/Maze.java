package csc2a.model;

import java.io.File;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.image.Image;

/* TODO: Imports */

/**
 * Subclass of {@link Zone} for Zones that are active.
 * 
 * ONLY EDIT THE VALIDATE METHOD BELOW!
 * 
 * @author Mr. Greaves
 *
 */
public class Maze 
{
	public String Map[] = new String[40];
	private Image path,wall,goal;
	public Maze() {
	//add images
		setWall(new Image(new File("asteroid30.jpg").toURI().toString(),300, 300, true, true));
		setPath(new Image(new File("stars30.png").toURI().toString(),300, 300, true, true));
	    setGoal(new Image(new File("black30.jpg").toURI().toString(),300, 300, true, true));
		
	}
	

	/**
	 * Accept a visitor
	 * @param visitor
	 */
	public void accept(iRenderVisitor visitor)
	{
		visitor.render(this);
	}
	
	public String getMap(int x, int y) {
		String index = Map[y].substring(x,x+1);
		return index;
	}
	
	public Image getPath() {
		return path;
	}

	public void setPath(Image path) {
		this.path = path;
	}

	public Image getWall() {
		return wall;
	}

	public void setWall(Image wall) {
		this.wall = wall;
	}

	public Image getGoal() {
		return goal;
	}

	public void setGoal(Image goal) {
		this.goal = goal;
	}	
	

}
