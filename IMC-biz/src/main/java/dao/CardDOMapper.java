package dao;

import domain.CardDO;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * Created by wangtc on 2017/6/20.
 */
public interface CardDOMapper {
    public int insert(CardDO cardDO);
    public List<Map<String,Object>> select(CardDO cardDO);
    public CardDO find(int id);
    public int update(CardDO cardDO);
    public void delete(List<CardDO> list);
}
