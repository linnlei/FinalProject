package NyaProjektarbetet;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;

/**
 * 
 * Just nu inneh�ller inventory en hashmap med bluebrick o redbrick bara
 * F�r att testa detta kan man k�ra den bortkommenterade raden
 *
 */

public class Inventory extends Observable implements Serializable {
	private HashMap<Item, Integer> items;
	
	public Inventory() {
		items = new HashMap<Item, Integer>();
		createInventory();
	}
	
	public HashMap<Item, Integer> getInventory() {
		return items;
	}
	
	public void updateInventory(Item item, Integer amount) {
		int total = (items.get(item)) + amount;
		items.put(item, total);
		setChanged();
		notifyObservers(item);
	}
	
	private void createInventory(){
		//******* L�gg in nya items s� att de med H�GST level l�ggs till F�RST med items.put! 
		//(Detta f�r tt de ska hamna i r�tt ordning i shop)
		
		Item blueBrick = new Item(10, 1, "BrickBlue.png", "Bl� tegelsten");
		Item redBrick = new Item(20, 1, "BrickRed.png", "R�d tegelsten");
		Item fishBrick = new Item(30, 2, "fish.png", "Fisksten");
		Item pyramid1 = new Item(40, 1, "pyramid_vertical.png", "Vertikal pyramidsten");
		Item pyramid2 = new Item(40, 1, "pyramid_horizontal.png", "Horisontell pyramidsten");
		
		items.put(pyramid2, 0);
		items.put(pyramid1, 0);
		items.put(fishBrick, 0);
		items.put(redBrick, 0);
		items.put(blueBrick, 0);
		//JOptionPane.showMessageDialog(gui.myFrame(), items.get(blueBrick), "", JOptionPane.INFORMATION_MESSAGE);
	}
	
}

	
	

