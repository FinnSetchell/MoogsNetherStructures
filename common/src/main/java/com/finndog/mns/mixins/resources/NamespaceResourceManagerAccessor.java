package com.finndog.mns.mixins.resources;

import net.minecraft.server.packs.resources.FallbackResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(FallbackResourceManager.class)
public interface NamespaceResourceManagerAccessor {
    @Accessor("fallbacks")
    List<FallbackResourceManager.PackEntry> mns_getFallbacks();
}
