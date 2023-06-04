package com.codeline.sampleProject.Service;
import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Repository.AccountRepository;
import com.codeline.sampleProject.RequestObjects.GetAccountRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.Utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    public List<Account> getAccount(){
        return accountRepository.findAll();
    }
    @Autowired
    AccountRepository accountRepository;
    public void saveAccount(Account account){
        accountRepository.save(account);
    }



    public GetAccountResponse getAccountById(Long accountId) {
        Optional<Account> optionalAccount =  accountRepository.findById(accountId);
        if(!optionalAccount.isEmpty())
        {
            Account account =  optionalAccount.get();
            GetAccountResponse accountResponse = new GetAccountResponse(account.getAccountHolderName(),account.getBankName());
            return accountResponse;
        }


        return null;

    }

    public void createAccount(GetAccountRequestObject accountRequestObject) {
        Account account = new Account();
        account.setAccountType(Constants.ACCOUNT_TYPE_SAVING);
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setAccountHolderName(accountRequestObject.getName());
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        account.setBankName(accountRequestObject.getBankName());
        account.setBankBranch("Al Khoud");
        account.setSwiftCode("Y23123");
        accountRepository.save(account);
    }

    public void test(){

    }
    public Account getBankByName(String BNKName) {
        return accountRepository.getBankByName(BNKName);
    }
}
