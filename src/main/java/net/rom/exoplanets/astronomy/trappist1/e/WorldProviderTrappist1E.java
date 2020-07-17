/**
 * Copyright (C) 2020 Interstellar:  Exoplanets
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.rom.exoplanets.astronomy.trappist1.e;

import java.util.List;

import asmodeuscore.core.astronomy.dimension.world.worldengine.WE_Biome;
import asmodeuscore.core.astronomy.dimension.world.worldengine.WE_ChunkProvider;
import asmodeuscore.core.astronomy.dimension.world.worldengine.WE_WorldProvider;
import asmodeuscore.core.astronomy.dimension.world.worldengine.standardcustomgen.WE_CaveGen;
import asmodeuscore.core.astronomy.dimension.world.worldengine.standardcustomgen.WE_RavineGen;
import asmodeuscore.core.astronomy.dimension.world.worldengine.standardcustomgen.WE_TerrainGenerator;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.rom.exoplanets.astronomy.trappist1.TrappistBlocks;
import net.rom.exoplanets.astronomy.trappist1.TrappistDimensions;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_Beach;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_DeepOcean;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_Dunes;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_Mountains;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_Ocean;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_Plains;
import net.rom.exoplanets.astronomy.trappist1.e.biomes.Trappist1_E_River;
import net.rom.exoplanets.astronomy.trappist1.e.worldgen.BiomeDecoratorTrappist1E;
import net.rom.exoplanets.astronomy.trappist1.e.worldgen.BiomeProviderTrappist1E;
import net.rom.exoplanets.init.InitPlanets;
import net.rom.exoplanets.internal.AstronomicalConstants;

public class WorldProviderTrappist1E extends WE_WorldProvider {
	
	public static WE_ChunkProvider chunk;
	
	@Override
	public boolean enableAdvancedThermalLevel() {
		return true;
	}
	
	@Override
	protected float getThermalValueMod()
	{
		return 0.2F;
	}
	
	@Override
    public double getHorizon() {
        return 44.0D;
    }

	@Override
	public double getFuelUsageMultiplier() {
		return 1.5;
	}

	@Override
	public float getFallDamageModifier() {
		return 0;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return InitPlanets.trappiste;
	}

	@Override
	public int getDungeonSpacing() {
		return 0;
	}

	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		return null;
	}

	@Override
	public void genSettings(WE_ChunkProvider cp) {
	chunk = cp;
		
		cp.createChunkGen_List .clear(); 
		cp.createChunkGen_InXZ_List .clear(); 
		cp.createChunkGen_InXYZ_List.clear(); 
		cp.decorateChunkGen_List .clear(); 
		
		WE_Biome.setBiomeMap(cp, 1.4D, 6, 1000.0D, 1.0D);	

		WE_TerrainGenerator terrainGenerator = new WE_TerrainGenerator(); 
		terrainGenerator.worldStoneBlock = TrappistBlocks.TrappistE.trap1e_stone.getDefaultState(); 
		terrainGenerator.worldSeaGen = true;
		terrainGenerator.worldSeaGenBlock = Blocks.WATER.getDefaultState();
		terrainGenerator.worldSeaGenMaxY = 64;
		cp.createChunkGen_List.add(terrainGenerator);
		
		//-// 
		WE_CaveGen cg = new WE_CaveGen(); 
		cg.replaceBlocksList .clear(); 
		cg.addReplacingBlock(terrainGenerator.worldStoneBlock); 
		cg.lavaMaxY = 15;
		cp.createChunkGen_List.add(cg); 
		//-// 
		 
		WE_RavineGen rg = new WE_RavineGen();
		rg.replaceBlocksList    .clear();
		rg.addReplacingBlock(terrainGenerator.worldStoneBlock);
		rg.lavaBlock = Blocks.LAVA.getDefaultState();
		rg.lavaMaxY = 15;		
		cp.createChunkGen_List.add(rg);
		
		cp.worldGenerators.clear();
		cp.biomesList.clear();
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_Ocean(-3.8D, 3.8D, false));
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_Beach(-3.5D, 3.2D, 1));
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_Plains(-3.0D, 3.0D));
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_River(-1.5D, 1.5D));
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_Dunes(-1.2D, 1.2D));
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_Mountains(-0.3D, 0.3D, 100, 2.8D, 4));	
		WE_Biome.addBiomeToGeneration(cp, new Trappist1_E_Ocean(-0.0D, 0.0D, true));		
	}

	@Override
	public BiomeDecoratorSpace getDecorator() {
		return new BiomeDecoratorTrappist1E();
	}

	@Override
	public void onChunkProvider(int cX, int cZ, ChunkPrimer primer) {
		
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		
	}

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float partialTicks) {
        float angle = this.world.getCelestialAngle(partialTicks);
        float value = 1.0F - (MathHelper.cos(angle * AstronomicalConstants.TWO_PI_F) * 2.0F + 0.25F);
        value = MathHelper.clamp(value, 0.0F, 1.0F);
        return value * value * 0.5F + 0.3F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getSunBrightness(float partialTicks) {
        float f1 = this.world.getCelestialAngle(1.0F);
        float f2 = 1.0F - (MathHelper.cos(f1 * AstronomicalConstants.TWO_PI_F) * 2.0F + 0.2F);
        f2 = MathHelper.clamp(f2, 0.0F, 1.0F);
        f2 = 1.2F - f2;
        return f2 * 0.8F;
    }

    @Override
    public Vector3 getFogColor()
    {
        float f = 0.6F - this.getStarBrightness(1.0F);
        return new Vector3(213f / 255F * f, 72f / 255F * f, 3f / 255F * f);        
    }

    @Override
    public Vector3 getSkyColor()
    {
        float f = 0.3F - this.getStarBrightness(1.0F);
        return new Vector3(228 / 255.0F * f, 75 / 255.0F * f, 1 / 255.0F * f);
       
    }

	@Override
	public boolean hasSunset() {
		return false;
	}
	
    @Override
    public boolean shouldForceRespawn() {
        return !ConfigManagerCore.forceOverworldRespawn;
    }   

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return WE_ChunkProvider.class;
	}

	@Override
	public DimensionType getDimensionType() {
		return TrappistDimensions.TRAPPIST_1E;
	}
	
    @Override 
    public Class<? extends BiomeProvider> getBiomeProviderClass() { 
    	return BiomeProviderTrappist1E.class; 
    }


}