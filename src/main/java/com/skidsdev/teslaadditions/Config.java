package com.skidsdev.teslaadditions;

import java.io.File;

import com.skidsdev.teslaadditions.block.BlockRegister;
import com.skidsdev.teslaadditions.item.ItemRegister;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Config
{
	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_CLIENT = "client";
	public static final String CATEGORY_DEBUG = "debug";	
	
	public static long furnaceBasePowerCap;
	public static long furnaceBasePowerUse;
	
	public static long stirlingBasePowerCap;
	public static long stirlingBasePowerGen;
	public static long stirlingBasePowerOut;
	
	public static long batteryBasePower;
	
	public static long capacitorBasePowerCap;
	
	public static Configuration configuration;
	
	public Config(File configFile)
	{
		configuration = new Configuration(configFile);
		configuration.load();
		processConfigFile();
		
		configuration.save();
	}
	
	public void setupBlocks()
	{
		BlockRegister.createBlocks();
	}
	
	public void setupItems()
	{
		ItemRegister.createItems();
	}
		
	public void setupCrafting()
	{
		
	}
	
	private void processConfigFile()
	{
		doGeneralConfigs();
		doDebugConfigs();
	}
	
	private void doDebugConfigs()
	{
		Property p;
		p = configuration.get(CATEGORY_GENERAL, "furnaceBasePowerCap", 40000);
		p.setComment("The base power storage capacity of the ElectroFurnace");
		furnaceBasePowerCap = p.getLong();
		
		p = configuration.get(CATEGORY_GENERAL, "furnaceBasePowerUse", 20);
		p.setComment("The base power usage of the ElectroFurnace");
		furnaceBasePowerUse = p.getLong();

		p = configuration.get(CATEGORY_GENERAL, "stirlingBasePowerCap", 80000);
		p.setComment("The base power storage capacity of the StirlingGenerator");
		stirlingBasePowerCap = p.getLong();

		p = configuration.get(CATEGORY_GENERAL, "stirlingBasePowerGen", 20);
		p.setComment("The base power generation rate of the StirlingGenerator");
		stirlingBasePowerGen = p.getLong();

		p = configuration.get(CATEGORY_GENERAL, "stirlingBasePowerOut", 40);
		p.setComment("The base power output rate of the StirlingGenerator");
		stirlingBasePowerOut = p.getLong();

		p = configuration.get(CATEGORY_GENERAL, "batteryBasePower", 40000);
		p.setComment("The base power capacity of the ItemBattery");
		batteryBasePower = p.getLong();

		p = configuration.get(CATEGORY_GENERAL, "capacitorBasePowerCap", 400000);
		p.setComment("The base power capacity of BlockCapacitor");
		capacitorBasePowerCap = p.getLong();
	}
	
	private void doGeneralConfigs()
	{
		
	}
}
