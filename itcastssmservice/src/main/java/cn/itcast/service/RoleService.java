package cn.itcast.service;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    void delete(String id);

    List<Permission> findPermission(String id);

    void addRoleToUser(String roleId, String[] ids);
}
