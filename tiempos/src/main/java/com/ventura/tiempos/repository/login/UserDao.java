package com.ventura.tiempos.repository.login;

import java.util.List;

import com.ventura.tiempos.domain.login.User;

public interface UserDao {

    public List<User> getUserList();

    public void saveUser(User user);
    
    public boolean val(String k, String p);

}