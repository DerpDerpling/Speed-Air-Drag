package derp.speedairdrag;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import static net.minecraft.world.entity.ai.attributes.Attributes.AIR_DRAG_MODIFIER;

public final class AirDragEffectHandler {
    private static final Identifier SPEED_AIR_DRAG_ID = Identifier.fromNamespaceAndPath("speedairdrag", "speed_air_drag");
    private static final Identifier SLOWNESS_AIR_DRAG_ID = Identifier.fromNamespaceAndPath("speedairdrag", "slowness_air_drag");

    public static void updateAirDrag(LivingEntity entity) {
        if (!(entity.level() instanceof ServerLevel serverLevel)) return;

        AttributeInstance instance = entity.getAttribute(AIR_DRAG_MODIFIER);
        if (instance == null) return;

        double speedPerLevel = serverLevel.getGameRules().get(AirDragGamerule.SPEED_AIR_DRAG_PER_LEVEL);
        double slownessPerLevel = serverLevel.getGameRules().get(AirDragGamerule.SLOWNESS_AIR_DRAG_PER_LEVEL);

        instance.removeModifier(SPEED_AIR_DRAG_ID);
        instance.removeModifier(SLOWNESS_AIR_DRAG_ID);

        MobEffectInstance speed = entity.getEffect(MobEffects.SPEED);
        if (speed != null) {
            double amount = -speedPerLevel * (speed.getAmplifier() + 1);
            instance.addTransientModifier(new AttributeModifier(
                    SPEED_AIR_DRAG_ID,
                    amount,
                    AttributeModifier.Operation.ADD_VALUE
            ));
        }

        MobEffectInstance slowness = entity.getEffect(MobEffects.SLOWNESS);
        if (slowness != null) {
            double amount = slownessPerLevel * (slowness.getAmplifier() + 1);
            instance.addTransientModifier(new AttributeModifier(
                    SLOWNESS_AIR_DRAG_ID,
                    amount,
                    AttributeModifier.Operation.ADD_VALUE
            ));
        }
    }
}