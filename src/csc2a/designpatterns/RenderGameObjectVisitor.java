package csc2a.designpatterns;

import csc2a.model.Maze;
import csc2a.model.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * ConcreteVisitor class
 * Used to visit each GameObject and render them onto the GameCanvas
 * @author  Tiago Pinto
 *
 */
public class RenderGameObjectVisitor implements iRenderVisitor{
	
	//Attributes
	private GraphicsContext	graphics;

	/* TODO: JavaDoc */
	public GraphicsContext getGraphicsContext()
	{
		return graphics;
	}

	/* TODO: JavaDoc */
	public void setGraphicsContext(GraphicsContext graphics)
	{
		this.graphics = graphics;
	}
	
	/**
	 * Mutator for the GraphicsContext from the GameCanvas
	 * Used to set gc so the Visitor can draw things on the Canvas
	 * @param gc the GraphicsContext from the GameCanvas
	 */
	
	/* TODO: render(YourGameObjectA a){} method */
	/* TODO: JavaDoc */
	@Override
	public void render(Player player)
	{
		/* TODO: Get location to start drawing */
		double x = ((Point2D) player.getLocation()).getX();
		/* TODO: Get location to start drawing */
		double y = ((Point2D) player.getLocation()).getY();
		/* TODO: Draw with correct colour */
		graphics.setFill(Color.YELLOW);
		graphics.fillRect(x,y,30,30);
		
		graphics.drawImage(player.getPImage(),y*30,x*30,30,30);
		/* TODO: Draw with correct shape(s) */
		/* TODO: Draw textual information */
		/*String text = active.getExport().toString();
		graphics.setStroke(Color.BLACK);
		graphics.strokeText("Exports: " + text , x+15, y+20);*/
	}
	/* TODO: render(YourGameObjectB b){} method */

	@Override
	public void render(Maze maze) {
		// TODO Auto-generated method stub
		
	}
	
	// ...
	
	/* TODO: render(YourGameObjectC m){} method */
	
	

}
