package derp.speedairdrag.mixin;

import derp.speedairdrag.AirDragEffectHandler;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class AirDragMixin {
	@Inject(method = "tickEffects", at = @At("TAIL"))
	private void speedairdrag$updateAirDrag(CallbackInfo ci) {
		AirDragEffectHandler.updateAirDrag((LivingEntity)(Object)this);
	}
}