package net.worp.createbrassiteforge;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.worp.createbrassiteforge.block.ModBlocks;
import net.worp.createbrassiteforge.fluid.ModFluidTypes;
import net.worp.createbrassiteforge.fluid.ModFluids;
import net.worp.createbrassiteforge.item.ModCreativeModTabs;
import net.worp.createbrassiteforge.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateBrassiteForge.MOD_ID)
public class CreateBrassiteForge
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "createbrassiteforge";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateBrassiteForge(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Pass eventbus to create tab creator
        ModCreativeModTabs.register(modEventBus);

        // Pass eventbus to the mod items
        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModFluids.register(modEventBus);

        ModFluidTypes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.HOT_BRASSITE_MIXTURE_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.HOT_BRASSITE_MIXTURE_FLOWING.get(), RenderType.solid());
        }
    }
}
