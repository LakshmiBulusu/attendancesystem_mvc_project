package com.github.perscholas.service;

import com.github.perscholas.dao.AccountInformationDAO;
import com.github.perscholas.model.AccountInformation;


public class AccountService {

    public void createAccountInformation(AccountInformation accountInformation) {
        try{
            System.out.println("Im'm Account Service...   "+accountInformation.toString());
            AccountInformationDAO accountDao = new AccountInformationDAO();
            accountDao.createAccountInformation(accountInformation);

        }catch(Exception e){
            System.out.println("Im'm Account Service Exception block");
            e.printStackTrace();
            throw new Error(e);
        }finally{
        }
    }

    public boolean isValidLogin(AccountInformation accountInformation) {
        try{
            System.out.println("Im in Account Service"+accountInformation.toString());
            AccountInformationDAO accountDao = new AccountInformationDAO();
            return (accountDao.isValidLogin(accountInformation));
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
        }
    }



}
