package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import MiningTime.main;
import me.Straiker123.RankingAPI;
import me.Straiker123.TheAPI;

public class tournamentutils {
	
	main m = main.instance;
	String fromString;
	
	static int count;
	static int save;
	static int prep;
	
	public static enum Type{
		DiamondHunt,
		EmeraldHunt,
		MostMinedOres,
		//JustMineEverything,
		Random;
	}
	
	static int run;
	
	public static void startType(Type type, int length) {
		
		if(type==Type.Random) {
			ArrayList<String> legend = new ArrayList<String>();
			legend.add("DiamondHunt");
			legend.add("EmeraldHunt");
			legend.add("MostMinedOres");
			//legend.add("JustMineEverything");
			int target = 0;
			for (int counter =1; counter<=4;counter++) {
			    Random object = new Random();
			    target = 0;
			if(legend.size() > target) {
				target = object.nextInt(legend.size());
			}
		}
			type=Type.valueOf(legend.get(target));
		}
		count = length;
		if (main.instance.getConfig().getBoolean("Settings.PrepTime.Enabled")&&
				main.instance.getConfig().getString("Settings.PrepTime.Time")!=null) {
            prep = main.instance.getConfig().getInt("Settings.PrepTime.Time");
        }
        else {
            prep = 0;
        }
		prep = 60;
		if(count == 0) {
			count = 600;
		}
		save=count;
		createNewTournament(type.toString(), length);
		List<String> TourStats = main.instance.getConfig().getStringList("TrournamentStarted");
		for(String st: TourStats) {
		utils.BroadcastMsg(st
				.replace("%type%", main.s("Maindata.Tournament.Type"))
				.replace("%time%", TheAPI.getTimeConventorAPI().setTimeToString(count))
				.replace("%preptime%", TheAPI.getTimeConventorAPI().setTimeToString(prep)));
		 }

		run=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(main.instance, new Runnable(){
			@Override
	           public void run(){
					
					if(prep != 0) {
						if(prep==40) utils.BroadcastMsg(main.s("Messages.Tournaments.PrepTime")
								.replace("%prefix%", main.s("Prefix"))
								.replace("%preptime%", TheAPI.getTimeConventorAPI().setTimeToString(prep)));
						if(prep==20) utils.BroadcastMsg(main.s("Messages.Tournaments.PrepTime").replace("%prefix%", main.s("Prefix")).replace("%preptime%", TheAPI.getTimeConventorAPI().setTimeToString(prep)));
						if(prep==15) utils.BroadcastMsg(main.s("Messages.Tournaments.PrepTime").replace("%prefix%", main.s("Prefix")).replace("%preptime%", TheAPI.getTimeConventorAPI().setTimeToString(prep)));
						if(prep==5) utils.BroadcastMsg(main.s("Messages.Tournaments.PrepTime").replace("%prefix%", main.s("Prefix")).replace("%preptime%", TheAPI.getTimeConventorAPI().setTimeToString(prep)));
		                --prep;
		                return;
		                }
					 int w = (int) (save*1);
					 if(count == w ) {
						 start();
						 utils.BroadcastMsg(main.s("Messages.Tournaments.PrepTimeEnded").replace("%prefix%", main.s("Prefix")));
					 }
	                if(count > 0&&prep==0) {
	                --count;
	                }
	                int a = (int) (save*0.80);
	                int b = (int) (save*0.50);
	                int c = (int) (save*0.30);
	                int d = (int) (save*0.10);
	                
	                if(count == a || count == b || count == c || count == d) {
	                	utils.BroadcastMsg(main.s("Messages.Tournaments.EndingIn")
	                			.replace("%prefix%", main.s("Prefix"))
	                			.replace("%type%", main.s("Maindata.Tournament.Type"))
	                			.replace("%remainingtime%", TheAPI.getTimeConventorAPI().setTimeToString(count)));
	                }
	                if(count == 0) {
	                	
	                	 List<String> TourEnd = main.instance.getConfig().getStringList("TrournamentEnded");
                		 for(String tend: TourEnd) {
                			 HashMap<String, Double> mined = new HashMap<String, Double>();
                			 
                			 for(Player online : Bukkit.getOnlinePlayers()){
                				mined.put(online.getDisplayName(), main.instance.getConfig().getDouble("Players.Mined."+online.getName()));
                			}
 	                		RankingAPI rank = TheAPI.getRankingAPI(mined);
 	                		if(Bukkit.getOnlinePlayers().size()==1) {
 	                		String top1 = rank.getObject(1).toString();
 	                		int top1mined = (int) rank.getValue(top1);
 	                		TheAPI.broadcastMessage(tend
	                				 .replace("%type%", main.s("Maindata.Tournament.Type"))
	                				.replace("%pos1%", top1)
	                				.replace("%mined1%", ""+top1mined)
	                				.replace("%pos2%", "-").replace("%mined2%", "-")
	                				.replace("%pos3%", "-").replace("%mined3%", "-"));
 	                		}
 	                		if(Bukkit.getOnlinePlayers().size()>1&&Bukkit.getOnlinePlayers().size()<3) {
 	                			String top1 = rank.getObject(1).toString();
 	                			int top1mined = (int) rank.getValue(top1);
 	                			String top2 = rank.getObject(2).toString();
 	                			int top2mined = (int)rank.getValue(top2);
 	                				TheAPI.broadcastMessage(tend
 	  	                				 .replace("%type%", main.s("Maindata.Tournament.Type"))
 	  	                				.replace("%pos1%", top1).replace("%mined1%", ""+top1mined)
 	  	                				.replace("%pos2%", top2).replace("%mined2%", ""+top2mined)
 	  	                				.replace("%pos3%", "-").replace("%mined3%", "-"));
 	                				}
 	                		if(Bukkit.getOnlinePlayers().size()>2) {
 	                			String top1 = rank.getObject(1).toString();
 	                			int top1mined = (int)rank.getValue(top1);
 	                			String top2 = rank.getObject(2).toString();
 	                			int top2mined = (int)rank.getValue(top2);
	                			String top3 = rank.getObject(3).toString();
	                			int top3mined = (int)rank.getValue(top3);
	                			TheAPI.broadcastMessage(tend
	    	                			.replace("%type%", main.s("Maindata.Tournament.Type"))
	    	                			.replace("%pos1%", top1).replace("%mined1%", ""+top1mined)
	    	                			.replace("%pos2%", top2).replace("%mined1%", ""+top2mined)
	    	                			.replace("%pos3%", top3).replace("%mined1%", ""+top3mined));
 	                		}
 
 	                		
                		 }
                		 stopTournament();
                		 Bukkit.getScheduler().cancelTask(run);
                		 
	                }
			}
			}, 20,20);
		}
	public static void Stop() {
		if(main.getInstance.getConfig().getBoolean("Maindata.Tournament.Running")==true) {
		Bukkit.getServer().getScheduler().cancelTask(run);
		utils.BroadcastMsg(main.s("Messages.Tournaments.Stopped")
				.replace("%prefix%", main.s("Prefix")));
		stopTournament();
		}
	
	}
	public static void Info(CommandSender s) {
		utils.msg(main.s("Messages.Tournaments.Info")
				.replace("%type%", main.getInstance.getConfig().getString("Maindata.Tournament.Type"))
				.replace("%prefix%", main.s("Prefix")), s);
		return;
		
	}
	public static boolean isRunning() {
		return main.instance.getConfig().getBoolean("Maindata.Tournament.Running");
	}
	public static boolean isStarted() {
		return main.instance.getConfig().getBoolean("Maindata.Tournament.Started");
	}
	public static String getTournament() {
		return main.instance.getConfig().getString("Maindata.Tournament.Type");
	}
	public static void start() {
		if(isRunning()==true) {
			main.instance.getConfig().set("Maindata.Tournament.Started", true);
			main.instance.saveConfig();
		}
	}
	public static void createNewTournament(String type, int time) {
		if(isRunning()==true) {
			
			return;
		}else {
			main.instance.getConfig().set("Maindata.Tournament.Running", true);
			main.instance.getConfig().set("Maindata.Tournament.Type", type);
			main.instance.getConfig().set("Maindata.Tournament.Time", time);
			main.instance.saveConfig();
		}
		return;
	}
	public static void stopTournament() {
		if(isRunning()==true) {
			main.instance.getConfig().set("Maindata.Tournament.Running", false);
			main.instance.getConfig().set("Maindata.Tournament.Started", false);
			main.instance.getConfig().set("Maindata.Tournament.Type", null);
			main.instance.getConfig().set("Maindata.Tournament.Time", null);
			main.instance.getConfig().set("Players.Mined", null);
			main.instance.saveConfig();
			return;
		}
	}
	public static void addPoint(Player p, String object, int i) {
		int pinfo = main.instance.getConfig().getInt("Players.Mined."+p.getName());
		if(tournamentutils.isRunning()==true) {
			if(getTournament().equalsIgnoreCase("DiamondHunt")) {
				if(object.equalsIgnoreCase("DIAMOND_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				return;}return;}
			if(getTournament().equalsIgnoreCase("EmeraldHunt")) {
				if(object == "EMERALD_ORE") {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				return;}return;}
			if(getTournament().equalsIgnoreCase("MostMinedOres")) {
				if(object.equalsIgnoreCase("DIAMOND_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("EMERALD_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("IRON_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("GOLD_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("LAPIS_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("REDSTONE_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}return;}
			if(getTournament().equalsIgnoreCase("JustMineEverything")) {
				if(object.equalsIgnoreCase("DIAMOND_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("EMERALD_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("IRON_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("GOLD_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("LAPIS_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				if(object.equalsIgnoreCase("REDSTONE_ORE")) {
					main.instance.getConfig().set("Players.Mined."+p.getName(), pinfo+i);
					main.instance.saveConfig();
					utils.msg(main.s("Messages.Tournaments.AddedPoint").replace("%prefix%", main.s("Prefix"))
							.replace("%points%", main.instance.getConfig().getString("Players.Mined."+p.getName())), p);
				}
				
			return;}
		}
		
	}
}

