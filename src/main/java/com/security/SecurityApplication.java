package com.security;

import com.security.entity.Account;
import com.security.entity.Role;
import com.security.repository.AccountJpaRepository;
import com.security.repository.RoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

    @Autowired
    AccountJpaRepository accountJpaRepository;

    @Autowired
    RoleJpaRepository roleJpaRepository;


    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        * Persist entities to DB
        * */

/*        Account account1 = new Account("first", "first");
        Account account2 = new Account("Second", "Second");
        Account account3 = new Account("Third", "Third");

        accountJpaRepository.save(account1);
        accountJpaRepository.save(account2);
        accountJpaRepository.save(account3);


        Role role1 = new Role("Admin");
        Role role2 = new Role("User");

        roleJpaRepository.save(role1);
        roleJpaRepository.save(role2);*/


        /*
        * Adding roles to account entities and search by role*/

        Account account1 = accountJpaRepository.findById("first").orElse(new Account());
        Account account2 = accountJpaRepository.findById("Second").orElse(new Account());
        Account account3 = accountJpaRepository.findById("Third").orElse(new Account());

        Role role1 = roleJpaRepository.findById("Admin").orElse(new Role());
        Role role2 = roleJpaRepository.findById("User").orElse(new Role());


        System.out.println(account1);


        account1.getRoles().add(role1);
        account1.getRoles().add(role2);

        account2.getRoles().add(role1);
        account3.getRoles().add(role2);



        accountJpaRepository.save(account1);
        accountJpaRepository.save(account2);
        accountJpaRepository.save(account3);

        System.out.println(accountJpaRepository.findAccountsByRoles(new Role("Admin")));


    }
}

