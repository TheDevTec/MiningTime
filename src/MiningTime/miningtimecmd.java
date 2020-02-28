package MiningTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import Utils.PlayerUtil;
import Utils.tournamentutils;
import Utils.utils;
import me.Straiker123.TheAPI;



public class miningtimecmd implements CommandExecutor, TabCompleter {

	main m = main.instance;
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (args.length == 0) { 
			if(main.hasPerm(s, "MiningTime.Admin")) {

				utils.buildHelpMsg(s, "/mt Tournament start <type> <time>", "Help.TournamentStart");
				utils.buildHelpMsg(s,  "/mt Tournament stop", "Help.TournamentStop");
				utils.buildHelpMsg(s, "/mt ResetStats <player>", "Help.AdminStats");
				utils.buildHelpMsg(s, "/mt Stats <player>", "Help.Stats");
				utils.buildHelpMsg(s, "/mt Info", "Help.Info");
			return true;
			}
			if(main.hasPerm(s, "MiningTime.Player")) {
				utils.buildHelpMsg(s, "/mt Stats <player>", "Stats");
				utils.buildHelpMsg(s, "/mt Info <player>", "Info");
				
				return true;
			}
		}
		if(args.length >= 1) {
			/*
			 * 				INFO
			 */
			if(args[0].equalsIgnoreCase("Info")) {
				utils.msg("&6--------< &2Mining&aTime &6>--------", s);
				utils.msg(" ", s);
				utils.msg("&aThis plugin is adding new event to game! You can start some type of mine tournament and winer will get some prize!", s);
				utils.msg("&aMain command: &2/miningtime &aor you can just use &2/mt", s);
				utils.msg(" ", s);
				utils.msg("&aPlugin created by &3&lDev&b&lTec&a", s);
				utils.msg("&aWant more? Look to our DevTec group on spigot: &2 https://www.spigotmc.org/resources/authors/thedevtec.853819/", s);
				utils.msg("&aOn our discord we will help you with problems and bugs! Please reort all errors on our discord: &2https://discord.gg/6ehQr6U", s);
				utils.msg(" ", s);
				utils.msg("&6------------------------------------", s);
				return true;
			}
			/*
			 * 				STATS
			 */
			if(args[0].equalsIgnoreCase("Stats")) {
				if(main.hasPerm(s, "MiningTime.Stats")) {
					if(args.length==1) {
						if(s instanceof Player == true) {
							Player p =(Player)s;
							 if(m.getConfig().getString("Players."+p.getName()) != null) {
								 utils.msg("&e------------- &bMiningTime&e -------------",s);
								 utils.msg(" ", s);
								 List<String> stats = m.getConfig().getStringList("Stats");
								 for(String st: stats) {
									 utils.msg(st
											 .replace("%playername%", p.getDisplayName())
											 .replace("%player%", p.getName())
											 .replace("%oremined%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".OreMined")))
											 .replace("%playedtournaments%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".PlayerTournaments")))
											 .replace("%top1%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".Top1")))
											 .replace("%top2%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".Top2")))
											 .replace("%top3%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".Top3")))
											 .replace("%diamondsmined%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".DiamondsMined")))
											 .replace("%emeraldsmined%", String.valueOf(m.getConfig().getInt("Players."+p.getName()+".EmeraldsMined"))), s);
								 }return true;}else {
									 utils.msg(utils.s("Help.PlayerNotExist").replace("%player%", p.getName()), s);
									 return true;
								 }}
						if(s instanceof Player == false) {
							utils.buildHelpMsg(s, "/mt Stats <player>", "Help.StatsByConsole");
						}}
					if(args.length==2) {
							Player t = Bukkit.getPlayer(args[1]);
							if(t!=null) {
								if(m.getConfig().getString("Players."+args[1]) != null) {
								utils.msg("&e------------- &bMiningTime&e -------------",s);
								 utils.msg(" ", s);
								 List<String> stats = m.getConfig().getStringList("Stats");
								 for(String st: stats) {
									 utils.msg(st
											 .replace("%playername%", t.getDisplayName())
											 .replace("%player%", t.getName())
											 .replace("%oremined%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".OreMined")))
											 .replace("%playedtournaments%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".PlayerTournaments")))
											 .replace("%top1%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".Top1")))
											 .replace("%top2%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".Top2")))
											 .replace("%top3%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".Top3")))
											 .replace("%diamondsmined%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".DiamondsMined")))
											 .replace("%emeraldsmined%", String.valueOf(m.getConfig().getInt("Players."+t.getName()+".EmeraldsMined"))), s);
								 }return true;}else {
							 utils.msg(utils.s("Help.PlayerNotExist").replace("%player%", t.getName()), s);
							 return true;}
							}
							 if(m.getConfig().getString("Players."+args[1]) != null) {
								 utils.msg("&e------------- &bMiningTime&e -------------",s);
								 utils.msg(" ", s);
								 List<String> stats = m.getConfig().getStringList("Stats");
								 for(String st: stats) {
									 utils.msg(st
											 .replace("%playername%", args[1])
											 .replace("%player%", args[1])
											 .replace("%oremined%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".OreMined")))
											 .replace("%playedtournaments%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".PlayerTournaments")))
											 .replace("%top1%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".Top1")))
											 .replace("%top2%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".Top2")))
											 .replace("%top3%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".Top3")))
											 .replace("%diamondsmined%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".DiamondsMined")))
											 .replace("%emeraldsmined%", String.valueOf(m.getConfig().getInt("Players."+args[1]+".EmeraldsMined"))), s);
								 }return true;}else {
							 utils.msg(utils.s("Help.PlayerNotExist").replace("%player%", args[1]), s);
							 return true;}}
				}
			}
			/*
			 * 				RESETSTATS
			 */
			if(args[0].equalsIgnoreCase("ResetStats")) {
				Player t = Bukkit.getPlayer(args[1]);
				if(t!=null) {
					if(m.getConfig().getString("Players."+t.getName()) != null) {
						PlayerUtil.ResetData(t);
						utils.msg(main.s("Messages.MainMessages.StatsResetet")
								.replace("%prefix%", main.s("Prefix"))
								.replace("%target%", t.getName()), s);
						return true;
					}
					 utils.msg(utils.s("Help.PlayerNotExist").replace("%player%", args[1]), s);
					 return true;
				}
				 if(m.getConfig().getString("Players."+args[1]) != null) {
					 PlayerUtil.ResetData(t);
						utils.msg(main.s("Messages.MainMessages.StatsResetet")
								.replace("%prefix%", main.s("Prefix"))
								.replace("%target%", args[0]), s);
						return true;
				 }
				 utils.msg(utils.s("Help.PlayerNotExist").replace("%player%", args[1]), s);
				 return true;
			}
			/*
			 * 				TOURNAMENT
			 */
			if(args[0].equalsIgnoreCase("Tournament")) {
				if(main.hasPerm(s, "MiningTime.TournamentAdmin")) {
					if(args[1].equalsIgnoreCase("Start")&&args.length==4) {
						int sec = TheAPI.getNumbersAPI(args[3]).getInt();
						tournamentutils.startType(tournamentutils.Type.valueOf(args[2]), sec);
						return true;
					}
					if(args[1].equalsIgnoreCase("Stop")) {
						tournamentutils.Stop();
						return true;
					}
					if(args[1].equalsIgnoreCase("info")) {
						tournamentutils.Info(s);
						return true;
					}
					utils.buildHelpMsg(s, "/mt Tournament start <type> <time>", "Help.TournamentStart");
					utils.buildHelpMsg(s,  "/mt Tournament stop", "Help.TournamentStop");
					utils.buildHelpMsg(s,  "/mt Tournament info", "Help.TournamentStop");
					return true;
				}
			}
		
			return true;
		}
		return true;
	}
	   @Override
	    public List<String> onTabComplete(CommandSender s, Command arg1, String arg2, String[] args) {
	        List<String> c = new ArrayList<>();
	        if(utils.hasPerm(s, "MiningTime.Player")) {
	            if(args.length==1) {
		if(utils.hasPerm(s, "MiningTime.Admin"))
	                c.addAll(StringUtil.copyPartialMatches(args[0], Arrays.asList("Tournament", "ResetStats"), new ArrayList<>()));
	                c.addAll(StringUtil.copyPartialMatches(args[0], Arrays.asList("Stats", "Info"), new ArrayList<>()));
	            }
	if(args.length==2){
		if(utils.hasPerm(s, "MiningTime.Admin")){
	            if(args[0].equalsIgnoreCase("Tournament")) {
	                c.addAll(StringUtil.copyPartialMatches(args[1], Arrays.asList("Start", "Stop", "Info"), new ArrayList<>()));
	            }
	            if(args[0].equalsIgnoreCase("ResetStats")) {
	                return null;
	            }
	}
	            if(args[0].equalsIgnoreCase("Stats")) {
	                return null;
	            }
	}
	if(utils.hasPerm(s, "MiningTime.Admin"))
	            if(args[0].equalsIgnoreCase("Tournament")&&args[1].equalsIgnoreCase("Start")&&args.length==3) {
	                c.addAll(StringUtil.copyPartialMatches(args[2], Arrays.asList("DiamondHunt","EmeraldHunt","MostMinedOres",
	                        //"JustMineEverything",
	                		"Random"), new ArrayList<>()));
	            }
	        }
	        return c;
	        
	    }
	}
