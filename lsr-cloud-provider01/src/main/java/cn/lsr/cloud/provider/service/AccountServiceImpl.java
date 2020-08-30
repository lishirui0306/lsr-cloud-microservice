package cn.lsr.cloud.provider.service;

import cn.lsr.cloud.common.util.DateUtil;
import cn.lsr.cloud.provider.mapper.AccountMapper;
import cn.lsr.cloud.provider.api.AccountService;
import cn.lsr.cloud.provider.entity.Account;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: 账户实现
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountMapper accountMapper;
    @Override
    public PageInfo<Account> selectAll(int pageNum,int pageSize ,String orderBy) {
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<Account> accounts = accountMapper.selectAll();
        return new PageInfo<>(accounts);
    }

    @Override
    public int insertAccount(Account account) {
        return accountMapper.insertAccount(account);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccount(String id) {
        return accountMapper.deleteAccount(id);
    }
    @Override
    public Account getAccountById(int id) {
        return accountMapper.getAccountById(id);
    }

}
