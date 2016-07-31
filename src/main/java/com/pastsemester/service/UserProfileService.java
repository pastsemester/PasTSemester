package com.pastsemester.service;

import com.pastsemester.model.UserProfile;
import com.pastsemester.model.UserProfileType;

/**
 * Created by Adisor on 7/30/2016.
 */
public interface UserProfileService {

    UserProfile findByType(String type);

    void save(UserProfile userProfile);
}
