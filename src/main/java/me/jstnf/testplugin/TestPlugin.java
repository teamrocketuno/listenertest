package me.jstnf.testplugin;

import me.jstnf.testplugin.gui.InventoryMenu;
import me.jstnf.testplugin.listeners.HotbarListener;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin
{
    private HotbarListener hotbarListener;
    private InventoryMenu menu;

    public TestPlugin()
    {
        hotbarListener = new HotbarListener(this);
    }

    @Override
    public void onEnable()
    {
        menu = new InventoryMenu();
        getServer().getPluginManager().registerEvents(hotbarListener, this);
    }

    @Override
    public void onDisable()
    {

    }

    public InventoryMenu getMenu()
    {
        return menu;
    }
}