package com.pastsemester.service;

import com.pastsemester.model.UserProfile;
import com.pastsemester.model.UserProfileType;
import com.pastsemester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pastsemester.model.User;

import java.util.HashSet;
import java.util.Set;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        setProfilesForUser(user);
        encryptPassword(user);
        userRepository.save(user);
    }

    private void encryptPassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    private void setProfilesForUser(User user){
        Set<UserProfile> userProfiles = new HashSet<>();
        userProfiles.add(userProfileService.findByType(UserProfileType.USER.getUserProfileType()));
        user.setUserProfiles(userProfiles);
    }
}
