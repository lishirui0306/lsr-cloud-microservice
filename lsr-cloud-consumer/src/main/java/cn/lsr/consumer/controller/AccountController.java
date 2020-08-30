package cn.lsr.consumer.controller;

import cn.lsr.cloud.common.entity.Result;
import cn.lsr.cloud.core.util.EurekaServerUtil;
import cn.lsr.cloud.core.util.RestTemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description: 用户控制器
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@RestController
@RequestMapping("/consumer")
public class AccountController {
    @Value("${lsr.remote.server.name}")
    private String serverName;
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    /**
     * 远程调用服务提供者，查询一个账户信息为id的账户
     * @param id 账户id
     * @return result
     */
    @RequestMapping(value = "/getById/id/{id}",method = RequestMethod.GET)
    public Result getById(@PathVariable int id){
        Result res = new Result();
        ResponseEntity<Result> responseEntity = RestTemplateUtils.get("http://"+serverName+"/account/getById/id/{id}", Result.class, id);
        log.info("远程调用的状态："+responseEntity.getStatusCode());
        log.info("获取到远程调用的结果是："+responseEntity.getBody().toString());
        res=responseEntity.getBody();
        return res;
    }

    /**
     * 获取注册中心服务列表
     * @return lsr-cloud-provider:http://10.18.89.41:8002
     */
    @RequestMapping(value = "/getServer",method = RequestMethod.GET)
    public List<String> getEurekaServices(){
        return EurekaServerUtil.getEurekaServices(true);
    }

}
