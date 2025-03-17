
package dynamic.practice.repository.mybatis;

import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisItemRepository {

    private final ItemMapper itemMapper;

    public List<Item> selectItems03(Item item){
        log.info("start - selectItems03");
        return itemMapper.selectItems03(item);
    }

    public List<Item> selectItems02(Item item){
        log.info("start - selectItems02");
        return itemMapper.selectItems02(item);
    }

    public List<Item> selectItems(ItemSearchCond itemSearchCond){
        log.info("start - selectItems");        return itemMapper.selectItems(itemSearchCond);

    }

    public List<Item> selectItems01(ItemSearchCond itemSearchCond){
        log.info("start - selectItems01");
        return itemMapper.selectItems01(itemSearchCond);
    }

    public List<Item> useDollarInMybatis(String columnName, String value){
        return itemMapper.useDollarInMybatis(columnName, value);
    }

    public Item save(Item item){
        log.info("itemMapper class={}", itemMapper.getClass());
        itemMapper.save(item);
        return item;
    }

    //*****
    public List<Item> findByIdTwo(long id){
        log.info("start - findByIdTwo");
        return itemMapper.findByIdTwo(id);
    }
    public void deleteByIdThree(long id){
        log.info("start - deleteByIdThree");
        itemMapper.deleteByIdThree(id);
    }
    public void updateByIdFour(long id){
        log.info("start - updateByIdFour");
        itemMapper.updateByIdFour(id);
    }
    public Item insertByIdFive(Item item){
        log.info("stert - insertByIdFive");
        itemMapper.insertByIdFive(item);
        return item;
    }
    //*****

    public void update(Long itemId, ItemUpdateDto updateParam){
        itemMapper.update(itemId, updateParam);
    }

    public Optional<Item> findById(Long id){
        return itemMapper.findById(id);
    }

    public List<Item> findAll(ItemSearchCond cond){
        return itemMapper.findAll(cond);
    }

    public List<Item> findPrice44444WithTitleLike(ItemSearchCond cond) {
        return itemMapper.findPrice44444WithTitleLike(cond);
    }

    public List<Item> chooseWhenOtherwiseTest(String itemName, Item item){
        return itemMapper.chooseWhenOtherwiseTest(itemName, item);
    }

    public List<Item> testTrim(ItemSearchCond cond){
        return itemMapper.testTrim(cond);
    }

    public List<Item> foreachTest(List<Item> itemList){
        return itemMapper.foreachTest(itemList);
    }

}