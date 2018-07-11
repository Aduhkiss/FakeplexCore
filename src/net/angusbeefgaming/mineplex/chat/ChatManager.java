package net.angusbeefgaming.mineplex.chat;

public class ChatManager {
	public static boolean chatEnabled = true;
	
	public static void silenceChat() {
		chatEnabled = false;
	}
	
	public static void activateChat() {
		chatEnabled = true;
	}
	
	public static void toggleChat() {
		if(chatEnabled) {
			silenceChat();
		}
		else {
			activateChat();
		}
	}
}
