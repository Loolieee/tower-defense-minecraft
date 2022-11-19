package net.mcreator.wiedzmin.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.wiedzmin.WiedzminMod;

import java.util.Map;

public class ZatrucieeliksiramiEffectStartedappliedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WiedzminMod.LOGGER.warn("Failed to load dependency entity for procedure ZatrucieeliksiramiEffectStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 150, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 400, (int) 1, (false), (false)));
	}
}
