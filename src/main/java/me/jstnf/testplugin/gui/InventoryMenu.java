package me.jstnf.testplugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryMenu implements InventoryHolder, Listener
{
    private Inventory inv;

    public InventoryMenu()
    {
        inv = Bukkit.createInventory(this, 54, "Test Inventory!");

        ItemStack item1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        item1.setAmount(4);
        String item1Name = ChatColor.translateAlternateColorCodes('&', "&c&lRED 4");
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(item1Name);
        item1.setItemMeta(meta1);

        ItemStack item2 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        String item2Name = ChatColor.translateAlternateColorCodes('&', "&c&lW&e&lI&a&lL&b&lD");
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(item2Name);
        item2.setItemMeta(meta2);

        inv.addItem(item1, item2);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        if (e.getInventory().getHolder() != this)
        {
            // This isn't our inventory
            // InventoryClickEvent listens for ALL inventory clicks
            return;
        }

        // This prevents people from taking items from the inventory.
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        ItemStack is = e.getCurrentItem();

        if (is == null || is.getType() == Material.AIR)
        {
            // The person clicked nothing
            Bukkit.broadcastMessage(p.getDisplayName() + " clicked nothing in the inventory.");
        }
        else
        {
            // They actually clicked something
            Bukkit.broadcastMessage(p.getDisplayName() + " clicked " + is.getItemMeta().getDisplayName() + ".");
        }

        // Close the inventory once we're done
        p.closeInventory();
    }

    @Override
    public Inventory getInventory()
    {
        return inv;
    }

    public void openInventory(Player p)
    {
        p.openInventory(inv);
    }
}