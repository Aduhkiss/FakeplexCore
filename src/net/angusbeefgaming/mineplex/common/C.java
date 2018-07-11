package net.angusbeefgaming.mineplex.common;

public class C {
	public static String combineArray(String[] args, int startPos) {
        StringBuilder message = new StringBuilder();

        for(int i = startPos; i < args.length; ++i) {
           message = message.append(args[i] + " ");
        }
        return message.toString();
	}
	
}
