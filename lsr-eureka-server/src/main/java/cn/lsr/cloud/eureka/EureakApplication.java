package cn.lsr.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: eureka启动类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@SpringBootApplication
@EnableEurekaServer
public class EureakApplication {
    public static void main(String[] args) {
        SpringApplication.run(EureakApplication.class);
    }
}
