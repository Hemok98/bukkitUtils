package hemok98.BukkitUtils.utils.containers;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class VillagerContainer {
    private String name;
    private List<TradeContainer> trades = new ArrayList<>();
    private Material material;

    public VillagerContainer(){

    }

    public VillagerContainer(String name, ArrayList<TradeContainer> trades, Material material) {
        this.name = name;
        this.trades = trades;
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public List<TradeContainer> getTrades() {
        return trades;
    }
}
