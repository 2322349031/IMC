package repository;

import dao.CardDOMapper;
import domain.CardDO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

/**
 * Created by wangtc on 2017/6/20.
 */
public class CardRepository {

    @Autowired
    private CardDOMapper cardDOMapper;

    public boolean insert(CardDO cardDO){
        //System.out.println(cardDOMapper);
     int result = cardDOMapper.insert(cardDO);
        if(result<=0){
            try {
                throw new Exception("插入失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public List<Map<String,Object>> select(CardDO cardDO){
        List<Map<String,Object>> resultCardDOs = cardDOMapper.select(cardDO);
        if(resultCardDOs==null){
            try {
                throw new Exception("该帖子不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultCardDOs;
    }

    public boolean delete(int id){
        int result = cardDOMapper.delete(id);
        System.out.println(result);
        if(result<=0){
            try {
                throw new Exception("删除失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean update(CardDO cardDO){
        int result = cardDOMapper.update(cardDO);
        System.out.println(result);
        if(result<=0){
            try {
                throw new Exception("更新失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void setCardDOMapper(CardDOMapper cardDOMapper) {
        this.cardDOMapper = cardDOMapper;
    }
}
