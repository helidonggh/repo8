package cn.itcast.service;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findAllRoles(String id);

    void addRoleToUser(String userId, String id);
}
