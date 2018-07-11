package net.angusbeefgaming.mineplex.tags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

import net.minecraft.server.v1_12_R1.Scoreboard;

public class NametagChanger {
	 
    private static Team team;
    private static Scoreboard scoreboard;
 
    public static void changePlayerName(Player player, String prefix, String suffix, TeamAction action) {
        if (player.getScoreboard() == null || prefix == null || suffix == null || action == null) {
            return;
        }
 
        scoreboard = (Scoreboard) player.getScoreboard();
 
        if (scoreboard.getTeam(player.getName()) == null) {
            ((org.bukkit.scoreboard.Scoreboard) scoreboard).registerNewTeam(player.getName());
        }
 
        team = (Team) scoreboard.getTeam(player.getName());
        team.setPrefix(Color(prefix));
        team.setSuffix(Color(suffix));
        team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.ALWAYS);
        // Potential Bug fix for Player Collision
        team.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
 
        switch (action) {
            case CREATE:
                team.addPlayer(player);
                break;
            case UPDATE:
                team.unregister();
                ((org.bukkit.scoreboard.Scoreboard) scoreboard).registerNewTeam(player.getName());
                team = (Team) scoreboard.getTeam(player.getName());
                team.setPrefix(Color(prefix));
                team.setSuffix(Color(suffix));
                team.setNameTagVisibility(NameTagVisibility.ALWAYS);
                team.addPlayer(player);
                break;
            case DESTROY:
                team.unregister();
                break;
        }
    }
 
    private static String Color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
