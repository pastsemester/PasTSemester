package com.pastsemester.service;

import com.pastsemester.model.User;

public interface UserService {

    User findById(long id);

    User findBySso(String sso);

    void save(User user);


}