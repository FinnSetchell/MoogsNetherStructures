package com.finndog.mns.mixins.structures;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructureTemplatePool.class)
public interface StructurePoolAccessor {

    @Accessor("rawTemplates")
    List<Pair<StructurePoolElement, Integer>> mns_getRawTemplates();

    @Mutable
    @Accessor("rawTemplates")
    void mns_setRawTemplates(List<Pair<StructurePoolElement, Integer>> elementCounts);

    @Accessor("templates")
    ObjectArrayList<StructurePoolElement> mns_getTemplates();

    @Mutable
    @Accessor("templates")
    void mns_setTemplates(ObjectArrayList<StructurePoolElement> elements);
}
