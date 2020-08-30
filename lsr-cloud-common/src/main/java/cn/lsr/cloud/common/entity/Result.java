package cn.lsr.cloud.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: 全局DTO
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class Result<T> implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 100;
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "操作成功。";
    private static final String ERROR = "操作失败！！！";
    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,Object> ext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PageParam pageParam;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code) {
        this.code = code;
        if (code==SUCCESS_CODE){
            this.msg = SUCCESS;
        }else{
            this.msg = ERROR;
        }
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, T data, Map<String, Object> ext) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ext = ext;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
        if (code==Result.SUCCESS_CODE){
            this.msg = SUCCESS;
        }else {
            this.msg = ERROR;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public PageParam getPageParam() {
        return pageParam;
    }

    public void setPageParam(PageParam pageParam) {
        this.pageParam = pageParam;
    }
}
