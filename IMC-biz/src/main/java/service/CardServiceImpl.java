package service;

import api.exception.ArgumentException;
import api.exception.ExceptionCode;
import api.exception.RepositoryException;
import api.exception.ServiceException;
import api.model.CardDTO;
import api.result.Result;
import api.service.CardService;
import domain.CardDO;
import manager.CardManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by wangtc on 2017/6/26.
 */
public class CardServiceImpl implements CardService {

    private static final Logger Log =  LoggerFactory.getLogger(CardServiceImpl.class);
    @Autowired
    private CardManager cardManager;

    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }

    public Result<CardDTO> create(CardDTO cardDTO){
        Result<CardDTO> result = new Result<CardDTO>();
        try{
            if(cardDTO == null){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"CardDO is null");
            }
            cardManager.insert(cardDTO);
            result.setValue(cardDTO);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("create failure:params:"+cardDTO);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("create failure:params:"+cardDTO);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("create failure:params:"+cardDTO);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }


    }

    public Result<List<Map<String, Object>>> select(CardDTO cardDTO) {
        Result<List<Map<String,Object>>> result = new Result<List<Map<String,Object>>>();
        try{
            if(cardDTO == null){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"CardDO is null");
            }
            List<Map<String,Object>> data = cardManager.select(cardDTO);
            result.setValue(data);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("select failure:params:"+cardDTO);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch(RepositoryException re){
            String errorMsg = String.format("select failure:params:"+cardDTO);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("select failure:params:"+cardDTO);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDTO> delete(int id){
        Result<CardDTO> result = new Result<CardDTO>();
        try{
            cardManager.delete(id);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("delete failure:params:"+id);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("delete failure:params:"+id);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("delete failure:params:"+id);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDTO> update(CardDTO cardDTO){
        Result<CardDTO> result = new Result<CardDTO>();
        try{
            if(cardDTO == null){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"CardDO is null");
            }
            cardManager.update(cardDTO);
            result.setValue(cardDTO);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("update failure:params:"+cardDTO);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("update failure:params:"+cardDTO);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return  result;
        }catch (Throwable th){
            String errorMsg = String.format("update failure:params:"+cardDTO);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDTO> enable(int id){
        Result<CardDTO> result = new Result<CardDTO>();
        try{
            cardManager.enable(id);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("enable failure:params:"+id);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("enable failure:params:"+id);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("enable failure:params:"+id);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDTO> disable(int id){
        Result<CardDTO> result = new Result<CardDTO>();
        try{
            cardManager.disable(id);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("disable failure:params:"+id);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("disable failure:params:"+id);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("disable failure:params:"+id);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDTO> find(int id){
        Result<CardDTO> result = new Result<CardDTO>();
        try{
            if(id<=0){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"id is null");
            }
            CardDTO cardDTO = cardManager.find(id);
            result.setValue(cardDTO);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("find failure:param:"+id);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch(RepositoryException re){
            String errorMsg = String.format("repository exception param:"+id);
            Log.error(errorMsg);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch(ServiceException se){
            String errorMsg = String.format("service exception param:" + id);
            Log.error(errorMsg);
            result.setErrorCode(se.getErrorCode());
            result.setErrorMsg(se.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("system Exception param:"+id);
            Log.error(errorMsg);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }

    }
}
