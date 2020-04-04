package Utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import MiningTime.main;
import me.Straiker123.TheAPI;
import me.Straiker123.TheAPI.SudoType;


public class PlayerUtil {
	static main m = main.instance;

	public static String DataExist(Player p) {
		return m.getConfig().getString("Players."+p.getName());
	}
	public static void CreateNewData(Player p) {
		if(p==null) return;
		m.getConfig().set("Players."+p.getName()+".OreMined", 0);
		m.getConfig().set("Players."+p.getName()+".DiamondsMined", 0);
		m.getConfig().set("Players."+p.getName()+".EmeraldsMined", 0);
		m.getConfig().set("Players."+p.getName()+".PlayedTournaments", 0);
		m.getConfig().set("Players."+p.getName()+".Top1", 0);
		m.getConfig().set("Players."+p.getName()+".Top2", 0);
		m.getConfig().set("Players."+p.getName()+".Top3", 0);
		m.saveConfig();
	}
	public static void ResetData(Player p) {
		if(p==null) return;
		m.getConfig().set("Players."+p.getName()+".OreMined", 0);
		m.getConfig().set("Players."+p.getName()+".DiamondsMined", 0);
		m.getConfig().set("Players."+p.getName()+".EmeraldsMined", 0);
		m.getConfig().set("Players."+p.getName()+".PlayedTournaments", 0);
		m.getConfig().set("Players."+p.getName()+".Top1", 0);
		m.getConfig().set("Players."+p.getName()+".Top2", 0);
		m.getConfig().set("Players."+p.getName()+".Top3", 0);
		m.saveConfig();
	}
	public static void addPointToConfig(Player p, String object) {
		int all = main.instance.getConfig().getInt("Players."+p.getName()+".OreMined");
		if(object.equalsIgnoreCase("PTOURS")) {
			int ptours = main.instance.getConfig().getInt("Players."+p.getName()+".PlayedTournaments");
			main.instance.getConfig().set("Players."+p.getName()+".PlayedTournaments", ptours+1);
			main.instance.saveConfig();
		}
		if(object.startsWith("Top")) {
			int top = main.instance.getConfig().getInt("Players."+p+"."+object);
			main.instance.getConfig().set("Players."+p.getName()+"."+object, top+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("DIAMOND_ORE")) {
			int dia = main.instance.getConfig().getInt("Players."+p.getName()+".DiamondsMined");
			main.instance.getConfig().set("Players."+p.getName()+".DiamondsMined", dia+1);
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("EMERALD_ORE")) {
			int eme = main.instance.getConfig().getInt("Players."+p.getName()+".EmeraldsMined");
			main.instance.getConfig().set("Players."+p.getName()+".EmeraldsMined", eme+1);
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("IRON_ORE")) {
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("GOLD_ORE")) {
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("LAPIS_ORE")) {
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("REDSTONE_ORE")) {
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
	}
	public static void addPointToConfig(String p, String object) {
		int all = main.instance.getConfig().getInt("Players."+p+".OreMined");
		if(object.equalsIgnoreCase("PTOURS")) {
			int ptours = main.instance.getConfig().getInt("Players."+p+".PlayedTournaments");
			main.instance.getConfig().set("Players."+p+".PlayedTournaments", ptours+1);
			main.instance.saveConfig();
		}
		if(object.startsWith("Top")) {
			int top = main.instance.getConfig().getInt("Players."+p+"."+object);
			main.instance.getConfig().set("Players."+p+"."+object, top+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("DIAMOND_ORE")) {
			int dia = main.instance.getConfig().getInt("Players."+p+".DiamondsMined");
			main.instance.getConfig().set("Players."+p+".DiamondsMined", dia+1);
			main.instance.getConfig().set("Players."+p+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("EMERALD_ORE")) {
			int eme = main.instance.getConfig().getInt("Players."+p+".EmeraldsMined");
			main.instance.getConfig().set("Players."+p+".EmeraldsMined", eme+1);
			main.instance.getConfig().set("Players."+p+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("IRON_ORE")) {
			main.instance.getConfig().set("Players."+p+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("GOLD_ORE")) {
			main.instance.getConfig().set("Players."+p+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("LAPIS_ORE")) {
			main.instance.getConfig().set("Players."+p+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("REDSTONE_ORE")) {
			main.instance.getConfig().set("Players."+p+".OreMined", all+1);
			main.instance.saveConfig();
		}
	}
	public static void reward(String p,String pos) {
            String money = main.instance.getConfig().getString("Settings.Reward."+pos);
            TheAPI.sudoConsole(SudoType.COMMAND, money.replace("@p",p));
            addPointToConfig(p, pos);
            utils.msg(main.s("Messages.Tournaments.Reward")
            		.replace("%prefix%", main.s("Prefix")), Bukkit.getPlayer(p));
            Bukkit.getPlayer(p).playSound(Bukkit.getPlayer(p).getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);
    }
}
