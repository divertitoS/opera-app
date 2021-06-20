package com.dev.opera.dao;

import com.dev.opera.model.Role;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}
