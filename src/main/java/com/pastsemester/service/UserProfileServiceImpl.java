package com.pastsemester.service;

import com.pastsemester.model.UserProfile;
import com.pastsemester.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adisor on 7/30/2016.
 */

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfile findByType(String type) {
        return userProfileRepository.findByType(type);
    }

    @Override
    public void save(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }
}
