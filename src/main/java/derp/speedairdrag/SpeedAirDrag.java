package derp.speedairdrag;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeedAirDrag implements ModInitializer {
	public static final String MOD_ID = "speed-air-drag";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded SpeedAirDrag");
		AirDragGamerule.SPEED_AIR_DRAG_PER_LEVEL.toString();
		AirDragGamerule.SLOWNESS_AIR_DRAG_PER_LEVEL.toString();
	}
}