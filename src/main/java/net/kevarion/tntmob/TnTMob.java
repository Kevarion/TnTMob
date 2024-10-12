package net.kevarion.tntmob;

import co.aikar.commands.PaperCommandManager;
import net.kevarion.tntmob.command.TnTMobSpawnEggCommand;
import net.kevarion.tntmob.event.InteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TnTMob extends JavaPlugin {

    private co.aikar.commands.PaperCommandManager commandManager;

    @Override
    public void onEnable() {

        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new TnTMobSpawnEggCommand());

        getServer().getPluginManager().registerEvents(new InteractEvent(this), this);

    }
}
