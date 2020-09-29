package net.romvoid95.common.world.cave.config;

import net.romvoid95.common.world.cave.config.cave.*;
import net.romvoid95.common.world.cave.config.cavern.ConfigCaverns;
import net.romvoid95.common.world.cave.config.ravine.ConfigRavine;
import net.minecraftforge.common.config.Config;

public class ConfigUndergroundGen {
    @Config.Name("Caves")
    @Config.Comment("Settings used in the generation of caves.")
    public ConfigCaves caves = new ConfigCaves();

    @Config.Name("Caverns")
    @Config.Comment("Settings used in the generation of caverns. Caverns are spacious caves at low altitudes.")
    public ConfigCaverns caverns = new ConfigCaverns();

    @Config.Name("Water Regions")
    @Config.Comment("Settings used in the generation of water regions.")
    public ConfigWaterRegions waterRegions = new ConfigWaterRegions();

    @Config.Name("Ravines")
    @Config.Comment("Settings used for ravine generation.")
    public ConfigRavine ravines = new ConfigRavine();

    @Config.Name("Miscellaneous")
    @Config.Comment("Miscellaneous settings used in cave and cavern generation.")
    public ConfigMisc miscellaneous = new ConfigMisc();
}
