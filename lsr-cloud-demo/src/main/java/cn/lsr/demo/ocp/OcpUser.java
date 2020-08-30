package cn.lsr.demo.ocp;

import java.math.BigDecimal;

/**
 * @Description:
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class OcpUser {
    private String id;
    private String userName;
    private String pwd;
    private String phone;
    private BigDecimal balance;

    public OcpUser(String id, String userName, String pwd, String phone, BigDecimal balance) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.phone = phone;
        this.balance = balance;
    }

    public OcpUser(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
