package cn.lsr.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 服务提供者启动类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@SpringBootApplication(scanBasePackages = {"cn.lsr"})
@EnableDiscoveryClient
public class ProviderApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication01.class);
    }
}
