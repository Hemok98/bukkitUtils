package hemok98.BukkitUtils.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractInventoryHolder implements InventoryHolder {
    protected Inventory inventory;
    protected Player owner;
    protected Player viewer;

    public AbstractInventoryHolder(@NotNull String title, @NotNull int lines,@NotNull Player owner,@Nullable Player viewer) {
        this.inventory = Bukkit.createInventory(this, lines * 9, title);
        this.owner = owner;
        if (viewer != null) {
            this.viewer = viewer;
        } else this.viewer = owner;
    }

    protected abstract void init();

    public abstract void click(@NotNull InventoryClickEvent event);

    @Override
    public final @NotNull Inventory getInventory() {
        return this.inventory;
    }

    public final void open(){
        viewer.openInventory(this.inventory);
    }
}
