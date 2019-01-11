package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoDao {


    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many=@Many(select = "cn.itcast.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findUserByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();
    @Insert("insert into users(username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many=@Many(select = "cn.itcast.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from users where id in (select userId from users_role where roleId = #{id})")
    List<UserInfo> findByRoleId(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findAllRoles(String id);
    @Insert("insert into users_role values(#{userId},#{id})")
    void addRoleToUser(@Param("userId") String userId,@Param("id") String id);
}
