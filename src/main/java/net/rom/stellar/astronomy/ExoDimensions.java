package net.rom.stellar.astronomy;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import net.rom.stellar.conf.SConfigSystems;

public class ExoDimensions {

	public static DimensionType YZCETIB;
	public static DimensionType YZCETIC;

	public static void init() {
		ExoDimensions.YZCETIB = WorldUtil.getDimensionTypeById(SConfigSystems.id_yz_b);
		ExoDimensions.YZCETIC = WorldUtil.getDimensionTypeById(SConfigSystems.id_yz_c);

	}
}