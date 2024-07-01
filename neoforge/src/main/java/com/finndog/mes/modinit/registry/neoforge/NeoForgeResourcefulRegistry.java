package com.finndog.mes.modinit.registry.neoforge;

import com.finndog.mes.modinit.registry.RegistryEntries;
import com.finndog.mes.modinit.registry.RegistryEntry;
import com.finndog.mes.modinit.registry.ResourcefulRegistry;
import com.finndog.mes.neoforge.MESNeoforge;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.function.Supplier;

public class NeoForgeResourcefulRegistry<T> implements ResourcefulRegistry<T> {

    private final DeferredRegister<T> register;
    private final RegistryEntries<T> entries = new RegistryEntries<>();

    public NeoForgeResourcefulRegistry(ResourceKey<? extends Registry<T>> registry, String id) {
        this.register = DeferredRegister.create(registry, id);
    }

    public NeoForgeResourcefulRegistry(Registry<T> registry, String id) {
        this.register = DeferredRegister.create(registry.key(), id);
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return this.entries.add(new NeoForgeRegistryEntry<>(register.register(id, supplier)));
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return this.entries.getEntries();
    }

    @Override
    public void init() {
        register.register(MESNeoforge.modEventBusTempHolder);
    }
}