package cn.itcast.dao;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;

import javax.rmi.PortableRemoteObject;
import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many=@Many(select = "cn.itcast.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRolesByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();
    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many=@Many(select = "cn.itcast.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id);

    @Delete("delete from role where id = #{id}")
    void delete(String id);

    @Select("select * from role where id in (select roleId from role_permission where permissionId = #{id})")
    List<Role> findByPermissionId(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermission(String id);

    @Insert("insert into role_permission values(#{id},#{roleId})")
    void addRoleToUser(@Param("roleId") String userId,@Param("id") String id);
}
