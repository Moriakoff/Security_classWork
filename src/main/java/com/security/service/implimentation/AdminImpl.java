package com.security.service.implimentation;

import com.security.entity.Account;
import com.security.entity.Role;
import com.security.repository.AccountJpaRepository;
import com.security.repository.RoleJpaRepository;
import com.security.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class AdminImpl implements Admin {

    @Autowired
    AccountJpaRepository accountRepository;

    @Autowired
    RoleJpaRepository roleRepository;

    @Override
    public Boolean addAccount(String login, String password) {
        if(accountRepository.existsById(login)) return false;

        Account account = new Account(login, password);
        accountRepository.save(account);

        return true;
    }

    @Override
    public Boolean addRole(String login, String role) {
        if(!accountRepository.existsById(login)) return false;

        Account account = accountRepository.findById(login).get();


        Role roleEntity = roleRepository.findById(role).orElse(new Role(role));

        roleRepository.save(roleEntity);

        account.getRoles().add(roleEntity);
        accountRepository.save(account);

        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public String getPassword(String login) {
        return accountRepository.findById(login).get().getPassword();
    }

    @Override
    public String[] getRoles(String login) {
        Account account = accountRepository.findById(login).orElse(null);
        return account == null ? new String[0] :
                (String[]) account.getRoles().stream()
                        .map(Role::getRole).toArray();
    }

    @Override
    public String[] getAccounts(String roleString) {
        return (String[]) accountRepository.findAccountsByRoles(new Role(roleString)).toArray();

    }
}
