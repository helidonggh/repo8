package cn.itcast.dao;

import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll();
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
    @Select("select * from product where id = #{id}")
    Product findById(String id);

    @Delete("delete from product where id = #{id}")
    void delete(String id);

    @Update("update product set productStatus = 1 where id = #{id}")
    void openStatus(String id);

    @Select("select * from product where productName like #{productName}")
    List<Product> findLike(String productName);
}
