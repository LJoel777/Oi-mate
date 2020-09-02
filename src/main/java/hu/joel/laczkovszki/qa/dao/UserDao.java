package hu.joel.laczkovszki.qa.dao;

import hu.joel.laczkovszki.qa.model.User;

public interface UserDao extends CRUDInterface<User>{
    User findByEmail(String email);
}
