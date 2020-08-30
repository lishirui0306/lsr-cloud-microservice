package cn.lsr.demo.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class Ocp extends OcpHandler {
    private List<OcpHandler> ocpHandlerList = new ArrayList<>();
    public void addAlertHandler(OcpHandler ocpHandler){
        ocpHandlerList.add(ocpHandler);
    }
    @Override
    public boolean check(OcpUser ocpUser) {
        AtomicBoolean result = new AtomicBoolean(false);
        ocpHandlerList.forEach(ocpHandler -> {
            result.set(ocpHandler.check(ocpUser));
        });
        return result.get();
    }

}
