package hello.itemservice.domain2.item;

import hello.itemservice.domain.item.ItemType;

import java.util.List;

public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private Boolean open;
    private List<String> regions;
    private ItemType itemType;
    private String deliveryCode;
}
