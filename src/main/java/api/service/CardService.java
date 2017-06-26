package api.service;

import api.result.Result;
import domain.CardDO;

import java.util.List;
import java.util.Map;

/**
 * Created by wangtc on 2017/6/26.
 */
public interface CardService {
    public Result<CardDO> create(CardDO cardDO);
    public Result<List<Map<String,Object>>> select(CardDO cardDO);
    public Result<CardDO> delete(int id);
    public Result<CardDO> update(CardDO cardDO);
    public Result<CardDO> enable(int id);
    public Result<CardDO> disable(int id);
}
