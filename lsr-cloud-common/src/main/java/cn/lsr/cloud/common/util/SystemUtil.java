package cn.lsr.cloud.common.util;

/**
 * @Description: 系统工具类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class SystemUtil {
    /**
     * 获取jvm运行根目录
     * @return jvm运行根目录
     */
    public static String getPath(){
        return System.getProperty("user.dir");
    }
}
