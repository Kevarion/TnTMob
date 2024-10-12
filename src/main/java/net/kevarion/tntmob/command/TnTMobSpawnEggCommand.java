package net.kevarion.tntmob.command;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

@CommandAlias("givetntmobspawnegg")
public class TnTMobSpawnEggCommand extends co.aikar.commands.BaseCommand {

    @Default
    public void main(Player player) {

        ItemStack egg = new ItemStack(Material.ZOMBIE_SPAWN_EGG, 1);
        ItemMeta meta = egg.getItemMeta();
        meta.setDisplayName(ChatColor.RED  + "TnT Mob Spawn Egg");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Spawns a Tnt Mob"));
        egg.setItemMeta(meta);

        player.getInventory().addItem(egg);
    }

}
