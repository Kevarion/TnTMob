package net.kevarion.tntmob.event;

import net.kevarion.tntmob.TnTMob;
import net.kevarion.tntmob.mob.TnTZombie;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class InteractEvent implements Listener {

    private final TnTMob instance;

    public InteractEvent(TnTMob instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getHand() != null && event.getHand() == EquipmentSlot.HAND) {
                if (event.getItem() != null && event.getItem().getItemMeta() != null
                && event.getItem().getItemMeta().getLore() != null &&
                        event.getItem().getItemMeta().getLore().contains(ChatColor.GRAY + "Spawns a Tnt Mob")) {
                    Location spawnLocation;
                    if (event.getClickedBlock().isPassable()) {
                        spawnLocation = event.getClickedBlock().getLocation().add(0.5, 0, 0.5);
                    } else {
                        spawnLocation = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation().add(0.5, 0, 0.5);
                    }
                    new TnTZombie(spawnLocation, instance);
                    if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
                        event.getItem().setAmount(event.getItem().getAmount() -1);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }

}
