package com.security.service;

public interface Admin {

    Boolean addAccount(String login, String password);
    Boolean addRole(String login, String role);
    String getPassword(String login);
    String[] getRoles(String login);
    String[] getAccounts(String roleString);
}
