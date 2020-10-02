package org.millardps.MapMaker;


import java.util.Random;
import java.util.Scanner;


import javax.swing.JOptionPane;


public class Npc {
	private String name;
	private String flavor;
	private int[] location;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);
	
	public Npc(){
		
		location = this.setLocation();
		name = setName();
		flavor = setFlavor();
	}
	
	public Npc(String name1){
		location = this.setLocation();
		name = name1;
		flavor = " First Find the key, then find the chest.";
	}
	
	public String setName(){
		name = " ";
		for(int i=0; i<10;i++){
			int n = rand.nextInt(61)+61;
			name += (char)n;
		}
		return name;
	}
	
	public String setFlavor(){
		flavor = scan.nextLine();
		return flavor;
	}
	
	public void showFlavor(){
		JOptionPane.showMessageDialog( null, flavor, name,
			    JOptionPane.PLAIN_MESSAGE);
	}
	
	public int[] setLocation(){
		int[] loc = {0, 0};
		return loc;
	}
	
	public void setNewLocation(int[] a){
		location = a;
	}
	
	public int[] getLocation(){
		return location;
	}
	
	public static void main(String[] args) {
		Npc npc = new Npc();
		npc.showFlavor();
	}
}

