package cn.lsr.cloud.provider.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.UUID;

/**
 * @Description: 账户类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class Account {
    private int id;
    private String name;
    private String password;
    private double balance;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date createtime;

    public Account() {
    }

    public Account(int id, String name, String password, double balance, Date createtime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createtime=" + createtime +
                '}';
    }
}
