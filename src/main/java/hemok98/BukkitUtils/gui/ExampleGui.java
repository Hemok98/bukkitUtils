package hemok98.BukkitUtils.gui;

import hemok98.BukkitUtils.BukkitUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ExampleGui extends AbstractInventoryHolder {
    private static final String NAME = "-=-=-=  Главное меню  =-=-=-";

    public ExampleGui(Player player, Player viewer) {
        super(NAME, 6, player, viewer);
        this.init();
    }


    @Override
    protected void init() {

        for (int i = 0; i < 9; i++) {
            this.inventory.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            this.inventory.setItem(i + 45, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        }

        for (int i = 1; i < 5; i++){
            this.inventory.setItem(i*9, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            this.inventory.setItem(i*9 + 8, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        }

    }

    @Override
    public void click(InventoryClickEvent event) {
        //if (event.isRightClick() && event.isShiftClick()) {
            switch (event.getRawSlot()) {
                case 10:
                     break;
                case 13:
                     break;
                case 16:
                     break;
                case 29:
                     break;
                case 33:
                     break;
            }
    }

    public static void display(@NotNull Player player, Player viewer){
        //System.out.println(viewer + " " + player);
        ExampleGui exampleGui = new ExampleGui(player, viewer);
        Bukkit.getServer().getScheduler().runTaskLater(BukkitUtils.getInstance(), ()->{ exampleGui.open(); }, 1);
    }

}
