package net.romvoid95.api.world.worldgen.feature.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.romvoid95.common.utility.mc.BlockUtil;

public abstract class ExoGenTreeBase extends WorldGenAbstractTree {
	
    protected IBlockState logBlock;
    protected IBlockState leavesBlock;
    protected int trunkSize;
    protected int crownSize;
    protected boolean noLeaves;
    protected boolean treesCanGenerateOnSand;
    
    protected IBlockState saplingBlock;

    protected int generateFlag;

    protected int minTrunkSize;
    protected int maxTrunkSize;
    protected int minCrownSize;
    protected int maxCrownSize;

    protected ArrayList<IBlockState> validGroundBlocks;
    protected ArrayList<Material> canGrowIntoMaterials;

	public ExoGenTreeBase(boolean notify) {
		super(notify);
	}
	
	public ExoGenTreeBase() {
		this(false);
		
        this.setLogBlock(Blocks.LOG.getDefaultState());
        this.setLeavesBlock(Blocks.LEAVES.getDefaultState());
        this.trunkSize = 2;
        this.crownSize = 4;
        this.setNoLeaves(false);
        this.setTreesCanGenerateOnSand(false);
        
        this.saplingBlock = Blocks.SAPLING.getDefaultState();

        this.generateFlag = 2;

        // These need to default to zero as they're only used when generating trees from saplings.
        this.setMinTrunkSize(0);
        this.setMaxTrunkSize(0);
        this.setMinCrownSize(0);
        this.setMaxCrownSize(0);

        // Each tree sub-class is responsible for using (or not using) this list as part of its generation logic.
        this.validGroundBlocks = new ArrayList<>(Arrays.asList(
                Blocks.GRASS.getDefaultState(),
                Blocks.DIRT.getDefaultState(),
                BlockUtil.getStateDirt(BlockDirt.DirtType.PODZOL),
                BlockUtil.getStateSand(BlockSand.EnumType.RED_SAND)
        ));

        this.canGrowIntoMaterials = new ArrayList<>(Arrays.asList(
            Material.AIR,
            Material.WOOD,
            Material.LEAVES,
            Material.GRASS,
            Material.GROUND,
            Material.PLANTS,
            Material.VINE,
            Material.WATER,
            Material.SNOW
        ));
	}
	
    public void buildTrunk(World world, Random rand, int x, int y, int z) {

    }

    public void buildBranch(World world, Random rand, int x, int y, int z, int dX, int dZ, int logLength, int leaveSize) {

    }

    public void buildLeaves(World world, int x, int y, int z) {

    }

    public void buildLeaves(World world, Random rand, int x, int y, int z, int size) {

    }

    protected boolean isGroundValid(World world, BlockPos trunkPos) {

        return this.isGroundValid(world, trunkPos, this.treesCanGenerateOnSand);
    }

    protected boolean isGroundValid(World world, BlockPos trunkPos, boolean sandAllowed) {

        IBlockState g = world.getBlockState(new BlockPos(trunkPos.getX(), trunkPos.getY() - 1, trunkPos.getZ()));

        if (g.getBlock() == Blocks.SAND && !sandAllowed) {
            return false;
        }

        for (int i = 0; i < this.validGroundBlocks.size(); i++) {
            if (g == this.validGroundBlocks.get(i)) {
                return true;
            }
        }

        return false;
    }

    protected boolean isGroundValid(World world, ArrayList<BlockPos> trunkPos) {

        if (trunkPos.isEmpty()) {
            throw new RuntimeException("Unable to determine if ground is valid. No trunks.");
        }

        for (int i = 0; i < trunkPos.size(); i++) {
            if (!this.isGroundValid(world, trunkPos.get(i))) {
                return false;
            }
        }

        return true;
    }

    protected void placeLogBlock(World world, BlockPos pos, IBlockState logBlock, int generateFlag) {

        if (this.isReplaceable(world, pos)) {
            world.setBlockState(pos, logBlock, generateFlag);
        }
    }

    protected void placeLeavesBlock(World world, BlockPos pos, IBlockState leavesBlock, int generateFlag) {

        if (world.isAirBlock(pos)) {
            world.setBlockState(pos, leavesBlock, generateFlag);
        }
    }

    protected void placeLogBlock(World world, BlockPos pos, IBlockState logBlock, int generateFlag, ExoGenTreeData treeData) {

        this.placeLogBlock(world, pos, logBlock, generateFlag);
    }

    protected void placeLeavesBlock(World world, BlockPos pos, IBlockState leavesBlock, int generateFlag, ExoGenTreeData treeData) {

        this.placeLeavesBlock(world, pos, leavesBlock, generateFlag);
    }

    @Override
    public boolean isReplaceable(World world, BlockPos pos) {

        IBlockState state = world.getBlockState(pos);

        return state.getBlock().isAir(state, world, pos)
                || state.getBlock().isLeaves(state, world, pos)
                || state.getBlock().isWood(world, pos)
                || canGrowInto(state.getBlock());
    }

    @Override
    protected boolean canGrowInto(Block block) {

        if (block instanceof BlockPlanks) {
            return false;
        }

        Material material = block.getDefaultState().getMaterial();

        for (int i = 0; i < this.canGrowIntoMaterials.size(); i++) {
            if (material == this.canGrowIntoMaterials.get(i)) {
                return true;
            }
        }

        return false;
    }

    public IBlockState getTrunkLog(IBlockState defaultLog) {

        IBlockState trunkLog;

        try {
            trunkLog = defaultLog.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.NONE);
        }
        catch (Exception e) {
            trunkLog = defaultLog;
        }

        return trunkLog;
    }

    public IBlockState getLogBlock() {

        return logBlock;
    }

    public ExoGenTreeBase setLogBlock(IBlockState logBlock) {

        this.logBlock = logBlock;
        return this;
    }

    public IBlockState getLeavesBlock() {

        return leavesBlock;
    }

    public ExoGenTreeBase setLeavesBlock(IBlockState leavesBlock) {

        this.leavesBlock = leavesBlock;
        return this;
    }

    public int getTrunkSize() {

        return trunkSize;
    }

    public ExoGenTreeBase setTrunkSize(int trunkSize) {

        this.trunkSize = trunkSize;
        return this;
    }

    public int getCrownSize() {

        return crownSize;
    }

    public ExoGenTreeBase setCrownSize(int crownSize) {

        this.crownSize = crownSize;
        return this;
    }

    public boolean getNoLeaves() {

        return noLeaves;
    }

    public ExoGenTreeBase setNoLeaves(boolean noLeaves) {

        this.noLeaves = noLeaves;
        return this;
    }
    
    public ExoGenTreeBase setTreesCanGenerateOnSand(boolean notOnSand) {
    	this.treesCanGenerateOnSand = notOnSand;
    	return this;
    }

    public IBlockState getSaplingBlock() {

        return saplingBlock;
    }

    public ExoGenTreeBase setSaplingBlock(IBlockState saplingBlock) {

        this.saplingBlock = saplingBlock;
        return this;
    }

    public int getGenerateFlag() {

        return generateFlag;
    }

    public ExoGenTreeBase setGenerateFlag(int generateFlag) {

        this.generateFlag = generateFlag;
        return this;
    }

    public int getMinTrunkSize() {

        return minTrunkSize;
    }

    public ExoGenTreeBase setMinTrunkSize(int minTrunkSize) {

        this.minTrunkSize = minTrunkSize;
        return this;
    }

    public int getMaxTrunkSize() {

        return maxTrunkSize;
    }

    public ExoGenTreeBase setMaxTrunkSize(int maxTrunkSize) {

        this.maxTrunkSize = maxTrunkSize;
        return this;
    }

    public int getMinCrownSize() {

        return minCrownSize;
    }

    public ExoGenTreeBase setMinCrownSize(int minCrownSize) {

        this.minCrownSize = minCrownSize;
        return this;
    }

    public int getMaxCrownSize() {

        return maxCrownSize;
    }

    public ExoGenTreeBase setMaxCrownSize(int maxCrownSize) {

        this.maxCrownSize = maxCrownSize;
        return this;
    }

    public ArrayList<IBlockState> getValidGroundBlocks() {

        return validGroundBlocks;
    }

    public ExoGenTreeBase setValidGroundBlocks(ArrayList<IBlockState> validGroundBlocks) {

        this.validGroundBlocks = validGroundBlocks;
        return this;
    }

}
