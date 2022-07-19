package com.vannessa.matengambiri.finbond.web.rest;


import com.vannessa.matengambiri.finbond.model.User;
import com.vannessa.matengambiri.finbond.model.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vannessa.matengambiri.finbond.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserResource {

    private final static Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) throws Exception {
        log.info("Rest Request To save user:{} ", user);
        if(user.getId() != null){
            throw new Exception("Can not create new role with id.");
        }
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user")
    public ResponseEntity<Page<User>> findAllUser(Pageable pageable) {
        log.info("Rest Request to get user by page:{}", pageable);
        return ResponseEntity.ok(userService.findAllUser(pageable));
    }

    @PutMapping("/user")
    public ResponseEntity<User> update(@RequestBody User user) throws Exception {
        log.info("Rest Request To save user: {}", user);
        if(user.getId() == null){
            throw new Exception("Can not update role with idnull.");
        }
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        log.info("Rest Request to get a user by id :{}", id);
        User result = userService.findById(id);
        return ResponseEntity.ok(result);

    }

    @PostMapping("user/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody UserDto userDto) {
        log.info("Rest Request to authenticate :{}", userDto);
        User result = userService.findUserByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
       if (result != null){
           return  ResponseEntity.ok(result);
       }
        return ResponseEntity.ok(null);


    }


}