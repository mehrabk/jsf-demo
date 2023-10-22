package com.demo.bean.repository;

import com.demo.bean.User;

/**
 * @author m_kor
 * date 10/22/2023
 */
public class UserRepository {

    final static User[] users = {
            new User(0, "user a"),
            new User(1, "user b"),
            new User(2, "user c")
    };

    public static User findUser(Integer id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }
}