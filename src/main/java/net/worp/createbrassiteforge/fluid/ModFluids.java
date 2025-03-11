package net.worp.createbrassiteforge.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.worp.createbrassiteforge.CreateBrassiteForge;
import net.worp.createbrassiteforge.block.ModBlocks;
import net.worp.createbrassiteforge.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CreateBrassiteForge.MOD_ID);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }

    public static final RegistryObject<FlowingFluid> HOT_BRASSITE_MIXTURE_FLUID =
            FLUIDS.register("hot_brassite_mixture",
                    () -> new ForgeFlowingFluid.Source(ModFluids.HOT_BRASSITE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> HOT_BRASSITE_MIXTURE_FLOWING =
            FLUIDS.register("hot_brassite_mixture_flowing",
                    () -> new ForgeFlowingFluid.Flowing(ModFluids.HOT_BRASSITE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties HOT_BRASSITE_PROPERTIES =
            new ForgeFlowingFluid.Properties(ModFluidTypes.HOT_BRASSITE_MIXTURE_FLUID_TYPE,
                    HOT_BRASSITE_MIXTURE_FLUID, HOT_BRASSITE_MIXTURE_FLOWING)
                    .slopeFindDistance(2)
                    .levelDecreasePerBlock(2)
                    .tickRate(20)
                    .bucket(ModItems.HOT_BRASSITE_MIXTURE_BUCKET)
                    .block(ModBlocks.HOT_BRASSITE_MIXTURE);
}
