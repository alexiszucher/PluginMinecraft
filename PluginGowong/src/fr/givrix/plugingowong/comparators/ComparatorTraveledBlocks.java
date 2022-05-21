package fr.givrix.plugingowong.comparators;

import java.util.Comparator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;

public class ComparatorTraveledBlocks implements Comparator<UUID> {

	@Override
	public int compare(UUID player1, UUID player2) {
		int statPlayer1 = Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.WALK_ONE_CM);
		statPlayer1 += Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.CROUCH_ONE_CM);
		statPlayer1 += Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.SPRINT_ONE_CM);
		int statPlayer2 = Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.WALK_ONE_CM);
		statPlayer2 += Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.CROUCH_ONE_CM);
		statPlayer2 += Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.SPRINT_ONE_CM);
		return statPlayer2 - statPlayer1;
	}

}
