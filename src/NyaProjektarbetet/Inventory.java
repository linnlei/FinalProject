package NyaProjektarbetet;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;



public class Inventory extends Observable implements Serializable {
	private static final long serialVersionUID = 1L;
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
	}
	
}

	
	

