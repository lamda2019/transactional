package com.wsc.service;

import com.wsc.mapper.AccountMapper;
import com.wsc.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @SuppressWarnings("all")
    @Autowired
    AccountMapper accountMapper;

    public Account getAccount() {
        return accountMapper.getAccount();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addMoney() throws Exception {
        //先增加余额
        accountMapper.addMoney();

        //然后遇到故障
        //遇到运行异常（RuntimeException）和程序错误（Error）可以回滚
        //throw new RuntimeException("发生异常了..");

        //遇到非检测异常,不回滚，除非加
       // throw new SQLException("发生异常了..");


        //谨慎：尽量不要在业务层捕捉异常并处理,回滚失效
       /* try {
            throw new SQLException("发生异常了..");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //推荐：在业务层将异常抛出。在业务层统一抛出异常，然后在控制层统一处理。
        throw new RuntimeException("发生异常了..");
    }
}