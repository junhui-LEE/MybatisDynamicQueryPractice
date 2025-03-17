package dynamic.practice.service;

import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.Item;
import dynamic.practice.repository.ItemSearchCond;
import dynamic.practice.repository.ItemUpdateDto;
import dynamic.practice.repository.mybatis.MybatisItemRepository;
import dynamic.practice.repository.mybatis.MybatisItemRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.SQL;
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
            }else if(cond.getMaxPrice() == 5){
                // @Select 연습
                long id = 2;
                return mybatisItemRepository.findByIdTwo(id);
            }else if(cond.getMaxPrice() == 6){
                // @Delete 연습
                long id = 3;
                mybatisItemRepository.deleteByIdThree(id);
                cond.setItemName(null);
                cond.setMaxPrice(null);
                return  mybatisItemRepository.findAll(cond);
            }else if(cond.getMaxPrice() == 7){
                // @Update 연습
                long id = 7;
                mybatisItemRepository.updateByIdFour(id);
                cond.setItemName(null);
                cond.setMaxPrice(null);
                return mybatisItemRepository.findAll(cond);
            }else if(cond.getMaxPrice() == 8){
                // @insert 연습
                Item item = new Item();
                item.setItemName("rtByIdive");
                item.setPrice(7832);
                item.setQuantity(5003);
                mybatisItemRepository.insertByIdFive(item);

                cond.setItemName(null);
                cond.setMaxPrice(null);
                return mybatisItemRepository.findAll(cond);
            }else if(cond.getMaxPrice() == 9){
                // 문자열 대체(String Substitution)
                // #{} 문법은 ?를 넣고 파라미터를 바인딩하는 PreparedStatement를 사용한다.
                // 때로는 파라미터 바인딩이 아니라 문자 그대로를 처리하고 싶은 경우도 있다. 이때는 ${}를 사용하면 된다.
                // 다음 예제를 보자 - ORDER BY ${columnName}
                // @Select("select * from user where ${column} = #{value}")
                // User findByColumn(@Param("column") String column, @Param("value") String value);
                return mybatisItemRepository.useDollarInMybatis("price", "11111");
            }else if(cond.getMaxPrice() == 10){
                // 재사용 가능한 SQL 조각
                // <sql>을 사용하면 SQL 코드를 재사용 할 수 있다.
                cond.setItemName(null);
                cond.setMaxPrice(null);
                return mybatisItemRepository.selectItems(cond);
            }else if(cond.getMaxPrice() == 11){
                // 재사용 가능한 SQL 조각
                // <sql>태그에 파라미터 넘김
                cond.setItemName(null);
                cond.setMaxPrice(null);
                return mybatisItemRepository.selectItems01(cond);
            }else if(cond.getMaxPrice() == 12){
                // ResultMap
                // 결과를 매핑할 때 테이블은 id이지만 객체는 itemId이다.
                // 이 경우 컬럼명과 객체의 프로퍼티 명이 다르다. 그럼 xml파일에 있는 쿼리에 as별칭을 사용하면 된다.
                Item item = new Item();
                item.setItemId(4L);
                return mybatisItemRepository.selectItems02(item);
            }else if(cond.getMaxPrice() == 13){
                // ResultMap
                // 별칭을 사용하지 않고도 문제를 해결할 수 있는데, 다음과 같이 resultMap을 선언해서 사용하면 된다.
                Item item = new Item();
                item.setItemId(5L);
                return mybatisItemRepository.selectItems03(item);
            }

            return mybatisItemRepository.findAll(cond);
    }
}