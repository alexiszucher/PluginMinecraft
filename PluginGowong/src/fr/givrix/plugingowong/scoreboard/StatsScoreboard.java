package fr.givrix.plugingowong.scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;
import fr.givrix.plugingowong.PluginGowong;
import fr.givrix.plugingowong.comparators.ComparatorAnimalsBreeded;
import fr.givrix.plugingowong.comparators.ComparatorDeaths;
import fr.givrix.plugingowong.comparators.ComparatorJumps;
import fr.givrix.plugingowong.comparators.ComparatorKilledMobs;
import fr.givrix.plugingowong.comparators.ComparatorMinedDiamonds;
import fr.givrix.plugingowong.comparators.ComparatorPlayerKills;
import fr.givrix.plugingowong.comparators.ComparatorRaidWon;
import fr.givrix.plugingowong.comparators.ComparatorTimePassedOnServer;
import fr.givrix.plugingowong.comparators.ComparatorTraveledBlocks;
import fr.givrix.plugingowong.comparators.ComparatorTraveledBoat;

public class StatsScoreboard {
	
	public void displayTopRaidWon() {
		updateScoreboard("topRaidWon", "Raid gagnés", new ComparatorRaidWon(), Statistic.RAID_WIN);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopAnimalsBreeded(), 5*20);
	}
	
	public void displayTopJumps() {
		updateScoreboard("topJumps", "Sauts effectués", new ComparatorJumps(), Statistic.JUMP);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopTraveledBoat(), 5*20);
	}
	
	public void displayTopDeaths() {
		updateScoreboard("topDeaths", "Morts", new ComparatorDeaths(), Statistic.DEATHS);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopJumps(), 5*20);
	}
	
	public void displayTopPlayerKills() {
		updateScoreboard("topPlayerKills", "Joueurs tués", new ComparatorPlayerKills(), Statistic.PLAYER_KILLS);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopDeaths(), 5*20);
	}
	
	public void displayTopAnimalsBreeded() {
		updateScoreboard("topAnimalsBreeded", "Animaux reproduits", new ComparatorAnimalsBreeded(), Statistic.ANIMALS_BRED);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopTimePassedOnServer(), 5*20);
	}
	
	public void displayTopTraveledBoat() {
		
		Scoreboard mainScoreboard = PluginAmeliorationMinecraft.getPlugin().getServer().getScoreboardManager().getMainScoreboard();
		
		Objective objective;
		if (mainScoreboard.getObjective("topTraveledBoat") != null) {
			objective = mainScoreboard.getObjective("topTraveledBoat");
			objective.unregister();
		}
		
		objective = mainScoreboard.registerNewObjective("topTraveledBoat", "dummy", ChatColor.DARK_GREEN + "Kilomètres navigués", RenderType.INTEGER);
		mainScoreboard.getObjective("topTraveledBoat").setDisplaySlot(DisplaySlot.SIDEBAR);
		
		List<UUID> topPlayers = getTopPlayersByStat(new ComparatorTraveledBoat());
		
		Score player1 = objective.getScore(ChatColor.DARK_RED + Bukkit.getOfflinePlayer(topPlayers.get(0)).getName());
		int statPlayer1 = Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.BOAT_ONE_CM);
		player1.setScore(statPlayer1/100000);
		
		Score player2 = objective.getScore(ChatColor.AQUA + Bukkit.getOfflinePlayer(topPlayers.get(1)).getName());
		int statPlayer2 = Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.BOAT_ONE_CM);
		player2.setScore(statPlayer2/100000);
		
		Score player3 = objective.getScore(ChatColor.LIGHT_PURPLE + Bukkit.getOfflinePlayer(topPlayers.get(2)).getName());
		int statPlayer3 = Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.BOAT_ONE_CM);
		player3.setScore(statPlayer3/100000);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopRaidWon(), 5*20);
	}
	
	public void displayTopMinedDiamonds() {
		
		Scoreboard mainScoreboard = PluginAmeliorationMinecraft.getPlugin().getServer().getScoreboardManager().getMainScoreboard();
		
		Objective objective;
		if (mainScoreboard.getObjective("topMinedDiamonds") != null) {
			objective = mainScoreboard.getObjective("topMinedDiamonds");
			objective.unregister();
		}
		
		objective = mainScoreboard.registerNewObjective("topMinedDiamonds", "dummy", ChatColor.DARK_GREEN + "Diamants minés", RenderType.INTEGER);
		mainScoreboard.getObjective("topMinedDiamonds").setDisplaySlot(DisplaySlot.SIDEBAR);
		
		List<UUID> topPlayers = getTopPlayersByStat(new ComparatorMinedDiamonds());
		
		Score player1 = objective.getScore(ChatColor.DARK_RED + Bukkit.getOfflinePlayer(topPlayers.get(0)).getName());
		int statPlayer1 = Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
		statPlayer1 += Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);
		player1.setScore(statPlayer1);
		
		Score player2 = objective.getScore(ChatColor.AQUA + Bukkit.getOfflinePlayer(topPlayers.get(1)).getName());
		int statPlayer2 = Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
		statPlayer2 += Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);
		player2.setScore(statPlayer2);
		
		Score player3 = objective.getScore(ChatColor.LIGHT_PURPLE + Bukkit.getOfflinePlayer(topPlayers.get(2)).getName());
		int statPlayer3 = Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
		statPlayer3 += Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);
		player3.setScore(statPlayer3);
		
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
				() -> displayTopPlayerKills(), 5*20);
	}
	
	public void displayTopKilledMobs() {
		updateScoreboard("topKilledMobs", "Monstres tués", new ComparatorKilledMobs(), Statistic.MOB_KILLS);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopMinedDiamonds(), 5*20);
	}
	
	public void displayTopTraveledBlocks() {
		
		Scoreboard mainScoreboard = PluginAmeliorationMinecraft.getPlugin().getServer().getScoreboardManager().getMainScoreboard();
		
		Objective objective;
		if (mainScoreboard.getObjective("topTraveledBlocks") != null) {
			objective = mainScoreboard.getObjective("topTraveledBlocks");
			objective.unregister();
		}
		
		objective = mainScoreboard.registerNewObjective("topTraveledBlocks", "dummy", ChatColor.DARK_GREEN + "Kilomètres marchés", RenderType.INTEGER);
		mainScoreboard.getObjective("topTraveledBlocks").setDisplaySlot(DisplaySlot.SIDEBAR);
		
		List<UUID> topPlayers = getTopPlayersByStat(new ComparatorTraveledBlocks());
		
		Score player1 = objective.getScore(ChatColor.DARK_RED + Bukkit.getOfflinePlayer(topPlayers.get(0)).getName());
		int statPlayer1 = Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.WALK_ONE_CM);
		statPlayer1 += Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.CROUCH_ONE_CM);
		statPlayer1 += Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.SPRINT_ONE_CM);
		player1.setScore(statPlayer1/100000);
		
		Score player2 = objective.getScore(ChatColor.AQUA + Bukkit.getOfflinePlayer(topPlayers.get(1)).getName());
		int statPlayer2 = Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.WALK_ONE_CM);
		statPlayer2 += Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.CROUCH_ONE_CM);
		statPlayer2 += Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.SPRINT_ONE_CM);
		player2.setScore(statPlayer2/100000);
		
		Score player3 = objective.getScore(ChatColor.LIGHT_PURPLE + Bukkit.getOfflinePlayer(topPlayers.get(2)).getName());
		int statPlayer3 = Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.WALK_ONE_CM);
		statPlayer3 += Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.CROUCH_ONE_CM);
		statPlayer3 += Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.SPRINT_ONE_CM);
		player3.setScore(statPlayer3/100000);
	
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
			() -> displayTopKilledMobs(), 5*20);
	}
	
	public void displayTopTimePassedOnServer() {
		
		Scoreboard mainScoreboard = PluginAmeliorationMinecraft.getPlugin().getServer().getScoreboardManager().getMainScoreboard();
		
		Objective objective;
		if (mainScoreboard.getObjective("topTimePassedOnServer") != null) {
			objective = mainScoreboard.getObjective("topTimePassedOnServer");
			objective.unregister();
		}
		
		objective = mainScoreboard.registerNewObjective("topTimePassedOnServer", "dummy", ChatColor.DARK_GREEN + "Heures jouées", RenderType.INTEGER);
		mainScoreboard.getObjective("topTimePassedOnServer").setDisplaySlot(DisplaySlot.SIDEBAR);
		
		List<UUID> topPlayers = getTopPlayersByStat(new ComparatorTimePassedOnServer());
		
		Score player1 = objective.getScore(ChatColor.DARK_RED + Bukkit.getOfflinePlayer(topPlayers.get(0)).getName());
		player1.setScore((Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(Statistic.PLAY_ONE_MINUTE)/20)/3600);
		
		Score player2 = objective.getScore(ChatColor.AQUA + Bukkit.getOfflinePlayer(topPlayers.get(1)).getName());
		player2.setScore((Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(Statistic.PLAY_ONE_MINUTE)/20)/3600);
		
		Score player3 = objective.getScore(ChatColor.LIGHT_PURPLE + Bukkit.getOfflinePlayer(topPlayers.get(2)).getName());
		player3.setScore((Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(Statistic.PLAY_ONE_MINUTE)/20)/3600);
		
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
				() -> displayTopTraveledBlocks(), 5*20);
	}
	
	public void updateScoreboard(String nameOfObjective, String displayNameOfObjective, Comparator<UUID> comparator, Statistic statistic) {
		
		Scoreboard mainScoreboard = PluginAmeliorationMinecraft.getPlugin().getServer().getScoreboardManager().getMainScoreboard();
		
		Objective objective;
		if (mainScoreboard.getObjective(nameOfObjective) != null) {
			objective = mainScoreboard.getObjective(nameOfObjective);
			objective.unregister();
		}
		
		objective = mainScoreboard.registerNewObjective(nameOfObjective, "dummy", ChatColor.DARK_GREEN + displayNameOfObjective, RenderType.INTEGER);
		mainScoreboard.getObjective(nameOfObjective).setDisplaySlot(DisplaySlot.SIDEBAR);
		
		List<UUID> topPlayers = getTopPlayersByStat(comparator);
		
		Score player1 = objective.getScore(ChatColor.DARK_RED + Bukkit.getOfflinePlayer(topPlayers.get(0)).getName());
		player1.setScore(Bukkit.getOfflinePlayer(topPlayers.get(0)).getStatistic(statistic));
		
		Score player2 = objective.getScore(ChatColor.AQUA + Bukkit.getOfflinePlayer(topPlayers.get(1)).getName());
		player2.setScore(Bukkit.getOfflinePlayer(topPlayers.get(1)).getStatistic(statistic));
		
		Score player3 = objective.getScore(ChatColor.LIGHT_PURPLE + Bukkit.getOfflinePlayer(topPlayers.get(2)).getName());
		player3.setScore(Bukkit.getOfflinePlayer(topPlayers.get(2)).getStatistic(statistic));
		
	}
	
	public List<UUID> getTopPlayersByStat(Comparator<UUID> comparator) {
		
		List<UUID> topPlayers = new ArrayList<>();
		
		List<UUID> allPlayers = getAllPlayers();
		Collections.sort(allPlayers, comparator);
		
		for (int i = 0; i < 3; i++) {
			topPlayers.add(allPlayers.get(i));
		}
		
		return topPlayers;
	}
	
	public List<UUID> getAllPlayers() {
		
		List<UUID> allPlayers = new ArrayList<>();

		for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
			allPlayers.add(offlinePlayer.getUniqueId());
		}
		
        Set<UUID> set = new HashSet<>();
        set.addAll(allPlayers);
        allPlayers = new ArrayList<>(set) ;
		
		return allPlayers;
	}

}
