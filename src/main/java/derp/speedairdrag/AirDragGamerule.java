package derp.speedairdrag;


import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;

public final class AirDragGamerule {

    public static final GameRule<Double> SPEED_AIR_DRAG_PER_LEVEL = GameRuleBuilder
            .forDouble(0.25D)
            .category(GameRuleCategory.PLAYER)
            .buildAndRegister(Identifier.fromNamespaceAndPath("speedairdrag", "speed_air_drag_per_level"));

    public static final GameRule<Double> SLOWNESS_AIR_DRAG_PER_LEVEL = GameRuleBuilder
            .forDouble(0.5D)
            .category(GameRuleCategory.PLAYER)
            .buildAndRegister(Identifier.fromNamespaceAndPath("speedairdrag", "slowness_air_drag_per_level"));

    private AirDragGamerule() {}
}