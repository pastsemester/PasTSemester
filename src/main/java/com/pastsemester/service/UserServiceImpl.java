package com.pastsemester.service;

import com.pastsemester.model.UserProfile;
import com.pastsemester.model.UserProfileType;
import com.pastsemester.repository.UserProfileRepository;
import com.pastsemester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pastsemester.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findBySso(String sso) {
        return userRepository.findBySsoId(sso);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
