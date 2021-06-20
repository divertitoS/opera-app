package com.dev.opera.service;

import com.dev.opera.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}
