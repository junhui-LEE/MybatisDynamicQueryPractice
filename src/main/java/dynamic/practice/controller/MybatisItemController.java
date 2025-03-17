package dynamic.practice.controller;


import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import dynamic.practice.service.MybatisItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MybatisItemController {

    private final MybatisItemService mybatisItemService;

    @GetMapping("/")
    public String home(){
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String items(@ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model){
        List<Item> items = mybatisItemService.findItems(itemSearch);
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/items/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = mybatisItemService.findById(itemId).get();
        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping("/items/add")
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/items/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = mybatisItemService.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getItemId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/items/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = mybatisItemService.findById(itemId).get();
        model.addAttribute("item", item);
        return "editForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute ItemUpdateDto updateParam) {
        mybatisItemService.update(itemId, updateParam);
        return "redirect:/items/{itemId}";
    }

}