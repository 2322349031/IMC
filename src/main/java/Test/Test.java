package Test;

import api.result.Result;
import api.service.CardService;
import domain.CardDO;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
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
    private static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        BeanFactory ac = new ClassPathXmlApplicationContext("spring.xml");
        CardService cardService =(CardService) ac.getBean("cardService");
        //testInsert(cardService);
        //testSelect(cardService);
        //testDelete(cardService,3);
        //testUpdate(cardService,1);
        testEnable(cardService,1);
        //testDisable(cardService,3);
    }

    public static void testInsert(CardService cardService){
        CardDO cardDO = new CardDO();
        cardDO.setId(4);
        cardDO.setTitle("news");
        cardDO.setSubtitle("底特律演讲");
        cardDO.setDescription("无");
        cardDO.setPicture("C://image.jpg");
        cardDO.setCardtype("life");
        cardDO.setPerson("张三");
        cardDO.setExt("无");
        cardDO.setStatus("enable");
        cardService.create(cardDO);

    }

    public static void testSelect(CardService cardService){
        Result<List<Map<String,Object>>> result = new Result<List<Map<String, Object>>>();
        CardDO cardDO = new CardDO();
        cardDO.setStatus("disable");
        cardDO.setSubtitle("新%");
        result =  cardService.select(cardDO);       //Map中存储的是<字段名称，字段值>
        for(Map<String,Object> resultcardDO : result.getValue()){
            System.out.println(resultcardDO);
        }
    }

    public static void testDelete(CardService cardService,int id){
        Result<CardDO> result = cardService.delete(id);
        if(result.isSuccess()){
            System.out.println("删除成功");
        }

    }

    public static void testUpdate(CardService cardService,int id){
        CardDO cardDO = new CardDO();
        cardDO.setId(id);
        cardDO.setStatus("enable");
        cardDO.setSubtitle("mybatis");
        cardService.update(cardDO);
    }

    public static void testEnable(CardService cardService,int id){
        Result<CardDO> result = cardService.enable(id);
        if(result.isSuccess()){
            System.out.println("开启成功");
        }
    }

    public static void testDisable(CardService cardService,int id){
        Result<CardDO> result = cardService.disable(id);
        if(result.isSuccess()){
            System.out.println("关闭成功");
        }
    }
}
