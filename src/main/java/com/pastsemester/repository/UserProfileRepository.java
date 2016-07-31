package com.pastsemester.repository;

import com.pastsemester.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adisor on 7/30/2016.
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findByType(String type);
}
