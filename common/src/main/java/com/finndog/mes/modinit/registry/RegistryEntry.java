package com.finndog.mes.modinit.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public interface RegistryEntry<T> extends Supplier<T> {

    @Override
    T get();

    ResourceLocation getId();

}