package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    Permission findByRoleId(String id);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permissionName"),
            @Result(property = "url",column = "url"),
            @Result(property = "roles",column = "id",javaType = List.class,many=@Many(select = "cn.itcast.dao.RoleDao.findByPermissionId"))
    })
    Permission findById(String id);

    @Delete("delete from permission where id = #{id}")
    void delete(String id);
}
