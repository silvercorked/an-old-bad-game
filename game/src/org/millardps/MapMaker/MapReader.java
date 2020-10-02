package org.millardps.MapMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MapReader {
	private BufferedReader reader;
	private StringTokenizer token;
	private int[][] mapData1;
	private int mapWidth;
	private int mapHeight;
	
	public void readMap(){
		try{
			String currentLine;
			reader = new BufferedReader(new FileReader(new File("game/src/org/millardps/Mapmaker/images/Map 01.txt").getAbsolutePath()));
			currentLine = reader.readLine();
			token = new StringTokenizer(currentLine);
			mapWidth = Integer.parseInt(token.nextToken());
			mapHeight = Integer.parseInt(token.nextToken());
			mapData1 = new int[mapWidth][mapHeight];
			for(int y = 0; y < mapHeight; y++){
				currentLine = reader.readLine();
				token = new StringTokenizer(currentLine);
				while(token.hasMoreTokens()){
					for(int x = 0; x < mapWidth; x++){
						mapData1[y][x] = Integer.parseInt(token.nextToken());
					}
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public int[][] getMap(){
		return this.mapData1;
	}
	public int getMapWidth(){
		return mapWidth;
	}
	public int getMapHeight(){
		return mapHeight;
	}
}
