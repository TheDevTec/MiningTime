package MiningTime;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Utils.PlayerUtil;
import Utils.utils;

public class onJoin implements Listener {

	main m= main.instance;
	
	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(PlayerUtil.DataExist(p)==null) {
			PlayerUtil.CreateNewData(p);
			utils.warn("New Player "+p.getName()+" joined. Data succesfully created!");
		}
		
	}
	
}
