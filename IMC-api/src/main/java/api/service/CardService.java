package api.service;

import api.model.CardDTO;
import api.result.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by wangtc on 2017/6/26.
 */
public interface CardService {
    public Result<CardDTO> create(CardDTO cardDTO);
    public Result<List<Map<String,Object>>> select(CardDTO cardDTO);
    public Result<CardDTO> delete(int id);
    public Result<CardDTO> update(CardDTO cardDTO);
    public Result<CardDTO> enable(int id);
    public Result<CardDTO> disable(int id);
    public Result<CardDTO> find(int id);
}
