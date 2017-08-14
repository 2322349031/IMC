package manager;

import api.exception.ArgumentException;
import api.exception.ExceptionCode;
import api.model.CardDTO;
import api.result.Result;
import domain.CardDO;
import manager.helper.CardHelper;
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

    @Autowired
    private CardHelper cardHelper;

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public void setCardHelper(CardHelper cardHelper) {
        this.cardHelper = cardHelper;
    }

    public void insert(CardDTO cardDTO){
        cardRepository.insert(cardHelper.convertToDO(cardDTO));
    }

    public List<Map<String,Object>> select(CardDTO cardDTO){
        return cardRepository.select(cardHelper.convertToDO(cardDTO));
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

    public void update(CardDTO cardDTO){
        cardRepository.update(cardHelper.convertToDO(cardDTO));
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

    public CardDTO find(int id){
        CardDO cardDO = cardRepository.find(id);
        CardDTO cardDTO = cardHelper.convertToDTO(cardDO);
        return cardDTO;
    }

}
