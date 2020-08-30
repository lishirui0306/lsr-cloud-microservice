package cn.lsr.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 网管启动类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class);
    }
}
