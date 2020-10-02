package org.millardps.MapMaker;

public class Player {
	private String[] items;
	private static int[] location;
	private int[] visibleLocations;
	private int gold;
	private boolean key;
	public Player(){
		location = this.setLocation();
		key = false;
	}
	public int[] setLocation(){
		int[] loc = {0, 0};
		return loc;
	}
	public void setNewLocation(int[] a){
		System.out.println(a[0] + " This is new location from player" + a[1]);
		location = a;
	}
	public String[] getItems(){
		return items;
	}
	public int[] getLocation(){
		return location;
	}
	public void getGold(int amount){
		gold += amount;
	}
	public boolean hasKey(){
		if(key == true){
			return true;
		}
		else
			return false;
	}
	public void getKey(){
		key = true;
	}
}
