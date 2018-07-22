package net.angusbeefgaming.mineplex.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import net.angusbeefgaming.mineplex.MineplexCore;


public class ScoreboardManager implements Listener {
    static Scroller scr;
	
	public static void keepUpdates() {

        new BukkitRunnable() {

            @Override
            public void run() {

                for(Player player : Bukkit.getOnlinePlayers()) {
                    updateScoreboard(player);
                }

            }

        }.runTaskTimer(MineplexCore.getInstance(), 20L, 20L);
	}
	
    private void createScoreboard(Player player) {
        ScoreHelper board = ScoreHelper.createScore(player);
        
        scr = new Scroller("&f&lWelcome " + player.getDisplayName() + " to the Fakeplex Network!", 10, 8, '&');
        
        board.setTitle(scr.next());
        board.setSlot(0, "Test");
    }
    
    private static void updateScoreboard(Player player) {
        if(ScoreHelper.hasScore(player)) {
            ScoreHelper board = ScoreHelper.getByPlayer(player);
            board.setTitle(scr.next());
            board.setSlot(0, "Test");
        	return;
        }
    }
    

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        createScoreboard(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(ScoreHelper.hasScore(player)) {
            ScoreHelper.removeScore(player);
        }
    }
}

