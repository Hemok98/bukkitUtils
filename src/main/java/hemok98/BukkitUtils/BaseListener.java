package hemok98.BukkitUtils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class BaseListener implements Listener {
    public void register(@NotNull JavaPlugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}
