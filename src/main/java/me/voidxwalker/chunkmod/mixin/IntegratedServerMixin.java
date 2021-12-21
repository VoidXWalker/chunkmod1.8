package me.voidxwalker.chunkmod.mixin;

import me.voidxwalker.chunkmod.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.net.Proxy;

@Mixin(IntegratedServer.class)
public abstract class IntegratedServerMixin extends MinecraftServer {
    @Shadow @Final private MinecraftClient client;

    public IntegratedServerMixin(Proxy proxy, File file) {
        super(proxy, file);
    }

    @Inject(method = "setupWorld()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/PlayerManager;setViewDistance(I)V", shift = At.Shift.AFTER))
    private void injected(CallbackInfo ci) {
        Main.safedViewDistance=  this.getPlayerManager().getViewDistance()==2||Main.safedViewDistance!=0? Main.safedViewDistance:this.getPlayerManager().getViewDistance();
        this.client.options.viewDistance=2;
        this.getPlayerManager().setViewDistance(2);
    }
}
