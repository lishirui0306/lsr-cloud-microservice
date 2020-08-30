package cn.lsr.demo.ocp;


/**
 * @Description:
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class NameOcpHandler extends OcpHandler{
    @Override
    public boolean check(OcpUser ocpUser) {
        if (null==ocpUser.getUserName()){
            return false;
        }
        return true;
    }
}
