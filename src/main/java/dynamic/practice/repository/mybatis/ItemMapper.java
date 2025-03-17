package dynamic.practice.repository.mybatis;


import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    List<Item> selectItems03(Item item);
    List<Item> selectItems02(Item item);
    void save(Item item);
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);
    Optional<Item> findById(Long id);
    List<Item> findAll(ItemSearchCond itemSearch);
    List<Item> findPrice44444WithTitleLike(ItemSearchCond cond);
    List<Item> chooseWhenOtherwiseTest(String itemName, @Param("gift") Item item);
    List<Item> testTrim(ItemSearchCond cond);
    List<Item> foreachTest(@Param("items") List<Item> itemList);

//    애노테이션으로 SQL작성 - XML 대신에 애노테이션에 SQL을 작성할 수 있다.
    @Select("select id, item_name, price, quantity from item where id=#{id}")
    List<Item> findByIdTwo(long id);

    @Delete("delete from item where id=#{id}")
    void deleteByIdThree(long id);

    @Update("update item set item_name='update', price=11111, quantity=22222 where id=#{id}")
    void updateByIdFour(long id);

    @Insert("insert into item(item_name, price, quantity) values(#{itemName}, #{price}, #{quantity})")
    void insertByIdFive(Item item);

    @Select("select * from item where ${column} = #{value}")
    List<Item> useDollarInMybatis(@Param("column") String columnName, @Param("value") String value);

    List<Item> selectItems(ItemSearchCond itemSearchCond);

    List<Item> selectItems01(ItemSearchCond itemSearchCond);

}
