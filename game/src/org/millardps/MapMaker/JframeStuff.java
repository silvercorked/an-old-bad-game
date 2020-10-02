package org.millardps.MapMaker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class JframeStuff {
	private JFrame frame;
	private JPanel[][] panes;
	private JLabel[][] label;
	private Player a;
	private int frameWidth;
	private int frameHeight;
	private PixelArt pix;
	private int[][] map1;
	
	public JframeStuff(int[][] map, int width, int height){
		a = new Player();
		pix = new PixelArt();
		map1 = map;
		frameWidth = 10;
		frameHeight = 10;
		label = new JLabel[10][10];
		System.out.println(width + "hehehe" + height);
		panes = createContentPanes(width, height);
		createFrame();
		addKeyListeners();
		setCharacter();
	}
	/**
	 * uses a path to find an image and create an imageicon
	 * @param path the path to the image
	 * @param description a description used to print when the file is found and successfully creates an imageicon
	 * @return the image icon
	 */
	protected ImageIcon createImageIcon(String path,String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	/**
	 * creates our JFrame and sets up the basic functions necessary for it
	 */
	public void createFrame(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			System.out.println("If this appears then the window will look ugly. So let's hope this never appears.");
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Poke-CopyRight");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(320, 320);
		frame.setResizable(false);
		setPanel();
		frame.setVisible(true);
	}
	/**
	 * adds keyListeners to the frame
	 * this also ends up functioning as a major way for us to process data that the player walks upon, such as keys and chests.
	 */
	public void addKeyListeners(){
		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("got key listener added2321321321");
				int x = a.getLocation()[0];
				int y = a.getLocation()[1];
				int newX = x;
				int newY = y;
				System.out.println(x + " this is in keylistender " + y);
				int direction = 0; 
		        int key = e.getKeyCode();
		        switch(key){
		        case (KeyEvent.VK_LEFT):
		        	y -= 1;
		        	System.out.println(x + " left " + y);
		        	direction = 3;
		        	break;
		        case (KeyEvent.VK_RIGHT):
		        	y += 1;
		        	System.out.println(x + " right " + y);
		       		direction = 1;
		       		break;
		        case (KeyEvent.VK_UP):
		        	x -= 1;
		        	System.out.println(x + " up " + y);
		        	direction = 0;
		        	break;
		        case (KeyEvent.VK_DOWN):
		        	x += 1;
		        	System.out.println(x + " down " + y);
		        	direction = 2;
		        	break;
		        }
		        int[] b = {x, y};
		        if(map1[x][y] == 3 || map1[x][y] == 4 || map1[x][y] == 5){
		        	b[0] = newX;
		        	b[1] = newY;
		        }
		        else if(map1[x][y] == 19){
	        		a.getGold(1);
	        		map1[x][y] = 1;
	        	}
	        	else if(map1[x][y] == 20){
	        		a.getGold(5);
	        		map1[x][y] = 2;
	        	}
	        	else if(map1[x][y] == 18){
	        		if(a.hasKey()){
	        			
	        		}
	        		else{
	        			b[0] = newX;
	        			b[1] = newY;
	        		}
	        	}
		        System.out.println("we did it " + b[0] + " hahah " + b[1] + " These are our new coords");
		        a.setNewLocation(b);
		        System.out.println("this is x coord in player " + a.getLocation()[0] + " this is y coord " + a.getLocation()[1]);
		        placeCharacter(direction);
			}
			public void keyReleased(KeyEvent arg0) {
			}
			public void keyTyped(KeyEvent arg0) {
			}
		});
	}
	/**
	 * tries to determine which JPanel the player is currently within and then set that panel as the focus of the window JFrame.
	 * currently not used
	 */
	public void setPanel(){
		int n = a.getLocation()[0] % frameWidth;
		int c = a.getLocation()[1] % frameHeight;
		int panelNumWide = ((a.getLocation()[0] - n) / 10) + 1; //if map is less that 100
		int panelNumHigh = ((a.getLocation()[1] - c) / 10) + 1;
		System.out.println(panelNumWide + " that was wide for panel num  and now " + panelNumHigh);
		System.out.println(panelNumWide);
		frame.setContentPane(panes[panelNumWide][panelNumHigh]);
	}
	/**
	 * creates a matrix of JPanels which each contain matrices of JLabels. Each label is then populated with a imageicon which is determined by the map data
	 * @param width the total number of tiles wide
	 * @param height the total number of tiles high
	 * @return the populated matrix of JPanels
	 */
	public JPanel[][] createContentPanes(int width, int height){
		int numOfPanesWide = width/frameWidth;
		int numOfPanesHigh = height/frameHeight;
		System.out.println(width + " um nope create content panes " + height);
		System.out.println(numOfPanesWide + " " + numOfPanesHigh);
		JPanel[][] panes1 = new JPanel[numOfPanesWide][numOfPanesHigh];
		for(int i = 0; i < numOfPanesWide; i++){
			for(int t = 0; t < numOfPanesHigh; t++){
				panes1[i][t] = new JPanel();
				panes1[i][t].setLayout(new GridLayout(10, 10));
			}
		}
		for(JPanel[] pane : panes1){
			for(JPanel panel : pane){
				for(int i = 0; i < frameWidth; i++){
					for(int c = 0; c < frameHeight; c++){
						ImageIcon icon = null;
						icon = createImageIcon(pix.pic(map1[i][c]), "got it");
						JLabel a = new JLabel(icon);
						a.setSize(32, 32);
						a.setIcon(icon);
						label[i][c] = a;
						System.out.println(i + " " + c + " " + map1[i][c] + " this is stuff");
						
						a.setVisible(true);
					}
				}
			}
		}
		for(JPanel[] pane : panes1){
			for(JPanel panel : pane){
				for(JLabel[] labe : label){
					for(JLabel lab : labe){
						panel.add(lab, BorderLayout.CENTER);
						System.out.println(panel.countComponents());
					}
				}
			}
		}
//		for(int i = 0; i < numOfPanesWide; i++){
//			for(int z = 0; z < numOfPanesHigh; z++){
//				for(int r = 0; r < frameWidth; r++){
//					for(int c = 0; c < frameHeight; c++){
//						if(i == 1 && z == 1){
//							panes1[i][z].add(label[r][c], BorderLayout.CENTER);
//							System.out.println(panes1[i][z].countComponents());
//						}
//						else{
//							int hello = (frameWidth*i)+r;
//							int hello1 = (frameHeight*z)+c;
//							panes1[i][z].add(label[hello][hello1], BorderLayout.CENTER);
//							System.out.println(panes1[i][z].countComponents());
//						}
//					}
//				}
//			}
//		}
		return panes1;
	}
	/**
	 * places the character at the coordinates according to the location held by the player class
	 */
	public void setCharacter(){
		int x = a.getLocation()[0];
		int y = a.getLocation()[1];
		JLabel label = getLabel(x, y);
		label.setIcon(createImageIcon(pix.pic(15), "printed player"));
	}
	/**
	 * gets the JLabel according to coordinates
	 * @param x x coordinate 
	 * @param y y coordinate
	 * @return JLabel
	 */
	public JLabel getLabel(int x, int y){
		JLabel select = label[x][y];
		return select;
	}
	/**
	 * uses the direction of the player to determine the direction the player is moving and placing the appropriate sprite, also calls replaceOldTiles in order to cover its tracks
	 * @param dir the direction of the player represented by an integer // 0 = up, 1 = right, 2 = down, 3 = left
	 */
	public void placeCharacter(int dir){
		int loc[] = a.getLocation();
		int x = loc[0];
		int y = loc[1];
		int oldX;
		int oldY;
		int newX = x % frameWidth;
		int newY = y % frameHeight;
		System.out.println(x + " This is new x before place. Y follows " + y + " " +  newX + " " + newY);
		JLabel label = getLabel(newX, newY);
		if(dir == 1){
			label.setIcon(createImageIcon(pix.pic(14), "got it"));
			if((newX == 0 || newY == 0) || (loc[0] != 0 && loc[1] != 0)){
				setPanel();
				oldX = newX;
				oldY = newY - 1;
				resetOldTile(oldX, oldY);
				System.out.println(oldX + " these are the 'old' varaibles " + oldY);
			}
		}
		else if(dir == 2){
			label.setIcon(createImageIcon(pix.pic(6), "got it"));
			if((newX == 0 || newY == 0) || (loc[0] != 0 && loc[1] != 0)){
				setPanel();
				oldX = newX - 1;
				oldY = newY;
				resetOldTile(oldX, oldY);
				System.out.println(oldX + " these are the 'old' varaibles " + oldY);
			}
		}
		else if(dir == 3){
			label.setIcon(createImageIcon(pix.pic(12), "got it"));
			if((newX == 0 || newY == 0) || (loc[0] != 0 && loc[1] != 0)){
				setPanel();
				oldX = newX;
				oldY = newY + 1;
				resetOldTile(oldX, oldY);
				System.out.println(oldX + " these are the 'old' varaibles " + oldY);
			}
		}
		else{
			label.setIcon(createImageIcon(pix.pic(9), "got it"));
			if((newX == 0 || newY == 0) || (loc[0] != 0 && loc[1] != 0)){
				setPanel();
				oldX = newX + 1;
				oldY = newY;
				resetOldTile(oldX, oldY);
				System.out.println(oldX + " these are the 'old' varaibles " + oldY);
			}
		}
	}
	/**
	 * finds the tile the player left and replaces it with a new imageicon of the tile according to the map
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public void resetOldTile(int x, int y){
		JLabel label = getLabel(x, y);
		label.setIcon(createImageIcon(pix.pic(map1[x][y]), "resetting old tile!"));
		System.out.println("This x of reset tile " + x + " this is y of reset tile " + y);
		System.out.println(a.getLocation()[0] + " These are loc after reset " + a.getLocation()[1]);
	}
}
