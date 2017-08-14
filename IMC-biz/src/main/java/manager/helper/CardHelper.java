package manager.helper;

import api.exception.ExceptionCode;
import api.exception.ServiceException;
import api.model.CardDTO;
import domain.CardDO;
import org.apache.commons.beanutils.BeanUtils;
/**
 * Created by wangtc on 2017/6/27.
 */
public class CardHelper {
    public CardDO convertToDO(CardDTO cardDTO){
        try{
            if(cardDTO == null){
                return null;
            }
            CardDO cardDO = new CardDO();
            //System.out.println(cardDTO);
            BeanUtils.copyProperties(cardDO,cardDTO);
            //System.out.println(cardDO);
            return cardDO;
        }catch (Throwable th){
            throw new ServiceException(ExceptionCode.CONVERT_ERROR.getErrorCode(),"convert error",th);
        }
    }

    public CardDTO convertToDTO(CardDO cardDO){
        try{
            if (cardDO == null){
                return null;
            }
            CardDTO cardDTO = new CardDTO();
            BeanUtils.copyProperties(cardDTO,cardDO);
            return cardDTO;
        }catch (Throwable th){
            throw new ServiceException(ExceptionCode.SYS_ERROR.getErrorCode(),"convert error",th);
        }
    }
}
