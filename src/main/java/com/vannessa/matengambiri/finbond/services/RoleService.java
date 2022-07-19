package com.vannessa.matengambiri.finbond.services;

import com.vannessa.matengambiri.finbond.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface RoleService {
    Role save (Role role);
    Optional<Role> findById(Long id);
    Page<Role> findAllByPage(Pageable pageable);
    void delete (Long id);
    void delete (Role role);

}
