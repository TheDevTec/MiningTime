package Utils;

import org.bukkit.entity.Player;

import MiningTime.main;


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
		int dia = main.instance.getConfig().getInt("Players."+p.getName()+".DiamondsMined");
		int eme = main.instance.getConfig().getInt("Players."+p.getName()+".EmeraldsMined");
		int all = main.instance.getConfig().getInt("Players."+p.getName()+".OreMined");
		int ptours = main.instance.getConfig().getInt("Players."+p.getName()+".PlayedTournaments");
		int top1 = main.instance.getConfig().getInt("Players."+p.getName()+".Top1");
		int top2 = main.instance.getConfig().getInt("Players."+p.getName()+".Top2");
		int top3 = main.instance.getConfig().getInt("Players."+p.getName()+".Top3");
		if(object.equalsIgnoreCase("PTOURS")) {
			main.instance.getConfig().set("Players."+p.getName()+".PlayedTournaments", ptours+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("TOP1")) {
			main.instance.getConfig().set("Players."+p.getName()+".Top1", top1+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("TOP2")) {
			main.instance.getConfig().set("Players."+p.getName()+".Top2", top2+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("TOP3")) {
			main.instance.getConfig().set("Players."+p.getName()+".Top3", top3+1);
			main.instance.saveConfig();
		}
		if(object.equalsIgnoreCase("DIAMOND_ORE")) {
			main.instance.getConfig().set("Players."+p.getName()+".DiamondsMined", dia+1);
			main.instance.getConfig().set("Players."+p.getName()+".OreMined", all+1);
			main.instance.saveConfig();
		}
		if(object == "EMERALD_ORE") {
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
	
}
