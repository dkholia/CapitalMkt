package com.dcsoft.security.config;

public interface UserDao {

	Users findByUserName(String username);

}