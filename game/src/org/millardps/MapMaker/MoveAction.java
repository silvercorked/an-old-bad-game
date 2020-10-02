package org.millardps.MapMaker;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class MoveAction extends AbstractAction {
	private int newX;
	private int newY;
	private Player x;
	private int originalX;
	private int originalY;
	private int[] locs;
	private int direction;
	public boolean keyPressed;
	
	public MoveAction(int newX1, int newY1, Player x1, int direction1){
		this.newX = newX1;
		this.newY = newY1;
		this.x = x1;
		direction = direction1;
		locs = new int[1];
		keyPressed = false;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getWhen() + " is when this happened!");
		originalX += newX;
		originalY += newY;
		locs[0] = originalX;
		locs[1] = originalY;
		x.setNewLocation(locs);
		keyPressed = true;
		
	}
	public int getDirection(){
		return direction;
	}
	public boolean getKeyPressed(){
		return keyPressed;
	}
}
