package me.desmondcchi.summon;

import org.bukkit.plugin.java.JavaPlugin;

import me.desmondcchi.summon.commands.Spawn;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("mob").setExecutor(new Spawn());
	}
	
	
	@Override
	public void onDisable() {
		
	}
}
