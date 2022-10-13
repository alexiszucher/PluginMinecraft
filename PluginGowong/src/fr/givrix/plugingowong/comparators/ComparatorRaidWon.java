package fr.givrix.plugingowong.comparators;

import java.util.Comparator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;

public class ComparatorRaidWon implements Comparator<UUID> {

	@Override
	public int compare(UUID player1, UUID player2) {
		return Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.RAID_WIN) - Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.RAID_WIN);
	}
	
}