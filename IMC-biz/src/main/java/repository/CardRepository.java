package repository;

import api.exception.ExceptionCode;
import api.exception.RepositoryException;
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

    public void delete(List<CardDO> list) {
        cardDOMapper.delete(list);
    }

    public void insert(CardDO cardDO){
      try{
          int ret = cardDOMapper.insert(cardDO);
          if(ret<=0){
             throw new RepositoryException(ExceptionCode.DB_ERROR.getErrorCode(),ExceptionCode.DB_ERROR.getErrorMsg());
          }
      }catch (Throwable th){
          throw new RepositoryException(ExceptionCode.DB_ERROR.getErrorCode(),ExceptionCode.DB_ERROR.getErrorMsg(),th);
      }
    }

    public List<Map<String,Object>> select(CardDO cardDO){
        try{
            List<Map<String,Object>> resultCardDOs = cardDOMapper.select(cardDO);
            return resultCardDOs;
        }catch (Throwable th){
            throw new RepositoryException(ExceptionCode.DB_ERROR.getErrorCode(),ExceptionCode.DB_ERROR.getErrorMsg(),th);
        }

    }

    public CardDO find(int id){

        try{
            CardDO cardDO = cardDOMapper.find(id);
            return cardDO;
        }catch (Throwable th){
            throw new RepositoryException(ExceptionCode.DB_ERROR.getErrorCode(),ExceptionCode.DB_ERROR.getErrorMsg(),th);
        }

    }

    public void update(CardDO cardDO){

        try{
            int result = cardDOMapper.update(cardDO);
            if(result<=0){
                throw new RepositoryException(ExceptionCode.DB_ERROR.getErrorCode(),ExceptionCode.DB_ERROR.getErrorMsg());
            }
        }catch (Throwable th){
            throw new RepositoryException(ExceptionCode.DB_ERROR.getErrorCode(),ExceptionCode.DB_ERROR.getErrorMsg(),th);
        }
    }

    public void setCardDOMapper(CardDOMapper cardDOMapper) {
        this.cardDOMapper = cardDOMapper;
    }
}
