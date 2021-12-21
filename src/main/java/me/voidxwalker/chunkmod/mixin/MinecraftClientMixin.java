package me.voidxwalker.chunkmod.mixin;

import me.voidxwalker.chunkmod.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class MinecraftClientMixin {
   



    @Inject(method = "tick", at = @At(value = "TAIL"))
    private void injected(CallbackInfo ci) {
        if(MinecraftClient.getInstance().getServer()!=null&&MinecraftClient.getInstance().getServer().getPlayerManager()!=null){
            if(Main.ticks--%20 ==0){
                if(MinecraftClient.getInstance().getServer().getPlayerManager().getViewDistance()<Main.safedViewDistance){
                    MinecraftClient.getInstance().getServer().getPlayerManager().setViewDistance(MinecraftClient.getInstance().getServer().getPlayerManager().getViewDistance()+1);
                    MinecraftClient.getInstance().options.viewDistance=MinecraftClient.getInstance().options.viewDistance+1;

                }
                else {
                    Main.safedViewDistance=0;
                }

            }
        }


    }
}
