package cn.itcast.service;

import cn.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String id);

    void delete(String id);
}
