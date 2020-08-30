package cn.lsr.cloud.common.exception;

/**
 * @Description: 统一异常处理类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class CommonException extends RuntimeException{
    private Throwable erorstack ;
    public CommonException(){
        super();
    }
    public CommonException(String msg,Throwable e){
        super(msg,e);
        this.erorstack=e;
    }

    public Throwable getErorstack() {
        return erorstack;
    }

    public void setErorstack(Throwable erorstack) {
        this.erorstack = erorstack;
    }
}
