package net.worp.createbrassiteforge.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.fluids.FluidType;
import net.worp.createbrassiteforge.CreateBrassiteForge;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation HOT_BRASSITE_MIXTURE_STILL_RL = ResourceLocation.fromNamespaceAndPath("createbrassiteforge","block/hot_brassite_mixture_still");
    public static final ResourceLocation HOT_BRASSITE_MIXTURE_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("createbrassiteforge","block/hot_brassite_mixture_flow");
    public static final ResourceLocation HOT_BRASSITE_MIXTURE_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath("createbrassiteforge","block/hot_brassite_mixture_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(Keys.FLUID_TYPES, CreateBrassiteForge.MOD_ID);

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name,
                () -> new BaseFluidType(HOT_BRASSITE_MIXTURE_STILL_RL,HOT_BRASSITE_MIXTURE_FLOWING_RL,HOT_BRASSITE_MIXTURE_OVERLAY_RL,0xA1aa7240 ,new Vector3f(224f/ 255f,56f / 255f,208f/255f),properties));
    }

    public static final RegistryObject<FluidType> HOT_BRASSITE_MIXTURE_FLUID_TYPE = register("hot_brassite_mixture", FluidType.Properties.create()
                    .descriptionId("fluid.createbrassiteforge.hot_brassite_mixture")
                    .density(1000)
                    .viscosity(1000)
                    .temperature(2000)
                    .canDrown(true)
                    .canExtinguish(false)
                    .canSwim(true)
                    .sound(SoundAction.get("item.bucket.empty_lava"), SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundAction.get("item.bucket.fill_lava"), SoundEvents.BUCKET_EMPTY_LAVA)
            );
}
