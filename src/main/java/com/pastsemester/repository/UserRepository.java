package com.pastsemester.repository;

import com.pastsemester.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adisor on 7/27/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User findBySsoId(String ssoId);
}
