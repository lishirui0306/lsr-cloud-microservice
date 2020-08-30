package cn.lsr.demo.ocp;

/**
 * @Description:
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class PhoneOcpHandler extends OcpHandler{
    @Override
    public boolean check(OcpUser ocpUser) {
        if(null==ocpUser||ocpUser.getPhone().length()!=11){
            return false;
        }
        return true;
    }
}
