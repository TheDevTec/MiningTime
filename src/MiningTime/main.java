package MiningTime;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import Utils.utils;

public class main extends JavaPlugin {
	
	public static main instance;
    public static main getInstance;
    //File newConfig; 
    //FileConfiguration newConfigz;
    static main m = main.instance;
    
	@Override
	public void onEnable(){
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		instance=this;
		getInstance=this;
		
		Bukkit.getPluginCommand("miningtime").setExecutor(new miningtimecmd());
		Bukkit.getPluginManager().registerEvents(new onBlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new onJoin(), this);
		
	}
	
	/*public void saveNewConfig(){
		try{
		newConfigz.save(newConfig);
		 
		}catch(Exception e){
		e.printStackTrace();
		}
	}*/
	
	public void onDisable() {
		reloadConfig(); 
		saveConfig();
	}
	
	
	 public static String s(String s) {
		 	return main.instance.getConfig().getString(s);
	 }
			/*if(m.getConfig().getString(s)!=null) {
				return m.getConfig().getString(s);
			}
			warn("String '"+s+"' isn't exist in Config.yml, please report this bug on my Discord Houska02#0163 ");
			return "&4ERROR, Missing path, See console for more informations";*/
	/* public static String help(String s, String cmd, String help) {
			if(m.getConfig().getString("Help."+s)!=null)
				return m.getConfig().getString("Help."+s);
				else {
			warn("String 'Help."+s+"' isn't exist in Config.yml, please report this bug on my Discord Houska02#0163 ");
			return "&4ERROR, Missing path, See console for more informations";}
		}*/
	 
	 /*public static void Help(CommandSender s, String cmd, String help) { 
		 utils.msg(m.getConfig().getString("FormatOfHelp")
		    		.replace("%prefix%", s("Prefix"))
		    		.replace("%command%", cmd).replace("%space%", " - ")
		    		.replace("%help%", s(help)),s);
			}*/
	 
	 public static void warn(String s) {
			Bukkit.getLogger().log(Level.WARNING,"["+getInstance.getName()+"] "+s);
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
