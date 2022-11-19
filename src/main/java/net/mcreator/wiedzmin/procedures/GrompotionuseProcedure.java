package net.mcreator.wiedzmin.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.wiedzmin.potion.ZatrucieeliksiramiPotionEffect;
import net.mcreator.wiedzmin.WiedzminMod;

import java.util.Map;
import java.util.Collection;

public class GrompotionuseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WiedzminMod.LOGGER.warn("Failed to load dependency world for procedure Grompotionuse!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WiedzminMod.LOGGER.warn("Failed to load dependency x for procedure Grompotionuse!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WiedzminMod.LOGGER.warn("Failed to load dependency y for procedure Grompotionuse!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WiedzminMod.LOGGER.warn("Failed to load dependency z for procedure Grompotionuse!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WiedzminMod.LOGGER.warn("Failed to load dependency entity for procedure Grompotionuse!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WiedzminMod.LOGGER.warn("Failed to load dependency itemstack for procedure Grompotionuse!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos(x, y, z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("wiedzmin:potiondrink")),
					SoundCategory.PLAYERS, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("wiedzmin:potiondrink")),
					SoundCategory.PLAYERS, (float) 1, (float) 1, false);
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 180);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 180, (int) 1, (false), (false)));
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.REGENERATION)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.RESISTANCE)
								return true;
						}
					}
					return false;
				}
			}.check(entity)) {
				if (new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == Effects.SPEED)
									return true;
							}
						}
						return false;
					}
				}.check(entity)) {
					if (new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.NIGHT_VISION)
										return true;
								}
							}
							return false;
						}
					}.check(entity)) {
						if (new Object() {
							boolean check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == Effects.STRENGTH)
											return true;
									}
								}
								return false;
							}
						}.check(entity)) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(
										new EffectInstance(ZatrucieeliksiramiPotionEffect.potion, (int) 400, (int) 1, (false), (true)));
						}
					}
				}
			}
		}
	}
}
