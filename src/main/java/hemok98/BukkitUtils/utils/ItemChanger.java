package hemok98.BukkitUtils.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemChanger {
    public static ItemStack changeName(ItemStack item, String str){
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(str);
            item.setItemMeta(itemMeta);
        }

        return item;
    }

    public static ItemStack setLore(ItemStack item, List<String> lore){
        item.setLore(lore);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
