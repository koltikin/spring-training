package com.cydeo.service.impl;

import com.cydeo.dto.AccountDTO;
import com.cydeo.entity.Account;
import com.cydeo.repository.AccountRepository;
import com.cydeo.service.AccountService;
import com.cydeo.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<AccountDTO> getAccounts() {
        return accountRepository.findAll().stream().map(account -> mapperUtil.convert(account, new AccountDTO())).collect(Collectors.toList());
    }
    @Override
    public AccountDTO getById(Long id) throws Exception {
        return mapperUtil.convert(accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found")), new AccountDTO());
    }
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        accountRepository.save(mapperUtil.convert(accountDTO,new Account()));
        return accountDTO;
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);

    }
}
