package net.angusbeefgaming.mineplex.Util;

public class Maths {
	/*
	 * Maths Class for all my complicated math stuff
	 * 
	 * Created by Atticus Zambrana
	 */
	
	public static double squareNum(int x) {
		return (x * x);
	}
	
	public static String genErrorId() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			str.append(Math.round((Math.random() * 9) + 1));
		}
		return str.toString();
	}
}
