package com.github.abujaki21.jeevesCraft;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class RecipeBook {
	public static void enableRecipes(Server server, YamlConfiguration config){
		//Recipe to turn Rotten Flesh into Leather
		Logger logger = server.getLogger();
		
		if(config.getBoolean("Recipe.Leather.Enabled")){
			int amt = config.getInt("Recipe.Leather.FleshForLeather");
			ShapelessRecipe leather = new ShapelessRecipe(new ItemStack(Material.LEATHER,1));
			leather = leather.addIngredient(amt, Material.ROTTEN_FLESH);
			server.addRecipe(leather);
			logger.info("Added recipe: " + amt + " ROTTEN_FLESH for 1 LEATHER");
		}

		//Recipe for Horse armor:
		// _ _ X
		// X X X     - Where X is Iron, Gold, or Diamond
		// X _ X
		if(config.getBoolean("Recipe.HorseArmor.Iron")){
			ShapedRecipe HAIarmor = new ShapedRecipe(new ItemStack(Material.IRON_BARDING));
			HAIarmor.shape("  I","III","I I");
			HAIarmor.setIngredient('I',Material.IRON_INGOT);
			server.addRecipe(HAIarmor);
			logger.info("Added recipe: Horse Armor (Iron)");
		}
		if(config.getBoolean("Recipe.HorseArmor.Gold")){
			ShapedRecipe HAGarmor = new ShapedRecipe(new ItemStack(Material.GOLD_BARDING));
			HAGarmor.shape("  G","GGG","G G");
			HAGarmor.setIngredient('G', Material.GOLD_INGOT);
			server.addRecipe(HAGarmor);
			logger.info("Added recipe: Horse Armor (Gold)");
		}
		if(config.getBoolean("Recipe.HorseArmor.Diamond")){
			ShapedRecipe HADarmor = new ShapedRecipe(new ItemStack(Material.DIAMOND_BARDING));
			HADarmor.shape("  D","DDD","D D");
			HADarmor.setIngredient('D', Material.DIAMOND);
			server.addRecipe(HADarmor);
			logger.info("Added recipe: Horse Armor (Diamond)");
		}

		//Recipe for Saddle
		if(config.getBoolean("Recipe.Saddle")){
			ShapedRecipe saddle = new ShapedRecipe(new ItemStack(Material.SADDLE));
			saddle.shape("  u","LLL","LIL");
			saddle.setIngredient('u', Material.LEASH);
			saddle.setIngredient('L', Material.LEATHER);
			saddle.setIngredient('I', Material.IRON_INGOT);
			server.addRecipe(saddle);
			logger.info("Added recipe: Saddle");
		}

		//Recipe for Nametag
		if(config.getBoolean("Recipe.Nametag")){
			ShapelessRecipe label = new ShapelessRecipe(new ItemStack(Material.NAME_TAG));
			label.addIngredient(Material.STRING);
			label.addIngredient(Material.PAPER);
			label.addIngredient(Material.INK_SACK);
			server.addRecipe(label);
			logger.info("Added recipe: Nametag");
		}
		
		//Ice and Packed Ice recipe
		if(config.getBoolean("Recipe.Ice")){
			ShapelessRecipe Ice = new ShapelessRecipe(new ItemStack(Material.ICE));
			Ice.addIngredient(9, Material.SNOW_BALL);
			server.addRecipe(Ice);
			logger.info("Added recipe: Ice");
			ShapelessRecipe PackedIce = new ShapelessRecipe(new ItemStack(Material.PACKED_ICE));
			PackedIce.addIngredient(4, Material.SNOW_BLOCK);
			server.addRecipe(PackedIce);
			logger.info("Added recipe: Packed Ice");
		}
		
		//Miscellanious recipes
		if(config.getBoolean("Recipe.Misc")){
			ShapedRecipe mycellium = new ShapedRecipe(new ItemStack(Material.MYCEL));
			mycellium.shape("MWM","mDm","BBB");
			mycellium.setIngredient('M', Material.BROWN_MUSHROOM);
			mycellium.setIngredient('m', Material.RED_MUSHROOM);
			mycellium.setIngredient('D', Material.DIRT);
			mycellium.setIngredient('B', Material.BONE); //Can't use bonemeal
			mycellium.setIngredient('W', Material.WATER_BUCKET);
			server.addRecipe(mycellium);
			mycellium.shape("mWm","MDM","BBB");
			server.addRecipe(mycellium);
			mycellium.shape("mWM","mDM","BBB");
			server.addRecipe(mycellium);
			mycellium.shape("MWm","MDm","BBB");
			server.addRecipe(mycellium);
			mycellium.shape("mWM","MDm","BBB");
			server.addRecipe(mycellium);
			mycellium.shape("MWm","mDM","BBB");
			server.addRecipe(mycellium);
			logger.info("Added recipe: Mycellium");
			
			ShapedRecipe podzol = new ShapedRecipe(new ItemStack(Material.DIRT,1,(short)2));
			podzol.shape("LLL","WGW");
			podzol.setIngredient('L', Material.LEAVES);
			podzol.setIngredient('G', Material.GRASS);
			podzol.setIngredient('W', Material.WATER_BUCKET);
			server.addRecipe(podzol);
			logger.info("Added recipe: Podzol");
			
		}
		
		if(config.getBoolean("Recipe.Sponge")){
			/*//Four of any huge mushroom block
			//Two types of huge mushroom blocks, so we need to add all recipes...
			/*4:0
			ShapelessRecipe sponge = new ShapelessRecipe(new ItemStack(Material.SPONGE));
			sponge.addIngredient(4, Material.HUGE_MUSHROOM_1);
			server.addRecipe(sponge);
			
			//1:3
			sponge.removeIngredient(1, Material.HUGE_MUSHROOM_1);
			sponge.addIngredient(Material.HUGE_MUSHROOM_2);
			server.addRecipe(sponge);
			
			//2:2
			sponge.removeIngredient(1, Material.HUGE_MUSHROOM_1);
			sponge.addIngredient(Material.HUGE_MUSHROOM_2);
			server.addRecipe(sponge);
			
			//3:1
			sponge.removeIngredient(1, Material.HUGE_MUSHROOM_1);
			sponge.addIngredient(Material.HUGE_MUSHROOM_2);
			server.addRecipe(sponge);
			
			//4:0
			sponge.removeIngredient(1, Material.HUGE_MUSHROOM_1);
			sponge.addIngredient(Material.HUGE_MUSHROOM_2);
			server.addRecipe(sponge);
			
			//logger.info("Added recipe: Sponge (5)");
			*/

			//TODO: Mushroom blocks are weird. The above recipies for some reason do not work.
			//Added test recipe below that does work. Will change in future update
		//	ShapedRecipe sponge2 = new ShapedRecipe(new ItemStack(Material.SPONGE));
		//	sponge2.shape(" S ","SCS"," S ");
		//	sponge2.setIngredient('S',Material.SAND);
		//	sponge2.setIngredient('C', Material.CACTUS);
		//	server.addRecipe(sponge2);
			
			logger.info("Sponge recipe no longer available.");
		}
	}
}
