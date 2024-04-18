package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.Role;

public interface RoleDao {

    Role findRoleByName(String roleName);
}
