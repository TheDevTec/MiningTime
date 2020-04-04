package MiningTime;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import Utils.utils;
import me.Straiker123.TheAPI;

public class main extends JavaPlugin {
	
	public static main instance;
    public static main getInstance;
    //File newConfig; 
    //FileConfiguration newConfigz;
    static main m = main.instance;
    
	public void onLoad() {
		TheAPI.getConsole().sendMessage(TheAPI.colorize("&2&lMining&a&lTime"+"&7 *********************************************"));
		TheAPI.getConsole().sendMessage(TheAPI.colorize("&2&lMining&a&lTime"+"&a Plugin has been &2&lLoaded &a."));
		TheAPI.getConsole().sendMessage(TheAPI.colorize("&2&lMining&a&lTime"+"&7 *********************************************"));
	}
	@Override
	public void onEnable(){

		getConfig().options().copyDefaults(true);
		saveConfig();
		
		instance=this;
		getInstance=this;
		
		Bukkit.getPluginCommand("miningtime").setExecutor(new miningtimecmd());
		Bukkit.getPluginManager().registerEvents(new onBlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new onJoin(), this);
		
		
		TheAPI.getConsole().sendMessage(TheAPI.colorize("&2&lMining&a&lTime"+"&7 *********************************************"));
		TheAPI.getConsole().sendMessage(TheAPI.colorize("&2&lMining&a&lTime"+"&a Plugin has been &2&lEnabled succesfully &a."));
		TheAPI.getConsole().sendMessage(TheAPI.colorize("&2&lMining&a&lTime"+"&7 *********************************************"));
	}
	public void onDisable() {
		reloadConfig(); 
		saveConfig();
	}
	 public static String s(String s) {
		 	return main.instance.getConfig().getString(s);
	 }
	 public static boolean hasPerm(CommandSender s, String permission) {
		 if(s.hasPermission(permission)) {return true;}
			s.sendMessage(utils.colorize(main.s("Messages.MainMessages.NoPermissions")
					.replace("%player%", s.getName())
					.replace("%playername%", s.getName())
					.replace("%permission%", permission)));
			return false;
	 }
}
