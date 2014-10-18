package com.ventura.tiempos.service;

import java.io.Serializable;
import java.util.List;

import com.ventura.tiempos.domain.User;

public interface UserManager extends Serializable {

    public List<User> getUsers();
    public boolean val(String k, String p);

}