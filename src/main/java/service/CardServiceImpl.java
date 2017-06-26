package service;

import api.exception.ArgumentException;
import api.exception.ExceptionCode;
import api.exception.RepositoryException;
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

    public Result<CardDO> create(CardDO cardDO){
        Result<CardDO> result = new Result<CardDO>();
        try{
            if(cardDO == null){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"CardDO is null");
            }
            cardManager.insert(cardDO);
            result.setValue(cardDO);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("create failure:params:"+cardDO);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("create failure:params:"+cardDO);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("create failure:params:"+cardDO);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }


    }

    public Result<List<Map<String, Object>>> select(CardDO cardDO) {
        Result<List<Map<String,Object>>> result = new Result<List<Map<String,Object>>>();
        try{
            if(cardDO == null){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"CardDO is null");
            }
            List<Map<String,Object>> data = cardManager.select(cardDO);
            result.setValue(data);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("select failure:params:"+cardDO);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch(RepositoryException re){
            String errorMsg = String.format("select failure:params:"+cardDO);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return result;
        }catch (Throwable th){
            String errorMsg = String.format("select failure:params:"+cardDO);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDO> delete(int id){
        Result<CardDO> result = new Result<CardDO>();
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

    public Result<CardDO> update(CardDO cardDO){
        Result<CardDO> result = new Result<CardDO>();
        try{
            if(cardDO == null){
                throw new ArgumentException(ExceptionCode.PARAM_ERROR.getErrorCode(),"CardDO is null");
            }
            cardManager.update(cardDO);
            result.setValue(cardDO);
            result.setSuccess(true);
            return result;
        }catch (ArgumentException ae){
            String errorMsg = String.format("update failure:params:"+cardDO);
            Log.error(errorMsg,ae);
            result.setErrorCode(ae.getErrorCode());
            result.setErrorMsg(ae.getMessage());
            return result;
        }catch (RepositoryException re){
            String errorMsg = String.format("update failure:params:"+cardDO);
            Log.error(errorMsg,re);
            result.setErrorCode(re.getErrorCode());
            result.setErrorMsg(re.getMessage());
            return  result;
        }catch (Throwable th){
            String errorMsg = String.format("update failure:params:"+cardDO);
            Log.error(errorMsg,th);
            result.setErrorCode(ExceptionCode.SYS_ERROR.getErrorCode());
            result.setErrorMsg(ExceptionCode.SYS_ERROR.getErrorMsg());
            return result;
        }
    }

    public Result<CardDO> enable(int id){
        Result<CardDO> result = new Result<CardDO>();
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

    public Result<CardDO> disable(int id){
        Result<CardDO> result = new Result<CardDO>();
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
}
