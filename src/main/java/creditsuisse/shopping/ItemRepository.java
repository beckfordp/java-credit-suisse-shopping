package creditsuisse.shopping;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {


    private static final Map<String, Item> itemMap = new HashMap<>();
    static
    {
        itemMap.put("Apple", new Item("Apple", 0.35));
        itemMap.put("Banana", new Item("Banana", 0.20));
        itemMap.put("Melon", new Item("Melon", 0.50));
        itemMap.put("Lime", new Item("Lime", 0.15));
    }

    public Item getBySku(String sku) { return itemMap.get(sku); }

}
