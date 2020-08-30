package cn.lsr.cloud.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: restTemplate配置
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@Configuration
public class RestTmplateConfig {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }
}
