package com.shopme.shopme.user;


import common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u from User u where u.email=:email")
    public User getUserByEmail(@Param("email") String email);
    public Long countById(Integer id);

    @Query("UPDATE User u SET u.enabled=?2 where u.id=?1")
    @Modifying
    public void updateEnabledStatus(Integer id,boolean enabled);
}
