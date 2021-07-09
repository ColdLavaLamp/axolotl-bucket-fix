package easton.axolotlitemfix;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class AxolotlItemFixMain implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		//float numVars = FabricLoader.getInstance().isModLoaded("mavm") ? 11 : 5;

		FabricModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("variant"), (itemStack, clientWorld, livingEntity, i) -> {
			float axolotlType = 0;
			if (itemStack.getTag() != null && itemStack.getTag().contains("Variant"))
				axolotlType = itemStack.getTag().getInt("Variant");
			return axolotlType / 10.0f;
		});

		FabricModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("age"), (itemStack, clientWorld, livingEntity, i) -> {
			float age = 1;
			if (itemStack.getTag() != null && itemStack.getTag().contains("Age") && itemStack.getTag().getInt("Age") < 0)
				age = 0;
			return age;
		});
	}

}
