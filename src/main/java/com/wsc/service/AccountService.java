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

    @Transactional
    public void addMoney() throws Exception {
        //先增加余额
        accountMapper.addMoney();

        //然后遇到故障

        //遇到运行异常（RuntimeException）和程序错误（Error）可以回滚
        throw new RuntimeException("发生异常了..");


    }
}