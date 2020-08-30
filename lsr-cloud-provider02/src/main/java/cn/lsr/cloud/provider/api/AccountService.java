package cn.lsr.cloud.provider.api;

import cn.lsr.cloud.provider.entity.Account;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: 账户service
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public interface AccountService {
    PageInfo<Account> selectAll(int pageNum, int pageSize , String orderBy);
    public int insertAccount(Account account);
    public int updateAccount(Account account);
    public int deleteAccount(String id);
    public Account getAccountById(int id);
}
