package manager;

import api.exception.ArgumentException;
import api.exception.ExceptionCode;
import domain.CardDO;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CardRepository;

import java.util.List;
import java.util.Map;


/**
 * Created by wangtc on 2017/6/26.
 */
public class CardManager {

    @Autowired
    private CardRepository cardRepository;

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void insert(CardDO cardDO){
        cardRepository.insert(cardDO);
    }

    public List<Map<String,Object>> select(CardDO cardDO){
        return cardRepository.select(cardDO);
    }

    public void delete(int id){
        if(id<=0){
            throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is null");
        }
        CardDO cardDO = cardRepository.find(id);
        if (cardDO == null)
        {
            throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is error");
        }
        cardDO.setStatus("delete");
        cardRepository.update(cardDO);
    }

    public void update(CardDO cardDO){
        cardRepository.update(cardDO);
    }

    public void enable(int id){
        if(id<=0){
            throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is null");
        }
        CardDO cardDO = cardRepository.find(id);
        if (cardDO == null)
        {
            throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is error");
        }
        cardDO.setStatus("enable");
        cardRepository.update(cardDO);
    }

    public void disable(int id){
        if(id<=0){
            throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is null");
        }
        CardDO cardDO = cardRepository.find(id);
        if (cardDO == null)
        {
            throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is error");
        }
        cardDO.setStatus("disable");
        cardRepository.update(cardDO);
    }

}
