package com.example.demo.base;

import com.example.demo.dto.GeneralResponseDto;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@RestController
@ControllerAdvice
public class BaseController {
    public static Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * 所有异常统一格式返回
     * @param except
     * @return
     */
    @ExceptionHandler(Exception.class)
    public GeneralResponseDto runtimeExceptionHandler(Exception except) {
        except.printStackTrace();
        logger.info(except.getMessage());
        if(except instanceof UnauthorizedException){
            return GeneralResponseDto.addError(-1, "权限不足");
        }else if(except instanceof TimeoutException){

            return GeneralResponseDto.addError(0, except.getMessage());
        }else{
            return GeneralResponseDto.addError(-1, except.getMessage());
        }
    }
    /**
     * @return
     */
    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public void notLogin() { throw new TimeoutException("请先登录"); }


}
