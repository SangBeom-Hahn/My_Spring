package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {
    private final ItemRepository itemRepositoy = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepositoy.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("A", 100, 1);

        //when
        Item saveItem = itemRepositoy.save(item);

        //then
        assertThat(saveItem).isSameAs(item);
    }

    @Test
    void findByAll() {
        //given
        Item itemA = new Item("A", 100, 1);
        Item itemB = new Item("B", 101, 1);

        itemRepositoy.save(itemA);
        itemRepositoy.save(itemB);

        //when
        ArrayList<Item> items = itemRepositoy.findByAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(itemA, itemB);
    }

    @Test
    void updateItem() {
        //given
        Item itemA = new Item("A", 100, 1);
        itemRepositoy.save(itemA);

        Item paramItem = new Item("B", 100, 1);

        //when
        itemRepositoy.updateItem(itemA.getId(), paramItem);

        //then
        assertThat(itemA.getItemName()).isEqualTo(paramItem.getItemName());
        assertThat(itemA.getQuantity()).isEqualTo(paramItem.getQuantity());
        assertThat(itemA.getPrice()).isEqualTo(paramItem.getPrice());
    }
}