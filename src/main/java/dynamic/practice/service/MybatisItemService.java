package dynamic.practice.service;

import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import dynamic.practice.repository.mybatis.MybatisItemRepository;
import dynamic.practice.repository.mybatis.MybatisItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MybatisItemService {

    private final MybatisItemRepository mybatisItemRepository;

    public Item save(Item item) {
        return mybatisItemRepository.save(item);
    }

    public void update(Long itemId, ItemUpdateDto updateParam) {
        mybatisItemRepository.update(itemId, updateParam);
    }

    public Optional<Item> findById(Long id) {
        return mybatisItemRepository.findById(id);
    }

    public List<Item> findItems(ItemSearchCond cond) {

            if(cond.getMaxPrice() == null || cond.getItemName() == null){
                return mybatisItemRepository.findAll(cond);
            }

            if(cond.getMaxPrice() == 1){
                // if - Mybatis 동적쿼리 연습
                if(cond.getItemName().equals("")) cond.setItemName(null);
                return mybatisItemRepository.findPrice44444WithTitleLike(cond);
            }else if(cond.getMaxPrice() == 2){
                // choose, when, otherwise - Mybatis 동적쿼리 연습
//                Item item = new Item();
//                item.setPrice(44444);
//                String itemName = null;
                Item item = null;
                String itemName = null;
                return mybatisItemRepository.chooseWhenOtherwiseTest(itemName, item);
            }else if(cond.getMaxPrice() == 3){
                // trim - Mybatis 동적쿼리 연습
                cond.setMaxPrice(null);
                return mybatisItemRepository.testTrim(cond);
            }else if(cond.getMaxPrice() == 4){
                // foreach - Mybatis 동적쿼리 연습
                List<Item> itemList = new LinkedList<>();
                itemList.add(new Item("itemOne", 1000, 1));
                itemList.add(new Item("itemTwo", 44444, 2));
                itemList.add(new Item("itemThree", 23454, 3));
                itemList.add(new Item("itemFour", 1234, 4));
                return mybatisItemRepository.foreachTest(itemList);
            }
            return mybatisItemRepository.findAll(cond);
    }
}