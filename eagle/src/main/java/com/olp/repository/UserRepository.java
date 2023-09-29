package com.olp.repository;

import com.olp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value="Select * from user_tb where email=?1 and active_status=?2", nativeQuery = true)
    public UserEntity findByEmailAndActiveStatus(String email,String activeStatus);
}
