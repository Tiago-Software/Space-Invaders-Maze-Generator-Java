package csc2a.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import csc2a.model.GameObject;
import csc2a.model.Maze;
import csc2a.model.Player;

/**
 * 
 * Class to handle all interactions with files
 * @author <YOUR DETAILS HERE>
 *
 */
public class GameFileHandler {
	/* TODO: JavaDoc */

	public static Player player = null;
	public static Maze maze = new Maze();
	/**
	 * @param GameFile
	 * @return
	 */
	/**
	 * 
	 */
	public GameFileHandler() {
		
	}
	
	public static ArrayList<GameObject> readPlayer(File PlayerFile)
	{
/* TODO: Create ArrayList for items */
		ArrayList<GameObject> items = new ArrayList<>();	
/* TODO: Create Scanner */
		Scanner scanPlayer = null;
		
/* TODO: Read each line of the file      */
		try {
			scanPlayer = new Scanner(PlayerFile);
			 player = new Player(30,540);//row-col position
			 items.add(player);
		  
				 }catch(FileNotFoundException fnfex) {
				 	System.err.format("Error: File %s does not exist%");
			 }finally {
 /* TODO: Free resources                  */					
					if(scanPlayer != null) {
						scanPlayer.close();
						}
			 }
/* TODO: Return ArrayList */
		return items;
	}
	
	 
	public void readMap(File Mapfile)
	{	
/* TODO: Create Scanner */
		Scanner scanMaze = null;
		
/* TODO: Read each line of the file      */
		try {
			scanMaze  = new Scanner(Mapfile);
			 while(scanMaze.hasNextLine()) {
				 for(int i = 0; i < 20; i++) {
					 System.out.println(i);
					 maze.Map[i] = scanMaze.nextLine();
					 System.out.println(maze.Map[i] );
				 }
			 }
				 }catch(FileNotFoundException fnfex) {
				 	System.err.format("Error: File %s does not exist%");
			 }finally {
/* TODO: Free resources                  */					
					if(scanMaze != null) {
						scanMaze.close();
						}
			 }
	}
	
	public GameObject getPlayer() {
		return GameFileHandler.player;
		
	}
	public int getPX() {
		return GameFileHandler.player.getX();
		
	}
	public int getPY() {
		return GameFileHandler.player.getY();
		
	}
	public Maze getMap() {
		return GameFileHandler.maze;
		
	}
	
	public void setPlayer(int A, String C) {
		player.move(A, C);
	}
}
