package me.desmondcchi.summon;

import org.bukkit.plugin.java.JavaPlugin;

import me.desmondcchi.summon.commands.Mob;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("mob").setExecutor(new Mob());
	}
	
	
	@Override
	public void onDisable() {
		
	}
}
