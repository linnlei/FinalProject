package NyaProjektarbetet;

import java.awt.Image;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This class saves the specific things that makes the garden.
 * 
 * @author Jenny Forsberg
 * @version 2015-03-04
 */

public class Garden extends Room implements Serializable{
	
	private HashMap<Integer, String> gardenItems;  
	private String gardenPicture;
	
	
	public Garden(){
		gardenItems = new HashMap<Integer, String>();
		gardenPicture="pictures/strand.jpg"; 
		}
	
	
	/**
	* getGardenItems - gets all the pictures and their places in garden .
	*
	* @return  	A hashmap where picture filenames are saved with the index of the buttons where they are saved. 
	*       
	*/	
	public HashMap<Integer, String> getGardenItems(){
		return gardenItems;
	}
	
		
	/**
	* add - saves a picture of a brick at at specific place in the garden. 
	*
	* @param  lopnr   the position of a specific place in the garden.
	* @param  icon    a string that represents a picture of a brick.
	* 
	*/
	public void addItem(int lopnr, String icon){
			gardenItems.put(lopnr, icon); 
	}
	
		
	/**
	* removeItem - removes a picture of a brick at at specific place in the garden.
	*
	* @param  lopnr   the position of a specific place in the garden.
	*
	*/
	public void removeItem(int lopnr){
			gardenItems.remove(lopnr); 
	}
	
	
	/**
	* getGardenIcon - gets the picture of a brick saved at a specific place in the garden.
	*
	* @param  	lopnr   the position of a specific place in the garden.
	* @return			a string that represents the picture saved at this position.                
	*/
	public String getGardenIcon(int lopnr){
		
		return  gardenItems.get(lopnr);
	}
	
	
	/**
	* getPicture - gets the background picture of the room
	*
	* @param  	current		the name of the room type
	* @return				the filename of the background picture		              
	*/
	public String getPicture(String current)
	{
		return gardenPicture;
	}
	
	
}
