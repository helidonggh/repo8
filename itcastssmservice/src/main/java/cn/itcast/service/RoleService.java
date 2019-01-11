package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    void delete(String id);
}
