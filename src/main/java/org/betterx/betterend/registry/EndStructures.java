package org.betterx.betterend.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

import org.betterx.bclib.api.v2.tag.TagAPI;
import org.betterx.bclib.world.structures.BCLStructure;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.world.structures.features.*;
import org.betterx.betterend.world.structures.piece.*;

public class EndStructures {
    public static final StructurePieceType VOXEL_PIECE = register("voxel", VoxelPiece::new);
    public static final StructurePieceType MOUNTAIN_PIECE = register("mountain_piece", CrystalMountainPiece::new);
    public static final StructurePieceType CAVE_PIECE = register("cave_piece", CavePiece::new);
    public static final StructurePieceType LAKE_PIECE = register("lake_piece", LakePiece::new);
    public static final StructurePieceType PAINTED_MOUNTAIN_PIECE = register("painted_mountain_piece",
                                                                             PaintedMountainPiece::new);
    public static final StructurePieceType NBT_PIECE = register("nbt_piece", NBTPiece::new);

    public static final BCLStructure<GiantMossyGlowshroomStructure> GIANT_MOSSY_GLOWSHROOM = new BCLStructure<>(
            BetterEnd.makeID("giant_mossy_glowshroom"),
            GiantMossyGlowshroomStructure::new,
            Decoration.SURFACE_STRUCTURES,
            16,
            8
    );
    public static final BCLStructure<MegaLakeStructure> MEGALAKE = new BCLStructure<>(
            BetterEnd.makeID("megalake"),
            MegaLakeStructure::new,
            Decoration.RAW_GENERATION,
            4,
            1
    );
    public static final BCLStructure<MegaLakeSmallStructure> MEGALAKE_SMALL = new BCLStructure<>(
            BetterEnd.makeID("megalake_small"),
            MegaLakeSmallStructure::new,
            Decoration.RAW_GENERATION,
            4,
            1
    );
    public static final BCLStructure<MountainStructure> MOUNTAIN = new BCLStructure<>(
            BetterEnd.makeID("mountain"),
            MountainStructure::new,
            Decoration.RAW_GENERATION,
            3,
            2
    );
    public static final BCLStructure<PaintedMountainStructure> PAINTED_MOUNTAIN = new BCLStructure<>(
            BetterEnd.makeID("painted_mountain"),
            PaintedMountainStructure::new,
            Decoration.RAW_GENERATION,
            3,
            2
    );
    public static final BCLStructure<EternalPortalStructure> ETERNAL_PORTAL = new BCLStructure<>(
            BetterEnd.makeID("eternal_portal"),
            EternalPortalStructure::new,
            Decoration.SURFACE_STRUCTURES,
            16,
            6
    );
    public static final BCLStructure<GiantIceStarStructure> GIANT_ICE_STAR = new BCLStructure<>(
            BetterEnd.makeID("giant_ice_star"),
            GiantIceStarStructure::new,
            Decoration.SURFACE_STRUCTURES,
            16,
            8
    );

    public static void register() {
    }

    private static StructurePieceType register(String id, StructurePieceType pieceType) {
        return Registry.register(Registry.STRUCTURE_PIECE, BetterEnd.makeID(id), pieceType);
    }

    public static void addBiomeStructures(ResourceLocation biomeID, Holder<Biome> biome) {
        if (!biomeID.getPath().contains("mountain") && !biomeID.getPath().contains("lake")) {
            TagAPI.addBiomeTag(ETERNAL_PORTAL.biomeTag, biome.value());
        }
    }
}
