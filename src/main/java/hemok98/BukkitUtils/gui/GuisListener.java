package hemok98.BukkitUtils.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class GuisListener implements Listener {

    @EventHandler
    public void on(InventoryClickEvent event){
        if (event.getClickedInventory() != null) {
            if ( event.getClickedInventory().getHolder() instanceof AbstractInventoryHolder) {
                event.setCancelled(true);
                ((AbstractInventoryHolder) event.getClickedInventory().getHolder()).click(event);
            }
            if (event.getInventory().getHolder() instanceof AbstractInventoryHolder && event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void on(InventoryDragEvent event){
        if ( event.getInventory().getHolder() instanceof AbstractInventoryHolder) event.setCancelled(true);
    }

    @EventHandler
    public void on(InventoryCloseEvent event){
    }
}
