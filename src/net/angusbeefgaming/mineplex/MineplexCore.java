package net.angusbeefgaming.mineplex;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.mineplex.account.PlayerJoinLeave;
import net.angusbeefgaming.mineplex.account.RankEvent;
import net.angusbeefgaming.mineplex.account.UpdaterankCommand;
import net.angusbeefgaming.mineplex.announcement.AnnounceCommand;
import net.angusbeefgaming.mineplex.antigrief.AntiGrief;
import net.angusbeefgaming.mineplex.carl.CarlCommand;
import net.angusbeefgaming.mineplex.carl.CarlListener;
import net.angusbeefgaming.mineplex.chat.SilenceChat;
import net.angusbeefgaming.mineplex.chat.onChatEvent;
import net.angusbeefgaming.mineplex.common.GameModeCommand;
import net.angusbeefgaming.mineplex.common.NetworkKickCommand;
import net.angusbeefgaming.mineplex.common.OpenPanelCommand;
import net.angusbeefgaming.mineplex.common.SCommand;
import net.angusbeefgaming.mineplex.common.Storage;
import net.angusbeefgaming.mineplex.damage.DamageListener;
import net.angusbeefgaming.mineplex.damage.ToggleDamageCommand;
import net.angusbeefgaming.mineplex.disguise.DisguiseCommand;
import net.angusbeefgaming.mineplex.disguise.UndisguiseCommand;
import net.angusbeefgaming.mineplex.forcefield.EntityListener;
import net.angusbeefgaming.mineplex.forcefield.ForcefieldCommand;
import net.angusbeefgaming.mineplex.gems.GemCommand;
import net.angusbeefgaming.mineplex.gwen.ManualGwenAlertCommand;
import net.angusbeefgaming.mineplex.pm.MessageCommand;
import net.angusbeefgaming.mineplex.pm.SocialSpyCommand;
import net.angusbeefgaming.mineplex.reports.ReportPlayerCommand;
import net.angusbeefgaming.mineplex.server.CloseServerCommand;
import net.angusbeefgaming.mineplex.server.ServerType;
import net.angusbeefgaming.mineplex.settings.PrefrencesCommand;
import net.angusbeefgaming.mineplex.settings.PrefrencesHandler;
import net.angusbeefgaming.mineplex.signs.GemLookupSign;
import net.angusbeefgaming.mineplex.vanish.VanishCommand;
import net.md_5.bungee.api.ChatColor;


public class MineplexCore extends JavaPlugin implements PluginMessageListener {
	
	private static MineplexCore instance;
	public static Map<String, String> rankStore = new HashMap<String, String>();
	
	public static ServerType myServerType;
	
	@Override
	public void onEnable() {
		instance = this;
		
		myServerType = ServerType.LOBBY;
		
		// Register Commands
		getCommand("updaterank").setExecutor(new UpdaterankCommand());
		getCommand("carlthecreeper").setExecutor(new CarlCommand());
		getCommand("damage").setExecutor(new ToggleDamageCommand());
		getCommand("gm").setExecutor(new GameModeCommand());
		getCommand("s").setExecutor(new SCommand());
		getCommand("gwenreport").setExecutor(new ManualGwenAlertCommand());
		getCommand("prefs").setExecutor(new PrefrencesCommand());
		getCommand("panelopen").setExecutor(new OpenPanelCommand());
		getCommand("gem").setExecutor(new GemCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("networkkick").setExecutor(new NetworkKickCommand());
		getCommand("silence").setExecutor(new SilenceChat());
		getCommand("report").setExecutor(new ReportPlayerCommand());
		getCommand("msg").setExecutor(new MessageCommand());
		getCommand("socialspy").setExecutor(new SocialSpyCommand());
		getCommand("announce").setExecutor(new AnnounceCommand());
		getCommand("disguise").setExecutor(new DisguiseCommand());
		getCommand("undisguise").setExecutor(new UndisguiseCommand());
		getCommand("closeserver").setExecutor(new CloseServerCommand());
		getCommand("forcefield").setExecutor(new ForcefieldCommand());
		
		// Register Events
		getServer().getPluginManager().registerEvents(new RankEvent(), this);
		getServer().getPluginManager().registerEvents(new AntiGrief(), this);
		getServer().getPluginManager().registerEvents(new DamageListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinLeave(), this);
		getServer().getPluginManager().registerEvents(new PrefrencesHandler(), this);
		getServer().getPluginManager().registerEvents(new CarlListener(), this);
		getServer().getPluginManager().registerEvents(new onChatEvent(), this);
		
		getServer().getPluginManager().registerEvents(new GemLookupSign(), this);
		
		getServer().getPluginManager().registerEvents(new EntityListener(), this);
		
		// Dont use this code. Its from the Broken Auth System
		//getServer().getPluginManager().registerEvents(new AuthJoinListener(), this);
		//getServer().getPluginManager().registerEvents(new StopMovement(), this);
		//getServer().getPluginManager().registerEvents(new ChatListener(), this);
		
		
		// Plugin Massaging Channel Stuff
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "Return");
		Bukkit.getMessenger().registerIncomingPluginChannel(this, "Return", this);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		// Make sure we store the Staff Team Phone Numbers
		Storage.initNumbers();
		
		// Setup my Configuration File
		try {
			if(!getDataFolder().exists()) {
				getLogger().info("Core> Plugin Folder Not Found! Creating Now.");
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if(!file.exists()) {
				getLogger().info("Core> Config File Not Found! Creating Now.");
				saveDefaultConfig();
			}
			else {
				getLogger().info("Core> Config File Loaded!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendAllHub() {
		for(Player pla : Bukkit.getOnlinePlayers()) {
			pla.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + "The Server you were on has been restarted by an Admin.");
			
			  ByteArrayDataOutput out = ByteStreams.newDataOutput();
			  out.writeUTF("ConnectOther");
			  out.writeUTF(pla.getName());
			  out.writeUTF("Lobby-1");

			  // If you don't care about the player
			  // Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
			  // Else, specify them
			  Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

			  player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
		}
	}
	
	@Override
	public void onDisable() {
		instance = null;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.kickPlayer(ChatColor.BLUE + "Game> " + ChatColor.GRAY + "This Game has been shutdown by an Admin.");
		}
	}
	
	public static MineplexCore getInstance() {
		return instance;
	}
	
	   public void onPluginMessageReceived(String channel, Player p, byte[] message) {
		      DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		      if(!channel.equalsIgnoreCase("Return"))return;
		      System.out.println("Custom Plugin Message Recieved");
		      try {
		         String sub = in.readUTF();

		         if (sub.equals("staffchat")) {
		        	 System.out.println("Staff Chat Message Recieved");
		        	 if(Bukkit.getOnlinePlayers().size() < 1)return;
		            String messageSent = in.readUTF();
		            String messageSender = in.readUTF();
		            String senderServer = in.readUTF();
		            this.getServer().broadcast(ChatColor.BLUE + "Staff> " + ChatColor.AQUA + "[" + senderServer + "] " + ChatColor.GOLD + "(" + messageSender + "): " + ChatColor.AQUA + messageSent, "rank.trainee");
		         }
		         if (sub.equals("announcement")) {
		        	 System.out.println("Announcement Recieved");
		        	 if(Bukkit.getOnlinePlayers().size() < 1)return;
		            String messageSent = in.readUTF();
		            for(Player pl : Bukkit.getOnlinePlayers()) {
		            	pl.sendTitle(ChatColor.BOLD + "" + ChatColor.YELLOW + "Announcement", messageSent, 10, 70, 20);
		            	pl.sendMessage(ChatColor.BLUE + "Announcement> " + ChatColor.AQUA + messageSent);
		            }
		         }
		      } catch (Exception var8) {
		         var8.printStackTrace();
		      }

		   }
}
