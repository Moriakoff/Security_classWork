package com.security.repository;

import com.security.entity.Account;
import com.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountJpaRepository extends JpaRepository<Account,String> {

    List <Account> findAccountsByRoles(Role role);
}
