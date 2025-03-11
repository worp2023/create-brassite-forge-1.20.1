package net.worp.createbrassiteforge.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.worp.createbrassiteforge.CreateBrassiteForge;
import net.worp.createbrassiteforge.fluid.ModFluids;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateBrassiteForge.MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> BRASSITE_INGOT = ITEMS.register("brassite_ingot",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> BRASSITE_SHEET = ITEMS.register("brassite_sheet",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CHUNK_OF_BRASSITE = ITEMS.register("chunk_of_brassite",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> HOT_BRASSITE_MIXTURE_BUCKET = ITEMS.register("hot_brassite_mixture_bucket",
            () -> new BucketItem(ModFluids.HOT_BRASSITE_MIXTURE_FLUID, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));


    public static final RegistryObject<Item> BRASSITE_HALF_INGOT = ITEMS.register("brassite_half_ingot",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> NETHERITE_SCRAP_FRAGMENT = ITEMS.register("netherite_scrap_fragment",
            () -> new Item(new Item.Properties().stacksTo(64)));
}
