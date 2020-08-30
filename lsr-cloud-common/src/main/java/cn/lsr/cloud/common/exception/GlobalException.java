package cn.lsr.cloud.common.exception;

import cn.lsr.cloud.common.entity.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Description: 全局异常处理
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result globaleExceptionHanlder(HttpServletRequest request, Exception e){
        Result res = new Result();
        res.setCode(Result.ERROR_CODE);
        if (e instanceof CommonException){
            CommonException commonException = (CommonException) e;
            res.setMsg("错误信息:"+commonException.getMessage()+commonException.getErorstack());
        }else if(e instanceof ConstraintViolationException){
            ConstraintViolationException violationException = (ConstraintViolationException)e;
            Set<ConstraintViolation<?>> constraintViolations = violationException.getConstraintViolations();
            Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
            List<String> msgList = new ArrayList<>();
            while (iterator.hasNext()) {
                ConstraintViolation<?> cvl = iterator.next();
                msgList.add(cvl.getMessageTemplate());
            }
            res.setMsg(msgList.get(0));
        }else if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException)e;
            BindingResult bindingResult = argumentNotValidException.getBindingResult();
            if(bindingResult.hasErrors()){
                List<ObjectError> errors = bindingResult.getAllErrors();
                res.setMsg(errors.get(0).getDefaultMessage());
//                List msg = new ArrayList();
//                errors.forEach(error->{
//                    FieldError fieldError = (FieldError) error;
//                    String s = fieldError.getObjectName()+":"+fieldError.getDefaultMessage();
//                    msg.add(s);
//                });
//                res.setMsg(msg.toString());
            }
        }else if (e instanceof BindException){
            BindException ex = (BindException)e;
            BindingResult bindingResult = ex.getBindingResult();
            if(bindingResult.hasErrors()){
                List<ObjectError> errors = bindingResult.getAllErrors();
                res.setMsg(errors.get(0).getDefaultMessage());
            }
        }else {
            res.setMsg("系统错误！"+e.getMessage());
        }
        return res;
    }

}
