package org.millardps.MapMaker;

public class PixelArt {
	//int count;
	public PixelArt(){
//			count = 0;
	}
	
	public String pic(int n){
		String pic="";
		switch(n){
			case 1: pic = "images/01-BackGround.png";
			break;
			
			case 2: pic = "images/02-grass Full frame.png";
			break;
			
			case 3: pic = "images/03-Pine Tree.png";
			break;
			
			case 4: pic = "images/04-Flower Blue.png";
			break;
			
			case 5: pic = "images/05-Flower Red.png";
			break;
			
			case 6: pic = "images/06-R-Wiz f S.png";
			break;
			
			case 7: pic = "images/07-R-Wiz fL.png";
			break;
			
			case 8: pic = "images/08-R-Wiz fR.png";
			break;
			
			case 9: pic = "images/09-R-Wiz b S.png";
			break;
			
			case 10: pic = "images/10-R-Wiz bL.png";
			break;
			
			case 11: pic = "images/11-R-Wiz bR.png";
			break;
			
			case 12: pic = "images/12-R-Wiz sL S.png";
			break;
			
			case 13: pic = "images/13-R-Wiz sL W.png";
			break;
			
			case 14: pic = "images/14-R-Wiz sR S.png";
			break;
			
			case 15: pic = "images/15-R-Wiz sR W.png";
			break;
			
			case 16: pic = "images/16-Npc.png";
			break;
			
			case 17: pic = "images/17-Key.png";
			break;
			
			case 18: pic = "images/18-Chest Grass Frame.png";
			break;
			
			case 19: pic = "images/19-1coin.png";
			break;
			
			case 20: pic = "images/20-5coin.png";
			break;
			
			default: pic = null;
			break;
		}
		return pic;
	}
}