package net.worp.createbrassiteforge.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.worp.createbrassiteforge.CreateBrassiteForge;
import net.worp.createbrassiteforge.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateBrassiteForge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        ModItems.ITEMS.getEntries().forEach(this::simpleItem);
        simpleItem(ModItems.BRASSITE_INGOT);
        simpleItem(ModItems.BRASSITE_HALF_INGOT);
        simpleItem(ModItems.NETHERITE_SCRAP_FRAGMENT);
        simpleItem(ModItems.BRASSITE_BOOTS);
        simpleItem(ModItems.BRASSITE_CHESTPLATE);
        simpleItem(ModItems.BRASSITE_LEGGINGS);
        simpleItem(ModItems.BRASSITE_HELMET);
        simpleItem(ModItems.BRASSITE_SHEET);
        simpleItem(ModItems.CHUNK_OF_BRASSITE);
        simpleItem(ModItems.HOT_BRASSITE_MIXTURE_BUCKET);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            ResourceLocation.fromNamespaceAndPath("minecraft","item/generated"))
                .texture("layer0",ResourceLocation.fromNamespaceAndPath("createbrassiteforge","item/"+item.getId().getPath()));
    }
}
