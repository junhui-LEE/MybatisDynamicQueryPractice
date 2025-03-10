package dynamic.practice.service;

import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import dynamic.practice.repository.mybatis.MybatisItemRepository;
import dynamic.practice.repository.mybatis.MybatisItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return mybatisItemRepository.findAll(cond);
    }

}