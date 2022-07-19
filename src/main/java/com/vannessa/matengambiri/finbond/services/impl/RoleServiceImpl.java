package com.vannessa.matengambiri.finbond.services.impl;

import com.vannessa.matengambiri.finbond.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.vannessa.matengambiri.finbond.repositories.RoleRepository;
import com.vannessa.matengambiri.finbond.services.RoleService;

import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService {

    private final static Logger log = LoggerFactory.getLogger(RoleService.class);
    private final RoleRepository roleRepository;

    private RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        log.info("Request to save role: {}", role);
        return this.roleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(Long id) {
        log.info("Request to get role by id:{}", id);
        return this.roleRepository.findById(id);
    }

    @Override
    public Page<Role> findAllByPage(Pageable pageable) {
        log.info("Request to roles by pageable: {}", pageable);
        return this.roleRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        log.info("Request To delete role by id: {} ", id);
        roleRepository.deleteById(id);
    }

    @Override
    public void delete(Role role) {
        log.info("Request to delete role by role:{}", role);
        roleRepository.delete(role);
    }
}
