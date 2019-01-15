package com.lys.xuexi.handle;

import com.lys.xuexi.Utils.ResultUtil;
import com.lys.xuexi.controller.GirlController;
import com.lys.xuexi.domain.Result;
import com.lys.xuexi.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handel(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return  ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("[系统异常]：{}",e);
        return ResultUtil.error(-1,"未知错误");}

    }
}
