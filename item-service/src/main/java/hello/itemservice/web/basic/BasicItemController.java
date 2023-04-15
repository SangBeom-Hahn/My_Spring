package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findByAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemID}")
    public String item(@PathVariable Long itemID, Model model) {
        Item item = itemRepository.findById(itemID);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addFrom() {
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("item") Item item, Model model) {
        itemRepository.save(item);
//        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/{userID}/edit")
    public String editForm(@PathVariable Long userID, Model model) {
        Item item = itemRepository.findById(userID);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{userID}/edit")
    public String edit(@PathVariable Long userID, @ModelAttribute Item item) {
        itemRepository.updateItem(userID, item);
        return "redirect:/basic/items/{userID}";
    }

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20400, 20));
    }
}
