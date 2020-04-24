package net.rom.exoplanets.block.terrain;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockMoltenFluid extends BlockFluidClassic {

    public BlockMoltenFluid(Fluid fluid) {
        super(fluid, Material.LAVA);
    }
    
    @Override
    public String getUnlocalizedName() {
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        return fluid != null ? fluid.getUnlocalizedName() : super.getUnlocalizedName();
    }

}
