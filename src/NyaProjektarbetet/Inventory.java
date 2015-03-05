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
		Item blueBrick = new Item(10, 1, "BrickBlue.png", "Blå tegelsten");
		Item redBrick = new Item(20, 1, "BrickRed.png", "Röd tegelsten");
		Item pyramid1 = new Item(40, 2, "pyramid_vertical.png", "Vertikal pyramidsten");
		Item pyramid2 = new Item(40, 2, "pyramid_horizontal.png", "Horisontell pyramidsten");
		Item greenBrick = new Item(10, 1, "BrickGreen.png", "Grön tegelsten");
		Item pinkBrick = new Item(20, 1, "BrickPink.png", "Rosa tegelsten");
		Item turkosBrick = new Item(20, 1, "BrickTurkos.png", "Turkos tegelsten");
		Item yellowBrick = new Item(10, 1, "BrickYellow.png", "Gul tegelsten");
		Item blackBrick = new Item(30, 1, "BrickBlack.png", "Svart tegelsten");
		Item whiteBrick = new Item(30, 1, "BrickWhite.png", "Vit tegelsten");
		
		items.put(pyramid2, 0);
		items.put(pyramid1, 0);
		items.put(redBrick, 0);
		items.put(blueBrick, 0);
		items.put(greenBrick, 0);
		items.put(pinkBrick, 0);
		items.put(turkosBrick, 0);
		items.put(yellowBrick, 0);
		items.put(blackBrick, 0);
		items.put(whiteBrick, 0);
	}
	
}

	
	

