package com.vannessa.matengambiri.finbond.repositories;

import com.vannessa.matengambiri.finbond.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String username, String password);
}
