package com.vannessa.matengambiri.finbond.web.rest;

import com.vannessa.matengambiri.finbond.services.RoleService;
import com.vannessa.matengambiri.finbond.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RoleResource {

    private final static Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<Role> save(@RequestBody Role role) throws Exception {
        log.info("Request register role :{}", role);
        if (role.getId() != null) {
            throw new Exception("cannot save a new role with id.");
        }
        Role result = roleService.save(role);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity findById( @PathVariable Long id) {
        log.info("Request to get role by id :{}", id);
        return ResponseEntity.ok(roleService.findById(id));
    }

    @GetMapping("/role")
    public ResponseEntity<Page<Role>> findAllByPage(Pageable pageable) {
        log.info("Request to get role by page:{}", pageable);
        return ResponseEntity.ok(roleService.findAllByPage(pageable));
    }

    @PutMapping("/role")
    public ResponseEntity<Role> update(@RequestBody Role role) throws Exception {
        log.info("Request to update role : {}", role);
        if (role.getId() == null) {
            throw new Exception("can not update user without Id");
        }
        Role result = roleService.save(role);
        return ResponseEntity.ok(result);
    }


}