package org.millardps.MapMaker;

public class Runner {

	public static void main(String[] args) {
		MapReader mr = new MapReader();
		mr.readMap();
		JframeStuff jf = new JframeStuff(mr.getMap(), mr.getMapWidth(), mr.getMapHeight());
	}

}
