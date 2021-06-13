package ru.betterend.blocks.basis;

import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.bclib.client.models.ModelsHelper;
import ru.betterend.client.models.Patterns;
import ru.betterend.interfaces.IColorProvider;
import ru.betterend.registry.EndBlocks;

public class StoneLanternBlock extends EndLanternBlock implements IColorProvider {
	private static final VoxelShape SHAPE_CEIL = Block.box(3, 1, 3, 13, 16, 13);
	private static final VoxelShape SHAPE_FLOOR = Block.box(3, 0, 3, 13, 15, 13);
	
	public StoneLanternBlock(Block source) {
		super(FabricBlockSettings.copyOf(source).luminance(15));
	}
	
	@Override
	public BlockColor getProvider() {
		return ((IColorProvider) EndBlocks.AURORA_CRYSTAL).getProvider();
	}

	@Override
	public ItemColor getItemProvider() {
		return ((IColorProvider) EndBlocks.AURORA_CRYSTAL).getItemProvider();
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return state.getValue(IS_FLOOR) ? SHAPE_FLOOR : SHAPE_CEIL;
	}

	@Override
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		String blockName = resourceLocation.getPath();
		Optional<String> pattern = blockState.getValue(IS_FLOOR) ?
				Patterns.createJson(Patterns.BLOCK_STONE_LANTERN_FLOOR, blockName, blockName) :
				Patterns.createJson(Patterns.BLOCK_STONE_LANTERN_CEIL, blockName, blockName);
		return ModelsHelper.fromPattern(pattern);
	}
}
