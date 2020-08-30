package cn.lsr.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "hello";
    }

    public static void main(String[] args) {
        Map<Integer ,Object> map = new HashMap<Integer,Object>();
        for (int i = 0; i <10 ; i++) {
            map.put(i,null);
        }

    }
}
