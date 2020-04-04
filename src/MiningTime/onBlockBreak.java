package MiningTime;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import Utils.PlayerUtil;
import Utils.tournamentutils;

public class onBlockBreak implements Listener {

	@EventHandler
	public void BlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode().equals(GameMode.SURVIVAL)) {
			if(tournamentutils.isRunning()==true &&tournamentutils.isStarted()==true) {
				Material m = e.getBlock().getType();
				if(m.equals(Material.DIAMOND_ORE)) {
					tournamentutils.addPoint(p, "DIAMOND_ORE", 1);
					PlayerUtil.addPointToConfig(p, "DIAMOND_ORE");
				}
				if(m.equals(Material.EMERALD_ORE)) {
					tournamentutils.addPoint(p, "EMERALD_ORE", 1);
					PlayerUtil.addPointToConfig(p, "EMERALD_ORE");
				}
				if(m.equals(Material.IRON_ORE)) {
					tournamentutils.addPoint(p, "IRON_ORE", 1);
					PlayerUtil.addPointToConfig(p, "IRON_ORE");
				}
				if(m.equals(Material.GOLD_ORE)) {
					tournamentutils.addPoint(p, "GOLD_ORE", 1);
					PlayerUtil.addPointToConfig(p, "GOLD_ORE");
				}
				if(m.equals(Material.LAPIS_ORE)) {
					tournamentutils.addPoint(p, "LAPIS_ORE", 1);
					PlayerUtil.addPointToConfig(p, "LAPIS_ORE");
				}
				if(m.equals(Material.REDSTONE_ORE)) {
					tournamentutils.addPoint(p, "REDSTONE_ORE", 1);
					PlayerUtil.addPointToConfig(p, "REDSTONE_ORE");
				}
			}
		
		}
	}
}