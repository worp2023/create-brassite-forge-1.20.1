package net.worp.createbrassiteforge.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.worp.createbrassiteforge.CreateBrassiteForge;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateBrassiteForge.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATE_BRASSITE_TAB = CREATIVE_MODE_TABS.register("create_brassite_forge",
            () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModItems.BRASSITE_INGOT.get()))
                .title(Component.translatable("Create Brassite Forge"))
                .displayItems((pParameters,pOutput) -> {
                    pOutput.accept(ModItems.BRASSITE_INGOT.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
