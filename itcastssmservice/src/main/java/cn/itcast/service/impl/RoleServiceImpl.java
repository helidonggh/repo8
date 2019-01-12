package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void delete(String id) {
        roleDao.delete(id);
    }

    @Override
    public List<Permission> findPermission(String id) {
        return roleDao.findPermission(id);
    }

    @Override
    public void addRoleToUser(String roleId, String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            roleDao.addRoleToUser(roleId,ids[i]);
        }
    }
}
