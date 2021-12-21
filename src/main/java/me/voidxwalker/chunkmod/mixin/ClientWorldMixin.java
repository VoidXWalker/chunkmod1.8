package me.voidxwalker.chunkmod.mixin;

import me.voidxwalker.chunkmod.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {
    @Inject(method="disconnect",at=@At(value="TAIL"))
    public void correctViewDistance(CallbackInfo ci){
        if(Main.safedViewDistance!=0){
            MinecraftClient.getInstance().options.viewDistance=Main.safedViewDistance;
        }
    }
}
