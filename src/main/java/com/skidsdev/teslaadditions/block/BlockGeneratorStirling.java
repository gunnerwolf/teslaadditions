package com.skidsdev.teslaadditions.block;

import com.skidsdev.teslaadditions.TeslaAdditions;
import com.skidsdev.teslaadditions.tile.TileEntityGeneratorStirling;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGeneratorStirling extends BlockMachine
{
	public BlockGeneratorStirling()
	{
		super("blockGeneratorStirling");
	}
	
	@Override
	public TileEntity createTileEntity(World worldIn, IBlockState state)
	{
		return new TileEntityGeneratorStirling();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack stack, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{
			player.openGui(TeslaAdditions.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
}
