package NyaProjektarbetet;

import java.io.Serializable;
import java.util.Observable;

public class Player extends Observable implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private int level;
	private int money;
	public Inventory myInventory;
	
	public Player(){
		level = 1;
		money = 100;
	}
	
	public void setInventory(Inventory in){
		myInventory = in;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String name){
		userName = name;
	}
	
	public int getLevel(){
		return level;
	}
	
	
	//eventuell metod för att levla upp beroende på hur levlandet ska fungera
	public void levelUp(){
		level = level + 1;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void changeMoney(int value){ //value kan förstås vara både positivt och negativt
		money = money + value;
		setChanged();
		notifyObservers(money);
	}
}
