
package dynamic.practice.repository.mybatis;

import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisItemRepository {

    private final ItemMapper itemMapper;

    public Item save(Item item){
        log.info("itemMapper class={}", itemMapper.getClass());
        itemMapper.save(item);
        return item;
    }

    public void update(Long itemId, ItemUpdateDto updateParam){
        itemMapper.update(itemId, updateParam);
    }

    public Optional<Item> findById(Long id){
        return itemMapper.findById(id);
    }

    public List<Item> findAll(ItemSearchCond cond){
        return itemMapper.findAll(cond);
    }

}
