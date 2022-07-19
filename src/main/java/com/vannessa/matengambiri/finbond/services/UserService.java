package com.vannessa.matengambiri.finbond.services;

import com.vannessa.matengambiri.finbond.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public static final int MAX_FAILED_ATTEMPTS = 5;

    User save(User user);
    Page<User> findAllUser(Pageable pageable);
    User findById(Long id);

    void delete(Long id);

    void delete(User user);

    User findUserByUsernameAndPassword(String username, String password);

}
