package com.shopme.shopme.user;

import common.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Optional<Role> findRoleById(Integer id){return roleRepository.findById(id);}
}
