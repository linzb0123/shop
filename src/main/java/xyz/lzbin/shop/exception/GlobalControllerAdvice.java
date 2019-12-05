package xyz.lzbin.shop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.exceptions.TemplateInputException;
import xyz.lzbin.shop.result.ResultInfo;

/**
 * @author lzb
 * 2019/12/5
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);


    @ResponseBody
    @ExceptionHandler(value = ResultBodyException.class)
    public ResultInfo exceptionHandler(ResultBodyException ex){
        ResultInfo res =  ResultInfo.fail(ex.getMsg());
        return res;
    }

}
