package NyaProjektarbetet;
import javax.swing.*;

import java.awt.*;


/**
* The JPanelWithBackground class adds a scaled background to a panel. Can use the setLayout(null)
* and add-methods to add visible/invisible buttons onto the picture.            
*/

public class JPanelWithBackground extends JPanel {
	private static final long serialVersionUID = 1L;
	Image bgimage = null;

	/**
	* Constructor of the class JPanelWithBackground.
	*
	* @param  	fileName		Filename of the picture to use as background           
	*/
	public JPanelWithBackground(String fileName /*,UserInterface ui*/) {
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage(fileName);
		mt.addImage(bgimage, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	* paintComponent - Paints the graphic
	*
	* @param  	g		The graphic to draw            
	*/
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimage, 0, 0, getSize().width, getSize().height, null);
	}
	
	/**
	* changePanelImg - Changes the background picture
	*
	* @param  	fileName	Filename of the picture to change to              
	*/
	public void changePanelImg(Image fileName) {
		bgimage = fileName;

	}
}
