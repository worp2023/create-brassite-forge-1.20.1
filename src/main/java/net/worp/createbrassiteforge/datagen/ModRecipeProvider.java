package net.worp.createbrassiteforge.datagen;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.data.recipe.MixingRecipeGen;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.worp.createbrassiteforge.CreateBrassiteForge;
import net.worp.createbrassiteforge.block.ModBlocks;
import net.worp.createbrassiteforge.fluid.ModFluids;
import net.worp.createbrassiteforge.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //3x3
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A',Blocks.COBBLESTONE)
                .define('B',Blocks.NETHER_WART)
                .unlockedBy(getHasName(Blocks.NETHER_WART), has(Blocks.NETHER_WART))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_SCRAP)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NETHERITE_SCRAP_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.NETHERITE_SCRAP_FRAGMENT.get()), has(ModItems.NETHERITE_SCRAP_FRAGMENT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRASSITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.BRASSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASSITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.BRASSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASSITE_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.BRASSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASSITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.BRASSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASSITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.BRASSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter);

        //2x2
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRASSITE_INGOT.get())
                .pattern("AA")
                .define('A', ModItems.BRASSITE_HALF_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter,"createbrassiteforge:brassite_ingot_from_half_ingots");

        //Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRASSITE_INGOT.get(), 9)
                .requires(ModBlocks.BRASSITE_BLOCK.get())
                .unlockedBy(getHasName(ModItems.BRASSITE_INGOT.get()), has(ModItems.BRASSITE_INGOT.get()))
                .save(pWriter,"createbrassiteforge:brassite_ingot_from_block");

    }
}
