package com.security.service.implimentation;

import com.security.service.User;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements User {
    @Override
    public String everybody() {
        return "everyBody call";
    }

    @Override
    public String guestAndMore() {
        return "guestAndMore call";
    }

    @Override
    public String managerAndMore() {
        return "manager call";
    }

    @Override
    public String admin() {
        return "admin call";
    }
}
