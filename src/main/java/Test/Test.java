package Test;

import domain.CardDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.CardRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangtc on 2017/6/20.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        CardRepository cardRepository = (CardRepository) ac.getBean("cardRepository");
        //testInsert(cardRepository);
        testSelect(cardRepository);
        //testDelete(cardRepository,4);
        //testUpdate(cardRepository,1);

    }

    public static void testInsert(CardRepository cardRepository){
        CardDO cardDO = new CardDO();
        cardDO.setId(3);
        cardDO.setTitle("news");
        cardDO.setSubtitle("新闻30分");
        cardDO.setDescription("无");
        cardDO.setPicture("C://image.jpg");
        cardDO.setCardtype("life");

        cardDO.setPerson("张三");
        cardDO.setExt("无");
        cardDO.setStatus("disable");
        if(cardRepository.insert(cardDO)){
            System.out.println("插入成功");
        }

    }

    public static void testSelect(CardRepository cardRepository){
        CardDO cardDO = new CardDO();
        cardDO.setStatus("disable");
        cardDO.setSubtitle("新%");
        List<Map<String,Object>> cardDOs =  cardRepository.select(cardDO);       //Map中存储的是<字段名称，字段值>
        for(Map<String,Object> resultcardDO : cardDOs){
            System.out.println(resultcardDO);
        }
    }

    public static void testDelete(CardRepository cardRepository,int id){
        if(cardRepository.delete(id)){
            System.out.println("删除成功");
        }
    }

    public static void testUpdate(CardRepository cardRepository,int id){
        CardDO cardDO = new CardDO();
        cardDO.setId(id);
        cardDO.setStatus("disable");
        cardDO.setSubtitle("水杯");
        if(cardRepository.update(cardDO)){
            System.out.println("更新成功");

        }
    }
}
