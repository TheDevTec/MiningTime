package Utils;

import org.bukkit.entity.Player;

import MiningTime.main;
import me.Straiker123.TheAPI;


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
	public static void reward(Player p,String pos) {
        if (pos.equalsIgnoreCase("Top1")) {
            final double money = convertMoney(main.instance.getConfig().getString("Settings.Reward.Top1.Money"));
            TheAPI.getEconomyAPI().depositPlayer(p, money);
            utils.msg(main.s("Messages.Tournaments.Reward")
            		.replace("%prefix%", main.s("Prefix")).replace("%reward%", new StringBuilder().append(money).toString()), p);
            return;
        }
        if (pos.equalsIgnoreCase("Top2")) {
            final double money = convertMoney(main.instance.getConfig().getString("Settings.Reward.Top2.Money"));
            TheAPI.getEconomyAPI().depositPlayer(p, money);
            utils.msg(main.s("Messages.Tournaments.Reward")
            		.replace("%prefix%", main.s("Prefix")).replace("%reward%", new StringBuilder().append(money).toString()), p);
            return;
        }
        if (pos.equalsIgnoreCase("Top3")) {
            final double money = convertMoney(main.instance.getConfig().getString("Settings.Reward.Top3.Money"));
            TheAPI.getEconomyAPI().depositPlayer(p, money);
            utils.msg(main.s("Messages.Tournaments.Reward")
            		.replace("%prefix%", main.s("Prefix")).replace("%reward%", new StringBuilder().append(money).toString()), p);
        }
    }
	 public static double convertMoney(String s) {
	        double a = TheAPI.getNumbersAPI(s).getDouble();
	        final double mille = a * 1000.0;
	        final double million = mille * 1000.0;
	        final double billion = million * 1000.0;
	        final double trillion = billion * 1000.0;
	        final double quadrillion = trillion * 1000.0;
	        if (s.endsWith("k")) {
	            a *= 1000.0;
	        }
	        if (s.endsWith("m")) {
	            a = million;
	        }
	        if (s.endsWith("b")) {
	            a = billion;
	        }
	        if (s.endsWith("t")) {
	            a = trillion;
	        }
	        if (s.endsWith("q")) {
	            a = quadrillion;
	        }
	        return a;
	    }
}
