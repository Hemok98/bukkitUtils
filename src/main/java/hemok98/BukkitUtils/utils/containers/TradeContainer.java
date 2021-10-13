package hemok98.BukkitUtils.utils.containers;

public class TradeContainer {
    private ItemstackContainer ingredient;
    private ItemstackContainer ingredient1;
    private ItemstackContainer result;

    public TradeContainer(){

    }

    public TradeContainer(ItemstackContainer ingredient, ItemstackContainer ingredient1, ItemstackContainer result) {
        this.ingredient = ingredient;
        this.ingredient1 = ingredient1;
        this.result = result;
    }

    public ItemstackContainer getIngredient() {
        return ingredient;
    }

    public ItemstackContainer getIngredient1() {
        return ingredient1;
    }

    public ItemstackContainer getResult() {
        return result;
    }
}
