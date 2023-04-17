package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>();
    private static Long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long itemID) {
        return store.get(itemID);
    }

    public List<Item> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void updateItem(Long itemID, Item paramItem) {
        Item findItem = findById(itemID);
        findItem.setItemName(paramItem.getItemName());
        findItem.setPrice(paramItem.getPrice());
        findItem.setQuantity(paramItem.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}