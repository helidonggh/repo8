package cn.itcast.service.impl;

import cn.itcast.dao.UserInfoDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    //引入加密类，对密码进行加密
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findUserByUsername(username);
        User user = null;
        if (userInfo != null) {
//            user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoles()));
            user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        }
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }
    @Override
    public List<UserInfo> findAll(){
       return userInfoDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        String password = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(password);
        userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userInfoDao.findById(id);
    }

    @Override
    public List<Role> findAllRoles(String id) {
        return userInfoDao.findAllRoles(id);
    }

    @Override
    public void addRoleToUser(String userId, String id) {
        userInfoDao.addRoleToUser(userId,id);
    }
}
