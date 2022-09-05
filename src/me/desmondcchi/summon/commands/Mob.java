package me.desmondcchi.summon.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragon.Phase;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;

import net.md_5.bungee.api.ChatColor;

public class Mob implements CommandExecutor {
	private Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("mob") && sender instanceof Player) {
			player = (Player) sender;
			
			if (args.length == 0) {
				sendUsageMessage();
				
				return true;
			}
			
			Location location = player.getTargetBlock(null, 100).getLocation();
			World world = player.getWorld();
			
			spawnMob(args, location, world);
		}
		
		return true;
	}
	
	private void sendUsageMessage() {
		player.sendMessage(ChatColor.RED + "Usage: /mob <MOBTYPE> <QUANTITY>");
	}
	
	private void sendErrorMessage() {
		player.sendMessage(ChatColor.RED + "Error: Invalid mob type!");	
	}
	
	private void spawnMob(String[] args, Location location, World world) {
		String mob = args[0];
		int quantity = 1;
		
		if (args.length > 1) {
			quantity = Integer.parseInt(args[1]);
		}
		
		EntityType entity = EntityType.UNKNOWN;
		
		if (mob.equalsIgnoreCase("allay")) {
			entity = EntityType.ALLAY;
		}
		else if (mob.equalsIgnoreCase("axolotl")) {
			entity = EntityType.AXOLOTL;
		}
		else if (mob.equalsIgnoreCase("bat")) {
			entity = EntityType.BAT;
		}
		else if (mob.equalsIgnoreCase("bee")) {
			entity = EntityType.BEE;
		}
		else if (mob.equalsIgnoreCase("blaze")) {
			entity = EntityType.BLAZE;
		}
		else if (mob.equalsIgnoreCase("cat")) {
			entity = EntityType.CAT;
		}
		else if (mob.equalsIgnoreCase("cave_spider") || mob.equalsIgnoreCase("cavespider")) {
			entity = EntityType.CAVE_SPIDER;
		}
		else if (mob.equalsIgnoreCase("chicken")) {
			entity = EntityType.CHICKEN;
		}
		else if (mob.equalsIgnoreCase("cod")) {
			entity = EntityType.COD;
		}
		else if (mob.equalsIgnoreCase("cow")) {
			entity = EntityType.COW;
		}
		else if (mob.equalsIgnoreCase("creeper")) {
			entity = EntityType.CREEPER;
		}
		else if (mob.equalsIgnoreCase("dolphin")) {
			entity = EntityType.DOLPHIN;
		}
		else if (mob.equalsIgnoreCase("donkey")) {
			entity = EntityType.DONKEY;
		}
		else if (mob.equalsIgnoreCase("drowned")) {
			entity = EntityType.DROWNED;
		}
		else if (mob.equalsIgnoreCase("elder_guardian") || mob.equalsIgnoreCase("elderguardian")) {
			entity = EntityType.ELDER_GUARDIAN;
		}
		else if (mob.equalsIgnoreCase("enderdragon") || mob.equalsIgnoreCase("dragon")) {
			for (int i = 0; i < quantity; i++) {
				Entity customMob = (Entity) world.spawnEntity(location, EntityType.ENDER_DRAGON);
				EnderDragon dragon = (EnderDragon) customMob;
				dragon.setPhase(EnderDragon.Phase.CIRCLING);	
			}
			
			return;
		}
		else if (mob.equalsIgnoreCase("enderman")) {
			entity = EntityType.ENDERMAN;
		}
		else if (mob.equalsIgnoreCase("endermite")) {
			entity = EntityType.ENDERMITE;
		}
		else if (mob.equalsIgnoreCase("evoker")) {
			entity = EntityType.EVOKER;
		}
		else if (mob.equalsIgnoreCase("fox")) {
			entity = EntityType.FOX;
		}
		else if (mob.equalsIgnoreCase("frog")) {
			entity = EntityType.FROG;
		}
		else if (mob.equalsIgnoreCase("ghast")) {
			entity = EntityType.GHAST;
		}
		else if (mob.equalsIgnoreCase("giant")) {
			entity = EntityType.GIANT;
		}
		else if (mob.equalsIgnoreCase("glow_squid") || mob.equalsIgnoreCase("glowsquid")) {
			entity = EntityType.GLOW_SQUID;
		}
		else if (mob.equalsIgnoreCase("goat")) {
			entity = EntityType.GOAT;
		}
		else if (mob.equalsIgnoreCase("guardian")) {
			entity = EntityType.GUARDIAN;
		}
		else if (mob.equalsIgnoreCase("hoglin")) {
			entity = EntityType.HOGLIN;
		}
		else if (mob.equalsIgnoreCase("horse")) {
			entity = EntityType.HORSE;
		}
		else if (mob.equalsIgnoreCase("husk")) {
			entity = EntityType.HUSK;
		}
		else if (mob.equalsIgnoreCase("illusioner")) {
			entity = EntityType.ILLUSIONER;
		}
		else if (mob.equalsIgnoreCase("iron_golem") || mob.equalsIgnoreCase("irongolem")) {
			entity = EntityType.IRON_GOLEM;
		}
		else if (mob.equalsIgnoreCase("llama")) {
			entity = EntityType.LLAMA;
		}
		else if (mob.equalsIgnoreCase("magma_cube") || mob.equalsIgnoreCase("magmacube")) {
			entity = EntityType.MAGMA_CUBE;
			
			if (args.length == 3) {
				for (int i = 0; i < quantity; i++) {
					Entity customMob = (Entity) world.spawnEntity(location, entity);
					MagmaCube magmaCube = (MagmaCube) customMob;
					magmaCube.setSize(Integer.parseInt(args[2]));	
				}
				
				return;
			}
		}
		else if (mob.equalsIgnoreCase("mule")) {
			entity = EntityType.MULE;
		}
		else if (mob.equalsIgnoreCase("mushroom_cow") || mob.equalsIgnoreCase("mushroomcow") || mob.equalsIgnoreCase("mooshroom")) {
			entity = EntityType.MUSHROOM_COW;
		}
		else if (mob.equalsIgnoreCase("ocelot")) {
			entity = EntityType.OCELOT;
		}
		else if (mob.equalsIgnoreCase("panda")) {
			entity = EntityType.PANDA;
		}
		else if (mob.equalsIgnoreCase("parrot")) {
			entity = EntityType.PARROT;
		}
		else if (mob.equalsIgnoreCase("phantom")) {
			entity = EntityType.PHANTOM;
		}
		else if (mob.equalsIgnoreCase("pig")) {
			entity = EntityType.PIG;
		}
		else if (mob.equalsIgnoreCase("piglin")) {
			entity = EntityType.PIGLIN;
		}
		else if (mob.equalsIgnoreCase("piglin_brute") || mob.equalsIgnoreCase("piglinbrute")) {
			entity = EntityType.PIGLIN_BRUTE;
		}
		else if (mob.equalsIgnoreCase("pillager")) {
			entity = EntityType.PILLAGER;
		}
		else if (mob.equalsIgnoreCase("polar_bear") || mob.equalsIgnoreCase("polarbear")) {
			entity = EntityType.POLAR_BEAR;
		}
		else if (mob.equalsIgnoreCase("pufferfish")) {
			entity = EntityType.PUFFERFISH;
		}
		else if (mob.equalsIgnoreCase("rabbit")) {
			entity = EntityType.RABBIT;
		}
		else if (mob.equalsIgnoreCase("ravager")) {
			entity = EntityType.RAVAGER;
		}
		else if (mob.equalsIgnoreCase("salmon")) {
			entity = EntityType.SALMON;
		}
		else if (mob.equalsIgnoreCase("sheep")) {
			entity = EntityType.SHEEP;
		}
		else if (mob.equalsIgnoreCase("shulker")) {
			entity = EntityType.SHULKER;
		}
		else if (mob.equalsIgnoreCase("silverfish")) {
			entity = EntityType.SILVERFISH;
		}
		else if (mob.equalsIgnoreCase("skeleton")) {
			entity = EntityType.SKELETON;
		}
		else if (mob.equalsIgnoreCase("skeleton_horse") || mob.equalsIgnoreCase("skeletonhorse")) {
			entity = EntityType.SKELETON_HORSE;
		}
		else if (mob.equalsIgnoreCase("slime")) {
			entity = EntityType.SLIME;
			
			if (args.length == 3) {
				for (int i = 0; i < quantity; i++) {
					Entity customMob = (Entity) world.spawnEntity(location, entity);
					Slime slime = (Slime) customMob;
					slime.setSize(Integer.parseInt(args[2]));
				}
				
				return;	
			}
		}
		else if (mob.equalsIgnoreCase("snow_golem") || mob.equalsIgnoreCase("snowgolem") || mob.equalsIgnoreCase("snowman")) {
			entity = EntityType.SNOWMAN;
		}
		else if (mob.equalsIgnoreCase("spider")) {
			entity = EntityType.SPIDER;
		}
		else if (mob.equalsIgnoreCase("squid")) {
			entity = EntityType.SQUID;
		}
		else if (mob.equalsIgnoreCase("trader_llama") || mob.equalsIgnoreCase("traderllama")) {
			entity = EntityType.TRADER_LLAMA;
		}
		else if (mob.equalsIgnoreCase("tropical_fish") || mob.equalsIgnoreCase("tropicalfish")) {
			entity = EntityType.TROPICAL_FISH;
		}
		else if (mob.equalsIgnoreCase("turtle")) {
			entity = EntityType.TURTLE;
		}
		else if (mob.equalsIgnoreCase("vex")) {
			entity = EntityType.VEX;
		}
		else if (mob.equalsIgnoreCase("villager")) {
			entity = EntityType.VILLAGER;
		}
		else if (mob.equalsIgnoreCase("VINDICATOR")) {
			entity = EntityType.VINDICATOR;
		}
		else if (mob.equalsIgnoreCase("wandering_trader") || mob.equalsIgnoreCase("wanderingtrader")) {
			entity = EntityType.WANDERING_TRADER;
		}
		else if (mob.equalsIgnoreCase("warden")) {
			entity = EntityType.WARDEN;
		}
		else if (mob.equalsIgnoreCase("witch")) {
			entity = EntityType.WITCH;
		}
		else if (mob.equalsIgnoreCase("wither")) {
			entity = EntityType.WITHER;
		}
		else if (mob.equalsIgnoreCase("wither_skeleton") || mob.equalsIgnoreCase("witherskeleton")) {
			entity = EntityType.WITHER_SKELETON;
		}
		else if (mob.equalsIgnoreCase("wolf")) {
			entity = EntityType.WOLF;
		}
		else if (mob.equalsIgnoreCase("zoglin")) {
			entity = EntityType.ZOGLIN;
		}
		else if (mob.equalsIgnoreCase("zombie")) {
			entity = EntityType.ZOMBIE;
		}
		else if (mob.equalsIgnoreCase("zombie_horse") || mob.equalsIgnoreCase("zombiehorse")) {
			entity = EntityType.ZOMBIE_HORSE;
		}
		else if (mob.equalsIgnoreCase("zombie_villager") || mob.equalsIgnoreCase("zombievillager")) {
			entity = EntityType.ZOMBIE_VILLAGER;
		}
		else if (mob.equalsIgnoreCase("zombified_piglin") || mob.equalsIgnoreCase("zombifiedpiglin")) {
			entity = EntityType.ZOMBIFIED_PIGLIN;
		}
		else {
			sendErrorMessage();
			
			return;
		}
		
		if (args.length > 2) {
			sendUsageMessage();
			
			return;
		}
		
		for (int i = 0; i < quantity; i++) {
			world.spawnEntity(location, entity);
		}
	}
}
