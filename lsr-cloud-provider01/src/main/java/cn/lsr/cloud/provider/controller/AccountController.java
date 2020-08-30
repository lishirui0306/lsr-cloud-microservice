package cn.lsr.cloud.provider.controller;

import cn.lsr.cloud.common.entity.Result;
import cn.lsr.cloud.common.entity.PageParam;
import cn.lsr.cloud.common.exception.CommonException;
import cn.lsr.cloud.provider.api.AccountService;
import cn.lsr.cloud.provider.entity.Account;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 账户控制器
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@RestController
@RequestMapping("account")
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;
    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Account account){
        Result res = new Result();
        if (account==null){
            res.setCode(Result.ERROR_CODE);
            res.setMsg("保存结果为null");
        }
        try {
            int i = accountService.insertAccount(account);
            if (i==1){
                res.setCode(Result.SUCCESS_CODE);
            }else{
                res.setCode(Result.ERROR_CODE);
                res.setMsg("添加账户出错！");
            }
            return res;
        } catch (Exception e) {
            log.error("添加账户出错",e);
            throw new CommonException("新增账户出错！",e);
        }
    }
    @RequestMapping(value = "/getAll/pageNum/{pageNum}/pageSize/{pageSize}/orderBy/{orderBy}",method = RequestMethod.GET)
    public Result getAll(@PathVariable int pageNum,@PathVariable int pageSize,@PathVariable String orderBy){
        String[] order = orderBy.split(",");
        String ord = orderBy.replaceAll(","," ");
        Result res = new Result();
        PageParam page = new PageParam();
        PageInfo<Account> pageInfo = null;
        try {
            if (!StringUtils.isEmpty(orderBy)){
                page.setSortOrder(order[1]);
                page.setSortName(order[0]);
            }
            pageInfo = accountService.selectAll(pageNum, pageSize, ord);
            res.setCode(Result.SUCCESS_CODE);
            res.setData(pageInfo.getList());
            page.setPageNumber(pageInfo.getPageNum());
            page.setPageSize(pageInfo.getPageSize());
            page.setTotal(pageInfo.getTotal());
            if (pageInfo.getPageSize()==0){
                res.setMsg("查询结果为空。");
            }
            res.setPageParam(page);
            return res;
        } catch (Exception e) {
            log.error("查询出错！",e);
            throw new CommonException("查询出错！",e);
        }
    }
    @RequestMapping(value = "/getById/id/{id}",method = RequestMethod.GET)
    public Result getAccountByid(@PathVariable int id){
        Result res = new Result();
        try {
            Account account = accountService.getAccountById(id);
            if (null!=account){
                res.setCode(Result.SUCCESS_CODE);
                res.setData(account);
            }else {
                res.setCode(Result.SUCCESS_CODE);
                res.setMsg("查询结果为空，请检查数据是否存在！");
            }
            return res;
        } catch (Exception e) {
            throw new CommonException("查询出错！",e);
        }
    }
}
