package csc2a.model;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import csc2a.designpatterns.iMovable;
import csc2a.designpatterns.iRenderVisitor;
import javafx.geometry.Point2D;
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
public class Player extends GameObject implements iMovable
{

	private int size;
	private Image pImage;

	/* TODO: JavaDoc comment */
	public static boolean validate(String line)
	{
		/* TODO: Regular Expression */
		Pattern pattern = Pattern.compile("\\d+[:]\\d+\\t\\d+");
		/* TODO: Match line to pattern */
		Matcher uMatcher = pattern.matcher(line);
		if(uMatcher.matches()) { return true;}else{ return false;}/* TODO: return a boolean (it matches: true or false) */
	}

	public Player(int i, int j)
	{
		super(i,j);
		setPImage(new Image(new File("asteroid.jpg").toURI().toString()));
		
	}

	/**
	 * Accept a visitor
	 * @param visitor
	 */
	@Override
	public void accept(iRenderVisitor visitor)
	{
		visitor.render(this);
	}

	/**
	 * Return a String representation of the current instance
	 */
	@Override
	public String toString()
	{
		// X_LOCATION:Y_LOCATION BUILT_SIZE
		System.out.println("%d:%d\t%d" + " "  + getLocation().getX() + " " +  getLocation().getY()  + " " +  getSize());
		return String.format("%d:%d\t%d", getLocation().getX(), getLocation().getY(), getSize());
	}

	public int getSize() {
		return size;
	}
	/**
	 * @return the size
	 */
	public int setSize(int Size)
	{
		return this.size = Size;
	}
	public int getX()
	{
		return (int) getLocation().getX();
	}
	
	public int getY()
	{
		return (int) getLocation().getY();
	}
	
	
	public Image getPImage() {
		return pImage;
	}

	public void setPImage(Image pImage) {
		this.pImage = pImage;
	}

	@Override
	public void move(int A, String C) {
		// TODO Auto-generated method stub
		int iMove = A;
		Point2D PL;
		switch(iMove) {
		case 1:
			//up
			PL = new Point2D(super.getXLocation(),super.getYLocation()-15);
			super.setLocation(PL);
			System.out.println("up");
			break;
		case 2:
			//down
			PL = new Point2D(super.getXLocation(),super.getYLocation()+15);
			super.setLocation(PL);
			System.out.println("Down");
			break;
		case 3:		
			//right
			PL = new Point2D(super.getXLocation()+15,super.getYLocation());
			super.setLocation(PL);
			System.out.println("right");
			break;
		case 4:
			//left
			PL = new Point2D(super.getXLocation()-15,super.getYLocation());
			super.setLocation(PL);
			System.out.println("left");
			break;
		}
		
		
	}
}
