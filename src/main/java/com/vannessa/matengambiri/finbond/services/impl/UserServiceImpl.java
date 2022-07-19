package com.vannessa.matengambiri.finbond.services.impl;

import com.vannessa.matengambiri.finbond.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.vannessa.matengambiri.finbond.repositories.UserRepository;
import com.vannessa.matengambiri.finbond.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        log.info("Request To Save user : {} ", user);
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        log.info("Request To get All user");
        Page<User> all = userRepository.findAll(pageable);
        return all;

    }

    @Override
    public User findById(Long id) {
        log.info("Request To get by id :{}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        log.info("Request To delete user by id");
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        log.info("Request To delete user");
        userRepository.delete(user);

    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        log.info("Request To find by username and password: {} {} ", username, password);
        return userRepository.findUserByUsernameAndPassword(username, password);
    }


}
