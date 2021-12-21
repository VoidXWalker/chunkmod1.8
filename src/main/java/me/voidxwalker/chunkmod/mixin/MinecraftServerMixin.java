package me.voidxwalker.chunkmod.mixin;


import me.voidxwalker.chunkmod.Main;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow public ServerWorld[] worlds;

    @Redirect(method = "prepareWorlds", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;isRunning()Z"))
    public boolean e(MinecraftServer instance){
        Main.ticks= 3200;
        int p = -192;
        int q = -192;
        ServerWorld serverWorld = this.worlds[0];
        BlockPos blockPos = serverWorld.getSpawnPos();
        serverWorld.chunkCache.method_6030(blockPos.getX() + p >> 4, blockPos.getZ() + q >> 4);


        return false;
    }

}
