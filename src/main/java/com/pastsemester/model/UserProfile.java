package com.pastsemester.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
@Getter
@Setter
@EqualsAndHashCode
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ",  type=" + type + "]";
    }

}
