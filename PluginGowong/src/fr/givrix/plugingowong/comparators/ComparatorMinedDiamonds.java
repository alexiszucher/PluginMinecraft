package fr.givrix.plugingowong.comparators;

import java.util.Comparator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;

public class ComparatorMinedDiamonds implements Comparator<UUID> {

	@Override
	public int compare(UUID player1, UUID player2) {
		int statPlayer1 = Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
		statPlayer1 += Bukkit.getOfflinePlayer(player1).getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);
		int statPlayer2 = Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
		statPlayer2 += Bukkit.getOfflinePlayer(player2).getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);
		return statPlayer2 - statPlayer1;
	}

}
