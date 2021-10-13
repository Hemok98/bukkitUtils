package hemok98.BukkitUtils.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemBuilder {
    private Material material;
    private int amount = 1;
    private List<String> lore = null;
    private String name = null;

    public ItemBuilder(@NotNull Material material){
        this.material = material;
    }

    public @NotNull ItemBuilder setAmount(int amount) {
        if (amount < 0 && amount > 64) return this;
        this.amount = amount;
        return this;
    }

    public @NotNull ItemBuilder setLore(@NotNull List<String> lore) {
        this.lore = lore;
        return this;
    }

    public @NotNull ItemBuilder setName(@NotNull String name) {
        this.name = name;
        return this;
    }

    public @NotNull ItemStack build(){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(lore != null) itemMeta.setLore(lore);
        if(name != null) itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
