package fr.givrix.plugingowong.comparators;

import java.util.Comparator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;

public class ComparatorAnimalsBreeded implements Comparator<UUID> {

	@Override
	public int compare(UUID player1, UUID player2) {
		return Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.ANIMALS_BRED) - Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.ANIMALS_BRED);
	}

}
