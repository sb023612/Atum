package com.teammetallurgy.atum.proxy;

import com.teammetallurgy.atum.handler.event.ServerEvents;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    public void init() {
        ServerEvents ticker = new ServerEvents();
        MinecraftForge.EVENT_BUS.register(ticker);
    }

    public void initRenders() {
    }

    public void initTiles() {
    }

}
