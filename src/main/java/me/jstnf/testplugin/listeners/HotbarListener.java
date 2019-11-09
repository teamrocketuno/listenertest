package me.jstnf.testplugin.listeners;

import me.jstnf.testplugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class HotbarListener implements Listener
{
    private TestPlugin plugin;

    public HotbarListener(TestPlugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemHeldEvent(PlayerItemHeldEvent e)
    {
        Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + " switched to slot " + (e.getNewSlot() + 1) + ".");

        switch (e.getNewSlot())
        {
            case 0:
                plugin.getMenu().openInventory(e.getPlayer());
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }

        if (e.getNewSlot() != 8)
        {
            e.getPlayer().getInventory().setHeldItemSlot(8);
        }
    }
}