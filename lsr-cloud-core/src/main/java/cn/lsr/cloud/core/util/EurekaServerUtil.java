package cn.lsr.cloud.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Eureka服务列表工具类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@Component
public class EurekaServerUtil {
    private static DiscoveryClient discoveryClient;
    @Autowired
    public EurekaServerUtil(DiscoveryClient discoveryClient){
        EurekaServerUtil.discoveryClient = discoveryClient;
    }
    /**
     * 获取所有的服务
     * @param b 是否输出服务名：url ，默认false 只输出url
     * @return 服务列表集合
     */
    public static List<String> getEurekaServices(boolean b){
        List<String> services = new ArrayList<>();
        List<String> serviceNames = discoveryClient.getServices();
        System.out.println("获取到的服务为:"+serviceNames.toString());
        for(String serviceName : serviceNames){
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for(ServiceInstance serviceInstance : serviceInstances){
                if (b){
                    services.add(String.format("%s:%s",serviceName,serviceInstance.getUri()));
                }else {
                    services.add(String.valueOf(serviceInstance.getUri()));
                }
            }
        }
        System.out.println("获取到的服务url为:"+services.toString());
        return services;
    }
}
