package cn.lsr.cloud.provider.mapper;

import cn.lsr.cloud.provider.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: 账户类mapper
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
@Mapper
public interface AccountMapper {
    @Select("select * from lsr_account")
    List<Account> selectAll();
    @Insert("insert into lsr_account values (#{id},#{name},#{password},#{balance},#{createtime})")
    public int insertAccount(Account account);
    @Update("update lsr_account set name=#{name},password=#{password},balance={#balance} where id = #{id}")
    public int updateAccount(Account account);
    @Delete("delete from lsr_account where id =#{id}")
    public int deleteAccount(String id);
    @Select("select * from lsr_account where id=#{id} ")
    public Account getAccountById(int id);
}
