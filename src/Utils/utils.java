package Utils;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import MiningTime.main;


public class utils {
	main m = main.instance;
	public static String colorize(String string) {
		if(string == null)return null;
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static void msg(String message, CommandSender target) {
		target.sendMessage(colorize(message));
	}
	public static void BroadcastMsg(String message) { 
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
	}
	public static void buildHelpMsg(CommandSender s, String cmd, String path) {
		msg("&2"+cmd+" &9- "+main.instance.getConfig().getString(path), s);
	}
	 public static void warn(String s) {
			Bukkit.getLogger().log(Level.WARNING,"["+main.getInstance.getName()+"] "+s);
		}
}