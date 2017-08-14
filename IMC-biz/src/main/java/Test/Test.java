package Test;

import api.model.CardDTO;
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

import java.util.*;

/**
 * Created by wangtc on 2017/6/20.
 */
public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        BeanFactory ac = new ClassPathXmlApplicationContext("spring.xml");
        //CardService cardService =(CardService) ac.getBean("cardService");
//        CardRepository cardRepository = (CardRepository) ac.getBean("cardRepository");
//        List<CardDO> list = new ArrayList<CardDO>();
//        String[] persons ={"赵六","赵六1","赵六2","赵六3"};
//        CardDO[] cardDOs = new CardDO[4];
//        for(int i=0;i<4;i++) {
//            cardDOs[i] = new CardDO();
//            cardDOs[i].setTitle("news");
//            cardDOs[i].setCardtype("life");
//            cardDOs[i].setPerson(persons[i]);
//            list.add(cardDOs[i]);
//        }
//        cardRepository.delete(list);
        //testInsert(cardService);
        //testSelect(cardService);
        //testDelete(cardService,4);
        //testUpdate(cardService,1);
        //testEnable(cardService,13);
        //testDisable(cardService,17);
        //System.out.println(cardService.find(13).getValue());
        while(true){

        }
    }

    public static void testInsert(CardService cardService){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(19);
        cardDTO.setTitle("news1");
        cardDTO.setSubtitle("底特律演讲");
        cardDTO.setDescription("无");
        cardDTO.setPicture("C://image.jpg");
        cardDTO.setCardtype("life");
        cardDTO.setPerson("赵六3");
        cardDTO.setExt("无");
        cardDTO.setStatus("enable");
        cardService.create(cardDTO);

    }

    public static void testSelect(CardService cardService){
        Result<List<Map<String,Object>>> result = new Result<List<Map<String, Object>>>();
        CardDTO cardDTO = new CardDTO();
        cardDTO.setStatus("disable");
        cardDTO.setSubtitle("新%");
        result =  cardService.select(cardDTO);       //Map中存储的是<字段名称，字段值>
        for(Map<String,Object> resultcardDTO : result.getValue()){
            System.out.println(resultcardDTO);
        }
    }

    public static void testDelete(CardService cardService,int id){
        Result<CardDTO> result = cardService.delete(id);
        if(result.isSuccess()){
            System.out.println("删除成功");
        }

    }

    public static void testUpdate(CardService cardService,int id){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(id);
        cardDTO.setStatus("enable");
        cardDTO.setSubtitle("mybatis");
        cardService.update(cardDTO);
    }

    public static void testEnable(CardService cardService,int id){
        Result<CardDTO> result = cardService.enable(id);
        if(result.isSuccess()){
            System.out.println("开启成功");
        }
    }

    public static void testDisable(CardService cardService,int id){
        Result<CardDTO> result = cardService.disable(id);
        if(result.isSuccess()){
            System.out.println("关闭成功");
        }
    }
}
