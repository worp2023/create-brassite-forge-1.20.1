package net.worp.createbrassiteforge.datagen;

import com.simibubi.create.AllTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.worp.createbrassiteforge.CreateBrassiteForge;
import net.worp.createbrassiteforge.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateBrassiteForge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Pickaxe
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.BRASSITE_CASING.get(),ModBlocks.BRASSITE_CASING.get());

        //Axe
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.BRASSITE_CASING.get());

        //Stone tool
        //this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BRASSITE_BLOCK.get()); //example

        //Iron tool
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BRASSITE_BLOCK.get());

        //Diamond tool
        //this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BRASSITE_BLOCK.get()); //example

        //Netherite tool
        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(ModBlocks.BRASSITE_BLOCK.get()); //example

        //Creat casing
        this.tag(AllTags.AllBlockTags.CASING.tag).add(ModBlocks.BRASSITE_CASING.get());
    }
}
