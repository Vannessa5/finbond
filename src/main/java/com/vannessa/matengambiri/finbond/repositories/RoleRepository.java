package com.vannessa.matengambiri.finbond.repositories;

import com.vannessa.matengambiri.finbond.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
