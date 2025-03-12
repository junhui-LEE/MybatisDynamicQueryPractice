package dynamic.practice.repository.mybatis;


import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {
    void save(Item item);
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);
    Optional<Item> findById(Long id);
    List<Item> findAll(ItemSearchCond itemSearch);
    List<Item> findPrice44444WithTitleLike(ItemSearchCond cond);
    List<Item> chooseWhenOtherwiseTest(String itemName, @Param("gift") Item item);
    List<Item> testTrim(ItemSearchCond cond);

    List<Item> foreachTest(@Param("items") List<Item> itemList);

}
