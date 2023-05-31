package com.example.shopmanagerment.repository;

import com.example.shopmanagerment.enums.EnumRole;
import com.example.shopmanagerment.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findRoleByRoleName(EnumRole role);
}
